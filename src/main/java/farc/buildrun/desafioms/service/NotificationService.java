package farc.buildrun.desafioms.service;

import farc.buildrun.desafioms.controller.dto.ScheduleNotificationDto;
import farc.buildrun.desafioms.entity.Notification;
import farc.buildrun.desafioms.entity.Status;
import farc.buildrun.desafioms.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    public NotificationService(NotificationRepository notificationRepository, EmailService emailService) {
        this.notificationRepository = notificationRepository;
        this.emailService = emailService;
    }

    public void scheduleNotification(ScheduleNotificationDto dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = notificationRepository.findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(Status.Values.PENDING.toStatus(), Status.Values.ERROR.toStatus()),
                dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {
            try {
                emailService.sendEmail(notification.getDestination(), "Notification", notification.getMessage());
                notification.setStatus(Status.Values.SUCCESS.toStatus());
            } catch (Exception e) {
                notification.setStatus(Status.Values.ERROR.toStatus());
            }
            notificationRepository.save(notification);
        };
    }
}

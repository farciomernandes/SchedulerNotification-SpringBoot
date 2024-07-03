package farc.buildrun.desafioms.repository;

import farc.buildrun.desafioms.entity.Notification;
import farc.buildrun.desafioms.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List <Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
package farc.buildrun.desafioms.controller.dto;

import farc.buildrun.desafioms.entity.Channel;
import farc.buildrun.desafioms.entity.Notification;
import farc.buildrun.desafioms.entity.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime, String destination, String message, Channel.Values channel) {

    public Notification toNotification() {
        return  new Notification(dateTime,destination, message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus());
    }
}

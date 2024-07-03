package farc.buildrun.desafioms.scheduler;

import farc.buildrun.desafioms.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class DesafioTaskScheduler {
    Logger logger = LoggerFactory.getLogger(DesafioTaskScheduler.class);

    private final NotificationService notificationService;

    public DesafioTaskScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(timeUnit = TimeUnit.MINUTES, fixedDelay = 1)
    public void checkTasks() {
        var dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);
        notificationService.checkAndSend(dateTime);
    }
}

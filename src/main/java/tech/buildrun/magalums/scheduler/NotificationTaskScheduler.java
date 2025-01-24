package tech.buildrun.magalums.scheduler;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tech.buildrun.magalums.service.NotificationService;

@Component
public class NotificationTaskScheduler {

    @Autowired
    private NotificationService notificationService;

    private static final Logger logger = LoggerFactory.getLogger(NotificationTaskScheduler.class);

    @Scheduled(fixedDelay =60000)
    public void checkTasks (){
        var dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);
        notificationService.checkAndSend(dateTime);
    }
}

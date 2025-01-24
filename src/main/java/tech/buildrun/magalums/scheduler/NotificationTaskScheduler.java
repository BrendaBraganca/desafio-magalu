package tech.buildrun.magalums.scheduler;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationTaskScheduler {

    private static final Logger logger = LoggerFactory.getLogger(NotificationTaskScheduler.class);

    @Scheduled(fixedDelay =60000)
    public void runTasks (){
        var dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);
    }
}

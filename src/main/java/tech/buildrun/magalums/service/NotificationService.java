package tech.buildrun.magalums.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.buildrun.magalums.controller.dto.NotificationDTO;
import tech.buildrun.magalums.repository.NotificationRepository;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(NotificationDTO notificationDTO){
        notificationRepository.save(notificationDTO.toNotification());
    }
}

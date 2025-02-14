package tech.buildrun.magalums.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.buildrun.magalums.controller.dto.NotificationDTO;
import tech.buildrun.magalums.entity.Notification;
import tech.buildrun.magalums.entity.Status;
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

    public Optional<Notification> findById(Long notificationId){
       return  notificationRepository.findById(notificationId);
    };

    public void cancelNotification(Long notificationId){
        var notification = findById(notificationId);
        if(notification.isPresent()){
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime){
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(List.of(Status.Values.PENDING.toStatus(), Status.Values.ERROR.toStatus()), dateTime);
        
        notifications.forEach(n -> {
            // realiza envio da notificacao
            n.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(n);
        });
    }

}

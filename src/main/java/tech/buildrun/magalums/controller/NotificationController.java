package tech.buildrun.magalums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.buildrun.magalums.controller.dto.NotificationDTO;
import tech.buildrun.magalums.entity.Notification;
import tech.buildrun.magalums.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody NotificationDTO notificationDTO){
        notificationService.scheduleNotification(notificationDTO);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable("notificationId") Long notificationId){
        var notification = notificationService.findById(notificationId);
        System.out.println("NOTIFICATION ID: " + notificationId);

        if(notification.isEmpty()){
            return ResponseEntity.notFound().build();     
        } 
        return ResponseEntity.ok(notification.get());
    }

}

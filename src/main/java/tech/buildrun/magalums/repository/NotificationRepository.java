package tech.buildrun.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.buildrun.magalums.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}

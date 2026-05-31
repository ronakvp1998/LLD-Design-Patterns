package com.lldproblems.linkedin.services;

import com.lldproblems.linkedin.entities.Member;
import com.lldproblems.linkedin.entities.Notification;

public class NotificationService {
    public void sendNotification(Member member, Notification notification) {
        // In a real system, this would push to a queue or a websocket.
        // Here, we directly call the member's update method.
        member.update(notification);
    }
}

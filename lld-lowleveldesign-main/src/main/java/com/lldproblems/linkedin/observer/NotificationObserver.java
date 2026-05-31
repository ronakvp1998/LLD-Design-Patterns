package com.lldproblems.linkedin.observer;

import com.lldproblems.linkedin.entities.Notification;

public interface NotificationObserver {
    void update(Notification notification);
}

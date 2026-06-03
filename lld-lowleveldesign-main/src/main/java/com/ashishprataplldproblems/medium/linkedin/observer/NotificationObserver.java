package com.ashishprataplldproblems.medium.linkedin.observer;

import com.ashishprataplldproblems.medium.linkedin.entities.Notification;

public interface NotificationObserver {
    void update(Notification notification);
}

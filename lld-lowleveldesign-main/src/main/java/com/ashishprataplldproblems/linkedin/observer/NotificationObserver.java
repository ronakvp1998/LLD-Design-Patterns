package com.ashishprataplldproblems.linkedin.observer;

import com.ashishprataplldproblems.linkedin.entities.Notification;

public interface NotificationObserver {
    void update(Notification notification);
}

package com.bytebytego.shipping_locker.shippinglocker;

import shippinglocker.account.Account;

public interface NotificationInterface {
    void sendNotification(String message, Account user);
}

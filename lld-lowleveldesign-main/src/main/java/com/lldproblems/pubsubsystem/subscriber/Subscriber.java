package com.lldproblems.pubsubsystem.subscriber;

import com.lldproblems.pubsubsystem.entities.Message;

public interface Subscriber {
    String getId();
    void onMessage(Message message);
}

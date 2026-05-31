package com.ashishprataplldproblems.pubsubsystem.subscriber;

import com.ashishprataplldproblems.pubsubsystem.entities.Message;

public interface Subscriber {
    String getId();
    void onMessage(Message message);
}

package com.ashishprataplldproblems.medium.pubsubsystem.subscriber;

import com.ashishprataplldproblems.medium.pubsubsystem.entities.Message;

public interface Subscriber {
    String getId();
    void onMessage(Message message);
}

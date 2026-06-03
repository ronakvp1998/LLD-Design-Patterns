package com.ashishprataplldproblems.medium.onlineauctionsystem.observer;

import com.ashishprataplldproblems.medium.onlineauctionsystem.entities.Auction;

public interface AuctionObserver {
    void onUpdate(Auction auction, String message);
}

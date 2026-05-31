package com.ashishprataplldproblems.onlineauctionsystem.observer;

import com.ashishprataplldproblems.onlineauctionsystem.entities.Auction;

public interface AuctionObserver {
    void onUpdate(Auction auction, String message);
}

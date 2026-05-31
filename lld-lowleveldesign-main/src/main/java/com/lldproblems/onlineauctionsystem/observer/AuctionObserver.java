package com.lldproblems.onlineauctionsystem.observer;

import com.lldproblems.onlineauctionsystem.entities.Auction;

public interface AuctionObserver {
    void onUpdate(Auction auction, String message);
}

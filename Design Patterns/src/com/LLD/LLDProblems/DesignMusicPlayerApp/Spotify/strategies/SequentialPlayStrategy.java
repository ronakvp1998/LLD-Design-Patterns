package com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.strategies;

import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.models.Playlist;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.models.Song;

public class SequentialPlayStrategy implements PlayStrategy {
    private Playlist currentPlaylist;
    private int currentIndex;

    public SequentialPlayStrategy() {
        currentPlaylist = null;
        currentIndex = -1;
    }

    @Override
    public void setPlaylist(Playlist playlist) {
        currentPlaylist = playlist;
        currentIndex = -1;
    }

    @Override
    public boolean hasNext() {
        return ((currentIndex + 1) < currentPlaylist.getSize());
    }

    // Next in Loop
    @Override
    public Song next() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        currentIndex = currentIndex + 1;
        return currentPlaylist.getSongs().get(currentIndex);
    }

    @Override
    public boolean hasPrevious() {
        return (currentIndex - 1 > 0);
    }

    // previous in Loop
    @Override
    public Song previous() {
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        currentIndex = currentIndex - 1;
        return currentPlaylist.getSongs().get(currentIndex);
    }
}

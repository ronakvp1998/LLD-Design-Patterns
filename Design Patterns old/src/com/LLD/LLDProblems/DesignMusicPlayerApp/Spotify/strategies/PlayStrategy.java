package com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.strategies;

import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.models.Playlist;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.models.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    Song next();
    boolean hasNext();
    Song previous();
    boolean hasPrevious();
    default void addToNext(Song song) {}
}

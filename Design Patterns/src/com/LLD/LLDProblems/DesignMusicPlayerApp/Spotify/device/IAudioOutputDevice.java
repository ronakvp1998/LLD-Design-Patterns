package com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.device;

import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.models.Song;

public interface IAudioOutputDevice {
    void playAudio(Song song);
}

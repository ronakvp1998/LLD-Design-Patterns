package com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.device;

import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.models.Song;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.external.WiredSpeakerAPI;

public class WiredSpeakerAdapter implements IAudioOutputDevice {
    private WiredSpeakerAPI wiredApi;

    public WiredSpeakerAdapter(WiredSpeakerAPI api) {
        this.wiredApi = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        wiredApi.playSoundViaCable(payload);
    }
}

package com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.device;

import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.models.Song;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.external.HeadphonesAPI;

public class HeadphonesAdapter implements IAudioOutputDevice {
    private HeadphonesAPI headphonesApi;

    public HeadphonesAdapter(HeadphonesAPI api) {
        this.headphonesApi = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        headphonesApi.playSoundViaJack(payload);
    }
}

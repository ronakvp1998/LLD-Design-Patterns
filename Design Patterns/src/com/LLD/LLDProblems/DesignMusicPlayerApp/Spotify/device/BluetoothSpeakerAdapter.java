package com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.device;

import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.models.Song;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.external.BluetoothSpeakerAPI;

public class BluetoothSpeakerAdapter implements IAudioOutputDevice {
    private BluetoothSpeakerAPI bluetoothApi;

    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI api) {
        this.bluetoothApi = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        bluetoothApi.playSoundViaBluetooth(payload);
    }
}

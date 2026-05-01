package com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.factories;

import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.device.IAudioOutputDevice;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.device.BluetoothSpeakerAdapter;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.device.HeadphonesAdapter;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.device.WiredSpeakerAdapter;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.external.BluetoothSpeakerAPI;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.external.HeadphonesAPI;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.external.WiredSpeakerAPI;
import com.LLD.LLDProblems.DesignMusicPlayerApp.Spotify.enums.DeviceType;


public class DeviceFactory {
    public static IAudioOutputDevice createDevice(DeviceType deviceType) {
        switch (deviceType) {
            case BLUETOOTH:
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case WIRED:
                return new WiredSpeakerAdapter(new WiredSpeakerAPI());
            case HEADPHONES:
            default:
                return new HeadphonesAdapter(new HeadphonesAPI());
        }
    }
}

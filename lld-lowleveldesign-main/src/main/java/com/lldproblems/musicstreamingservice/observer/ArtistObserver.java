package com.lldproblems.musicstreamingservice.observer;

import com.lldproblems.musicstreamingservice.entities.Album;
import com.lldproblems.musicstreamingservice.entities.Artist;

public interface ArtistObserver {
    void update(Artist artist, Album newAlbum);
}

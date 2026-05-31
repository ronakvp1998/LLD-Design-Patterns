package com.ashishprataplldproblems.musicstreamingservice.observer;

import com.ashishprataplldproblems.musicstreamingservice.entities.Album;
import com.ashishprataplldproblems.musicstreamingservice.entities.Artist;

public interface ArtistObserver {
    void update(Artist artist, Album newAlbum);
}

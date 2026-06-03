package com.ashishprataplldproblems.hard.musicstreamingservice.observer;

import com.ashishprataplldproblems.hard.musicstreamingservice.entities.Album;
import com.ashishprataplldproblems.hard.musicstreamingservice.entities.Artist;

public interface ArtistObserver {
    void update(Artist artist, Album newAlbum);
}

package pl.com.bottega.cms.model.repositories;

import pl.com.bottega.cms.model.Show;

import java.util.Optional;

public interface ShowRepository {
    void save(Show show);

    Optional<Show> getShow(Long showId);
}

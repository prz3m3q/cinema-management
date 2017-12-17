package pl.com.bottega.cms.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cms.model.Movie;
import pl.com.bottega.cms.model.repositories.MovieRepository;

import javax.persistence.EntityManager;

@Component
public class JPAMovieRepository implements MovieRepository {

    private EntityManager entityManager;

    public JPAMovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Movie movie) {
        entityManager.persist(movie);
    }
}

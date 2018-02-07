package pl.com.bottega.cms.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cms.model.Show;
import pl.com.bottega.cms.model.repositories.ShowRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

@Component
public class JPAShowRepository implements ShowRepository {

    private EntityManager entityManager;

    public JPAShowRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Show show) {
        entityManager.persist(show);
    }

    @Override
    public Optional<Show> getShow(Long showId) {
        try {
            Show show= (Show) entityManager.createQuery("FROM Show s WHERE s.showId = :id")
                    .setParameter( "id", showId).getSingleResult();
            return Optional.of(show);
        }
        catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}

package pl.com.bottega.cms.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cms.application.CinemaDto;
import pl.com.bottega.cms.application.CinemaFinder;
import pl.com.bottega.cms.model.Cinema;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Component
public class JPACinemaFinder implements CinemaFinder{

    public JPACinemaFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    public List<CinemaDto> getAll() {
            List<CinemaDto> resultList= entityManager.createQuery("SELECT NEW pl.com.bottega.cms.application.CinemaDto(c.id, c.name,c.city) FROM Cinema c").getResultList();
            return resultList;
    }
}

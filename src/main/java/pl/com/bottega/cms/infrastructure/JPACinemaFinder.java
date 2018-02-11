package pl.com.bottega.cms.infrastructure;

        import org.springframework.stereotype.Component;
        import pl.com.bottega.cms.application.CinemaDto;
        import pl.com.bottega.cms.application.CinemaFinder;
        import pl.com.bottega.cms.application.CinemaHallDto;

        import javax.persistence.EntityManager;
        import java.util.List;
        import java.util.Set;

@Component
public class JPACinemaFinder implements CinemaFinder {

    public JPACinemaFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    public List<CinemaDto> getAll() {
        List<CinemaDto> resultList= entityManager.createQuery("SELECT NEW pl.com.bottega.cms.application.CinemaDto(c.id, c.name,c.city) FROM Cinema c").getResultList();
        return resultList;
    }

    CinemaHallDto getSeats(Long showId){
        CinemaHallDto cinemaHallDto =(CinemaHallDto) entityManager.createQuery("SELECT NEW pl.com.bottega.cms.application.CinemaHallDto(s.free, s.occupied) " +
                "FROM Seat s").getParameters();
        return cinemaHallDto;
    }


}

package pl.com.bottega.cms.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.cms.application.MovieDto;
import pl.com.bottega.cms.application.MovieFinder;
import pl.com.bottega.cms.model.Movie;
import pl.com.bottega.cms.model.Show;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JPAMovieFinder implements MovieFinder {

    private EntityManager entityManager;

    public JPAMovieFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<MovieDto> getMovies(long cinemaId, LocalDate date) {
        LocalDateTime minDate = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime maxDate = LocalDateTime.of(date, LocalTime.MAX);
        List<Movie> results = entityManager.createQuery("SELECT m FROM Movie m JOIN Show s ON s.movie.id = m.id WHERE s.cinema.id = :cinema_id AND s.date BETWEEN :min_date AND :max_date")
            .setParameter("cinema_id", cinemaId)
            .setParameter("min_date", minDate)
            .setParameter("max_date", maxDate)
            .getResultList();

        return results.stream().map(m -> m.removeShows(date)).map(movie -> new MovieDto(movie)).collect(Collectors.toList());
    }
}

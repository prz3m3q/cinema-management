package pl.com.bottega.cms.model;

import org.springframework.stereotype.Component;
import pl.com.bottega.cms.model.commands.CreateShowsCommand;
import pl.com.bottega.cms.model.repositories.CinemaRepository;
import pl.com.bottega.cms.model.repositories.MovieRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ShowFactory {

    private MovieRepository movieRepository;
    private CinemaRepository cinemaRepository;

    public ShowFactory(MovieRepository movieRepository, CinemaRepository cinemaRepository) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
    }

    public Collection<Show> createShows(CreateShowsCommand cmd) {
        Movie movie = movieRepository.get(cmd.getMovieId());
        Cinema cinema = cinemaRepository.get(cmd.getCinemaId());
        if (cmd.getCalendar() == null) {
            return createShowsWithDates(cmd, cinema, movie);
        }
        return createShowsWithCalendar(cmd, cinema, movie);
    }

    private Collection<Show> createShowsWithCalendar(CreateShowsCommand cmd, Cinema cinema, Movie movie) {
        Collection<Show> shows = new ArrayList<>();
        for (LocalDate currentDate = cmd.getCalendar().getFromDate().toLocalDate(); !currentDate.isAfter(cmd.getCalendar().getUntilDate().toLocalDate()); currentDate = currentDate.plusDays(1)) {
            String dayOfWeekFromDate = currentDate.getDayOfWeek().name().toUpperCase();
            if (!cmd.getCalendar().getWeekDays().stream().anyMatch(dayOfWeek -> dayOfWeek.toUpperCase().equals(dayOfWeekFromDate))) {
                continue;
            }
            for (LocalTime time : cmd.getCalendar().getHours()) {
                LocalDateTime showDateTime = LocalDateTime.of(currentDate, time);
                if (!showDateTime.isBefore(cmd.getCalendar().getFromDate()) && !showDateTime.isAfter(cmd.getCalendar().getUntilDate())) {
                    shows.add(new Show(cinema, movie, showDateTime));
                }
            }
        }
        return shows;
    }

    private Collection<Show> createShowsWithDates(CreateShowsCommand cmd, Cinema cinema, Movie movie) {
        return cmd.getDates().stream().map((d) -> new Show(cinema, movie, d)).collect(Collectors.toList());
    }

}

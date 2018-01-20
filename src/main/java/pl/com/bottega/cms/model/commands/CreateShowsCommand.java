package pl.com.bottega.cms.model.commands;

import java.time.LocalDateTime;
import java.util.Set;

public class CreateShowsCommand implements Command {
    private Long movieId;
    private Long cinemaId;
    private Set<LocalDateTime> dates;
    private ShowsCalendar calendar;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Set<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(Set<LocalDateTime> dates) {
        this.dates = dates;
    }

    public ShowsCalendar getCalendar() {
        return calendar;
    }

    public void setCalendar(ShowsCalendar calendar) {
        this.calendar = calendar;
    }

    public void validate(ValidationErrors errors){
        validatePresence(errors,"movieId", movieId);
        validatePresence(errors,"cinemaId", cinemaId);
        validatePresence(errors,"dates", dates, "calendar", calendar);
    }
}

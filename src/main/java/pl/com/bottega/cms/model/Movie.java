package pl.com.bottega.cms.model;

import pl.com.bottega.cms.model.commands.CreateMovieCommand;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    @ElementCollection
    @CollectionTable(
        name="movie_actors",
        joinColumns=@JoinColumn(name="movie_id")
    )
    @Column(name = "actors")
    private Set<String> actors = new HashSet<>();

    @ElementCollection
    @CollectionTable(
        name="movie_genres",
        joinColumns=@JoinColumn(name="movie_id")
    )
    @Column(name = "genres")
    private Set<String> genres = new HashSet<>();

    @Column(name = "min_age")
    private Integer minAge;

    private Integer length;

    @OneToMany
    @JoinColumn(name = "movie_id")
    private Collection<Show> shows = new LinkedList<>();

    public Movie(CreateMovieCommand command) {
        this.title = command.getTitle();
        this.description = command.getDescription();
        this.actors = command.getActors();
        this.genres = command.getGenres();
        this.minAge = command.getMinAge();
        this.length = command.getLength();
    }

    public Movie(Movie movie) {
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.actors = movie.getActors();
        this.genres = movie.getGenres();
        this.minAge = movie.getMinAge();
        this.length = movie.getLength();
    }

    public Movie removeShows(LocalDate date) {
        this.shows.removeIf(show -> !show.getDate().toLocalDate().isEqual(date));
        return this;
    }

    public Movie() {}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getActors() {
        return actors;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public Integer getLength() {
        return length;
    }

    public Collection<Show> getShows() {
        return shows;
    }
}

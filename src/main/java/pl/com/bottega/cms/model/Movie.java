package pl.com.bottega.cms.model;

import pl.com.bottega.cms.model.commands.CalculatePricesCommand;
import pl.com.bottega.cms.model.commands.CreateMovieCommand;
import pl.com.bottega.cms.model.commands.SetTicketPricesCommand;

import javax.persistence.*;
import java.math.BigDecimal;
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
            name ="ticket_prices",
            joinColumns =@JoinColumn(name="move_id")
    )

    private Map<String,BigDecimal> prices;

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

    public Movie removeShowsWithoutDate(LocalDate date) {
        this.shows.removeIf(show -> !show.isTakePlaceInDate(date));
        return this;
    }

    public void setPrices(SetTicketPricesCommand cmd){

    }

    Receipt calculate(CalculatePricesCommand cmd){
        TicketPrieces ticketPrieces = new TicketPrieces(cmd);
        return ticketPrieces.calculate(prices);
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

    public Map<String,BigDecimal> getPrices() { return prices; }

    public void setPrices(Map<String, BigDecimal> prices) {
        this.prices = prices;
    }
}

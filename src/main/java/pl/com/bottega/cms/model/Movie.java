package pl.com.bottega.cms.model;

import pl.com.bottega.cms.model.commands.CreateMovieCommand;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    @ElementCollection
    private Set<String> actors = new HashSet<>();

    @ElementCollection
    private Set<String> genres = new HashSet<>();

    @Column(name = "min_age")
    private Integer minAge;

    private Integer length;

    public Movie(CreateMovieCommand command) {
        this.title = command.getTitle();
        this.description = command.getDescription();
        this.actors = command.getActors();
        this.genres = command.getGenres();
        this.minAge = command.getMinAge();
        this.length = command.getLength();
    }

    public Movie() {}
}

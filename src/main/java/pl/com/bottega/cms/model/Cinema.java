package pl.com.bottega.cms.model;

import pl.com.bottega.cms.model.commands.CreateCinemaCommand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cinema {
    public Cinema(){}

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String city;

    public Cinema(CreateCinemaCommand cmd) {
        this.name=cmd.getName();
        this.city=cmd.getCity();
    }
}

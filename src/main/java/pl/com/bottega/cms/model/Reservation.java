package pl.com.bottega.cms.model;

import org.springframework.beans.factory.annotation.Autowired;
import pl.com.bottega.cms.model.commands.CreateReservationCommand;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "show_id")
    private Long showId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private Collection<Seat> seats = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private Collection<Ticket> tickets = new LinkedList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Reservation(CreateReservationCommand cmd) {
        this.showId = cmd.getShowId();
        this.customer = cmd.getCustomer();
        this.seats = cmd.getSeats();
        this.tickets = cmd.getTickets();
    }

    public Reservation() {}

    public Collection<Seat> getSeats() {
        return seats;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Long getId() {
        return id;
    }
}

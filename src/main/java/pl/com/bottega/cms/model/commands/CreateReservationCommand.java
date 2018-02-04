package pl.com.bottega.cms.model.commands;

import pl.com.bottega.cms.model.Customer;
import pl.com.bottega.cms.model.Seat;
import pl.com.bottega.cms.model.Show;
import pl.com.bottega.cms.model.Ticket;

import java.util.Set;

public class CreateReservationCommand implements Command {
    Long showId;
    Customer customer;
    Set<Ticket> tickets;
    Set<Seat> seats;

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
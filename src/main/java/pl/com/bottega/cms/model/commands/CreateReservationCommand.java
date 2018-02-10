package pl.com.bottega.cms.model.commands;

import pl.com.bottega.cms.model.Customer;
import pl.com.bottega.cms.model.Seat;
import pl.com.bottega.cms.model.Ticket;

import java.util.Set;

public class CreateReservationCommand implements Command {
    Long showId;
    Customer customer;
    Set<Ticket> tickets;
    Set<Seat> seats;

    public void validate(ValidationErrors errors) {
        validatePresence(errors, "tickets", tickets);
        validateUniqueTicketsKind(errors, "tickets", tickets);
        validateTicketAmount(errors, "tickets", tickets);
        validateSeats(errors, "seats", seats);
        validatePresence(errors, "firstName", customer.getFirstName());
        validatePresence(errors, "lastName", customer.getLastName());
        validatePresence(errors, "email", customer.getEmail());
        validateEmail(errors, "email", customer.getEmail());
        validatePresence(errors, "phone", customer.getPhone());
    }

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
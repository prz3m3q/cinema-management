package pl.com.bottega.cms.model.commands;

import pl.com.bottega.cms.model.Ticket;

import java.util.Set;

public class CalculatePricesCommand implements Command {

    Long showId;

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    Set<Ticket> tickets;
}

package pl.com.bottega.cms.model.commands;

import pl.com.bottega.cms.infrastructure.NoSuchEntityException;
import pl.com.bottega.cms.model.Show;
import pl.com.bottega.cms.model.Ticket;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CalculatePricesCommand implements Command {

    Long showId;
    Set<Ticket> tickets;
    List<String> listKind;


    @Override
    public void validate(ValidationErrors errors) {
        validatePresence(errors,"showId",showId);
        validatePresence(errors, "Tickets", tickets);

        listKind = tickets.stream().map(ticket -> ticket.getKind()).collect(Collectors.toList());
        validateDuplicatte(errors,"Ticket Kind",listKind);

        for( Ticket ticket : tickets) {

            if (ticket.getKind().isEmpty() || ticket.getKind() == null)
                errors.add("Ticket", "can not be empty");

            if(ticket.getCount() <= 0)
                errors.add("Count","can not be 0 and must be positive");
        }
    }


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


}

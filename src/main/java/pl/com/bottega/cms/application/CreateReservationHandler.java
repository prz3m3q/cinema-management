package pl.com.bottega.cms.application;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.cms.model.CinemaHall;
import pl.com.bottega.cms.model.Reservation;
import pl.com.bottega.cms.model.commands.Command;
import pl.com.bottega.cms.model.commands.CreateReservationCommand;
import pl.com.bottega.cms.model.repositories.ReservationRepository;

import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class CreateReservationHandler implements Handler<CreateReservationCommand, ReservationDto> {

    private ReservationRepository reservationRepository;

    public CreateReservationHandler(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public ReservationDto handle(CreateReservationCommand cmd) {
        Set<Reservation> currentReservations = reservationRepository.getReservations(cmd.getShowId());
        CinemaHall cinemaHall = new CinemaHall(currentReservations);
        if (!cinemaHall.checkReservation(cmd)) {
            throw new NoSuchElementException("Nie można dokonać rezerwacji.");
        }
        Reservation reservation = new Reservation(cmd);
        reservationRepository.save(reservation);
        return new ReservationDto(reservation);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return CreateReservationCommand.class;
    }
}

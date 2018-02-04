package pl.com.bottega.cms.application;

import pl.com.bottega.cms.model.Reservation;

public class ReservationDto {

    Long id;

    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
    }
}

package pl.com.bottega.cms.application;

import pl.com.bottega.cms.model.Cinema;
import pl.com.bottega.cms.model.Seat;

import java.util.Set;

public class CinemaHallDto {
    Set<Seat> free;
    Set<Seat> occupied;

    private  Long showId;

    public CinemaHallDto(Long showId){

        this.showId = showId;
    }

    public Set<Seat> getFree() {
        return free;
    }

    public void setFree(Set<Seat> free) {
        this.free = free;
    }

    public Set<Seat> getOccupied() {
        return occupied;
    }

    public void setOccupied(Set<Seat> occupied) {
        this.occupied = occupied;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}

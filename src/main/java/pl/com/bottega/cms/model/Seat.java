package pl.com.bottega.cms.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer row;

    @Column(name = "seat_number")
    private Integer seat;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public Integer getRow() {
        int returnedRow = row;
        return --returnedRow;
    }

    public Integer getSeat() {
        int returnedSeat = seat;
        return --returnedSeat;
    }
}

package pl.com.bottega.cms.model;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    String kind;

    @Column
    int count;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

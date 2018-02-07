package pl.com.bottega.cms.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Map;

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

    public BigDecimal getPrice(Map<String,BigDecimal> prices) {
        return prices.get(this.kind).multiply(BigDecimal.valueOf(this.count));
    }

    public BigDecimal getUnitPrice(String kind, Map<String,BigDecimal> prices) {
        return prices.get(kind);
    }
}

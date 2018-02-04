package pl.com.bottega.cms.model;

import pl.com.bottega.cms.model.commands.CreateReservationCommand;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CinemaHall {

    public static final int ROWS = 10;
    public static final int SEATS = 15;

    boolean[][] seats;
    int[][] free;
    int maxSeatsNumber;

    public CinemaHall(Set<Reservation> currentReservations) {
        this.seats = new boolean[ROWS][SEATS];
        this.free = new int[ROWS][SEATS];
        for (Reservation reservation : currentReservations) {
            for (Seat seat : reservation.getSeats()) {
                seats[seat.getRow()][seat.getSeat()] = true;
            }
        }
        checkFree();
    }

    public boolean checkReservation(CreateReservationCommand cmd) {
        if (!isSeatsAvailable(cmd)) {
            return false;
        }
        if (cmd.getSeats().stream().count() > maxSeatsNumber) {
            return true;
        }
        if (!isTheSameRows(cmd)) {
            return false;
        }
        if (!isUniqueSetsNumbers(cmd)) {
            return false;
        }
        Seat prev = null;
        List<Seat> sortedSeats = getSortedSeats(cmd);
        for (Seat seat : sortedSeats) {
            if (free[seat.getRow()][seat.getSeat()] > sortedSeats.stream().count()) {
                return false;
            }
            if (prev != null && (prev.getSeat() + 1) != seat.getSeat()) {
                return false;
            }
            prev = seat;
        }

        return true;
    }

    private boolean isTheSameRows(CreateReservationCommand cmd) {
        return new HashSet<Integer>(cmd.getSeats().stream().map(s -> s.getRow()).collect(Collectors.toSet())).size() == 1;
    }

    private boolean isUniqueSetsNumbers(CreateReservationCommand cmd) {
        return new HashSet<Integer>(cmd.getSeats().stream().map(s -> s.getSeat()).collect(Collectors.toSet())).size() == cmd.getSeats().stream().count();
    }

    private boolean isSeatsAvailable(CreateReservationCommand cmd) {
        for (Seat seat : cmd.getSeats()) {
            if (seats[seat.getRow()][seat.getSeat()]) {
                return false;
            }
        }
        return true;
    }

    private void checkFree() {
        int rowNumber = 0;
        for (boolean[] row : seats) {
            for (int seatNumber = row.length-1; seatNumber >= 0; seatNumber--) {
                if (!row[seatNumber]) {
                    free[rowNumber][seatNumber] = 0;
                    continue;
                }
                if (row[seatNumber] && seatNumber < row.length-1) {
                    free[rowNumber][seatNumber] = free[rowNumber][seatNumber+1] + 1;
                    if (maxSeatsNumber < free[rowNumber][seatNumber]) {
                        maxSeatsNumber = free[rowNumber][seatNumber];
                    }
                    continue;
                }
                if (row[seatNumber] && seatNumber == row.length) {
                    free[rowNumber][seatNumber] = 1;
                    continue;
                }
                free[rowNumber][seatNumber] = 0;
            }
            rowNumber++;
        }
    }

    public List<Seat> getSortedSeats(CreateReservationCommand cmd) {
        return cmd.getSeats().stream().sorted((e1, e2) -> e1.getSeat().compareTo(e2.getSeat())).collect(Collectors.toList());
    }
}

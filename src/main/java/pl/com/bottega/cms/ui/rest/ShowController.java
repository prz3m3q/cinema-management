package pl.com.bottega.cms.ui.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cms.application.CinemaHallDto;

@RestController
public class ShowController {

    @GetMapping("//shows/{showId}/seats/")
   public CinemaHallDto getSeats(@PathVariable Long showId){
        CinemaHallDto cinemaHallDto = new CinemaHallDto(showId);
        return cinemaHallDto;
    };
}

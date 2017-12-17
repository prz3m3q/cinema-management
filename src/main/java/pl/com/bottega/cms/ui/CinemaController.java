package pl.com.bottega.cms.ui;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cms.application.CinemaDto;
import pl.com.bottega.cms.application.CinemaFinder;
import pl.com.bottega.cms.application.CommandGateway;
import pl.com.bottega.cms.model.commands.CreateCinemaCommand;

import java.util.List;


@RestController
public class CinemaController {

    private CommandGateway commandGateway;
    private CinemaFinder cinemaFinder;

    public CinemaController(CommandGateway commandGateway, CinemaFinder cinemaFinder) {
        this.commandGateway = commandGateway;
        this.cinemaFinder = cinemaFinder;
    }

    @PutMapping("/cinemas")
    public void create(@RequestBody CreateCinemaCommand cmd) {
        commandGateway.execute(cmd);
    }

    @GetMapping("/cinemas")
    public List<CinemaDto> getAll() {
        List<CinemaDto> resultList = cinemaFinder.getAll();
        return resultList;
    }
}

package pl.com.bottega.cms.ui;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cms.application.CommandGateway;
import pl.com.bottega.cms.model.commands.CreateCinemaCommand;
import pl.com.bottega.cms.model.commands.CreateShowsCommand;


@RestController

public class CinemaController {
    private CommandGateway commandGateway;

    public CinemaController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PutMapping("/cinemas")
    public void create(@RequestBody CreateCinemaCommand cmd){
        commandGateway.execute(cmd);
    }

    @PutMapping("/cinemas/{cinemaId}/shows")
    public void createShows(@PathVariable Long cinemaId, @RequestBody CreateShowsCommand cmd) {
        cmd.setCinemaId(cinemaId);
        commandGateway.execute(cmd);
    }
}

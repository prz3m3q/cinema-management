package pl.com.bottega.cms.ui.rest;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cms.application.CommandGateway;
import pl.com.bottega.cms.model.commands.CreateMovieCommand;

@RestController
public class MovieController {

    private CommandGateway gateway;

    public MovieController(CommandGateway gateway) {
        this.gateway = gateway;
    }

    @PutMapping("/movies")
    public void create(@RequestBody CreateMovieCommand cmd) {
        gateway.execute(cmd);
    }
}

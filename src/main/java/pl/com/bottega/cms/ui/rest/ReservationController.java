package pl.com.bottega.cms.ui.rest;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cms.application.CommandGateway;
import pl.com.bottega.cms.application.ReservationDto;
import pl.com.bottega.cms.model.commands.CreateReservationCommand;
import pl.com.bottega.cms.model.Receipt;
import pl.com.bottega.cms.model.commands.CalculatePricesCommand;

@RestController
public class ReservationController {

    private CommandGateway gateway;

    public ReservationController(CommandGateway gateway) {
        this.gateway = gateway;
    }

    @PutMapping("/reservations")
    public ReservationDto create(@RequestBody CreateReservationCommand cmd) {
        return gateway.execute(cmd);
    }
}

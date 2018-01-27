package pl.com.bottega.cms.application;

import org.springframework.stereotype.Component;
import pl.com.bottega.cms.model.Cinema;
import pl.com.bottega.cms.model.commands.Command;
import pl.com.bottega.cms.model.commands.CommandInvalidException;
import pl.com.bottega.cms.model.commands.CreateCinemaCommand;
import pl.com.bottega.cms.model.commands.ValidationErrors;
import pl.com.bottega.cms.model.repositories.CinemaRepository;

import javax.transaction.Transactional;

@Component

public class CreateCinemaHandler implements Handler<CreateCinemaCommand>{

    private CinemaRepository cinemaRepository;

    public CreateCinemaHandler(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Transactional
    public void handle(CreateCinemaCommand cmd){
         validateCinemaFree(cmd);
         Cinema cinema = new Cinema(cmd);
         cinemaRepository.save(cinema);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return CreateCinemaCommand.class;
    }

    private void validateCinemaFree(CreateCinemaCommand cmd){
        if(cinemaRepository.isOccupied(cmd)){
            ValidationErrors errors = new ValidationErrors();
            errors.add("cinema", "is occupied");
            throw new CommandInvalidException(errors);
        }
    }


}

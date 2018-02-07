package pl.com.bottega.cms.application;

import org.springframework.stereotype.Component;
import pl.com.bottega.cms.model.Receipt;
import pl.com.bottega.cms.model.Show;
import pl.com.bottega.cms.model.commands.CalculatePricesCommand;
import pl.com.bottega.cms.model.commands.Command;
import pl.com.bottega.cms.model.repositories.ShowRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class CalculatePriecesHandler implements Handler<CalculatePricesCommand, Void>{

    private ShowRepository showRepository;

    public CalculatePriecesHandler(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

//    @Transactional
//    Receipt handle(CalculatePricesCommand cmd){
//        Optional<Show> show = showRepository.getShow(cmd.getShowId());
//
//
//        return show.ifPresent();
//    }

    @Override
    public Void handle(CalculatePricesCommand command) {
        return null;
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return CalculatePricesCommand.class;
    }
}

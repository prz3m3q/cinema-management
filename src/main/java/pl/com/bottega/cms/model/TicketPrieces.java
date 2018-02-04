package pl.com.bottega.cms.model;

import pl.com.bottega.cms.model.commands.SetTicketPricesCommand;

import java.math.BigDecimal;
import java.util.Map;

public class TicketPrieces {

    Map<String,BigDecimal> prieces;

    public TicketPrieces(SetTicketPricesCommand cmd) {
    }
}

package pl.com.bottega.cms.model.commands;

import java.math.BigDecimal;
import java.rmi.MarshalledObject;
import java.util.Map;
import java.util.regex.Pattern;

public class SetTicketPricesCommand implements Command {

    private Long movieId;
    private Map<String,BigDecimal> prices;

    public void validate(ValidationErrors errors){


        for (Map.Entry<String,BigDecimal> entry : prices.entrySet()){
            if(entry.getValue() == null || entry.getValue().compareTo(BigDecimal.ZERO) == -1)
            errors.add("prices", "Prices must be positive");
        }

            if(prices!= null && !( prices.containsKey("regular") ))
            errors.add("prices", "Must be regular ticket");

            if(prices != null && !( prices.containsKey("student") ))
            errors.add("prices", "Must be student ticket");


        for (Map.Entry<String,BigDecimal> entry : prices.entrySet()){
            if(entry.getKey().trim().isEmpty())
                errors.add("ticket Type", "Can not be empty");
        }

    }

    public Long getMovieId() {
        return movieId;
    }

    public Map<String, BigDecimal> getPrices() {
        return prices;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setPrices(Map<String, BigDecimal> prices) {
        this.prices = prices;
    }
}

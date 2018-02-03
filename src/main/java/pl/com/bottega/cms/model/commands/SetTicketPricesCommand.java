package pl.com.bottega.cms.model.commands;

import java.math.BigDecimal;
import java.util.Map;

public class SetTicketPricesCommand implements Command {

    private Long movieId;
    private Map<String,BigDecimal> prices;


    public void validate(ValidationErrors errors){
        for (Map.Entry<String,BigDecimal> entry : prices.entrySet()){
            if(entry.getValue().compareTo(BigDecimal.ZERO) == -1 )
            errors.add("prices", "Prices can not be under 0");
        }

            if(prices!= null && !( prices.containsKey("regular") ))
            errors.add("prices", "Must be regular ticker");

            if(prices != null && !( prices.containsKey("student") ))
            errors.add("prices", "Must be student ticker");
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

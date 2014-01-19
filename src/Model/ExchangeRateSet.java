package Model;

import java.util.ArrayList;

public class ExchangeRateSet extends ArrayList<ExchangeRate> {
    
    private static ExchangeRateSet instance;

    public ExchangeRateSet() {
        super();
    }
    
     public static ExchangeRateSet getInstance() {
        if (instance == null) 
            instance = new ExchangeRateSet();
        return instance;
    }
     
    public Number getRateFromSet(Currency currencyFrom, Currency currencyTo) {
        for (ExchangeRate exchangeRate : this) {
            if (exchangeRate.getFrom().equals(currencyFrom) && exchangeRate.getTo().equals(currencyTo)) return exchangeRate.getRate();
        }
        return new Number (0);
    }
}

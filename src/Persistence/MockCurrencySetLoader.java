package Persistence;

import Model.Currency;
import Model.CurrencySet;

public class MockCurrencySetLoader extends CurrencySetLoader{
    
    private static MockCurrencySetLoader instances;
    
     private MockCurrencySetLoader() {
        super();
    }
    
     @Override
     public CurrencySetLoader getInstance() {
        if (instances == null)
            instances = new MockCurrencySetLoader();
        return instances;
    }
    
    public static void load() {
        CurrencySet set = CurrencySet.getInstance();
        set.clear();
        set.add(new Currency("Dolar americano", "USD", "$"));
        set.add(new Currency("Dolar canadiense", "CAD", "$"));
        set.add(new Currency("Euro", "EUR", "€"));
    }
}

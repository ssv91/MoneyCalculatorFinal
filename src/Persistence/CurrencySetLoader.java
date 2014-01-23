
package Persistence;

import Model.CurrencySet;


public abstract class CurrencySetLoader {
    static CurrencySetLoader instances;

    public CurrencySetLoader() {
    }

    public abstract CurrencySetLoader getInstance();
}

package Model;

public class Money {
    private final Number ammount;
    private final Currency currency;

    public Money(Number ammount, Currency currency) {
        this.ammount = ammount;
        this.currency = currency;
    }

    public Number getAmmount() {
        return ammount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return ammount.toString() + " " + currency.toString();
    }
    
}


package Model;


public class MoneyExchanger {

    private Money exchange(Money money, ExchangeRate exchangeRate){
        Number multiplication = new Number(money.getAmmount().multiply(money.getAmmount(), exchangeRate.getRate()));
        return new Money(multiplication,exchangeRate.getTo());
    }
}
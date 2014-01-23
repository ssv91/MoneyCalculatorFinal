
package Model;


public class MoneyExchanger {

    private Money exchange(Money money, ExchangeRate exchangeRate){
       return new Money(money.getAmmount().multiply(exchangeRate.getRate()), exchangeRate.getTo());
    }
}
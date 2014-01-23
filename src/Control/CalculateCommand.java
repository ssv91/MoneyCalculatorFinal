package Control;

import UserInterface.CurrencyDialog;
import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import Model.ExchangeRateSet;
import Model.Money;
import Model.Number;

public class CalculateCommand extends Command {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }

    @Override
    public void execute() {
        moneyViewer.show(new Money(calculateAmount(), currencyDialog.getCurrency()));
    }

    private Number getExchangeRate() {
        
        Number number = ExchangeRateSet.getInstance().getRateFromSet(moneyDialog.getMoney().getCurrency(), currencyDialog.getCurrency());
        return number;
    }

   private Number calculateAmount() {
       return  getExchangeRate().multiply(moneyDialog.getMoney().getAmmount());
    }
}

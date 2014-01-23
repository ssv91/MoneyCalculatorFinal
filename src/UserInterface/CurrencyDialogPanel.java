package UserInterface;


import Model.Currency;
import Model.CurrencySet;
import Persistence.DataBaseSetLoader;
import Persistence.MockExchangeRateLoader;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JPanel;

class CurrencyDialogPanel extends JPanel implements CurrencyDialog {

    private String currency;

    public CurrencyDialogPanel() throws SQLException {
        this("USD");
    }

    public CurrencyDialogPanel(String currency) throws SQLException {
        super(new FlowLayout(FlowLayout.LEFT));
        this.currency = currency;
        this.createComponents();
    }

    @Override
    public Currency getCurrency() {
        return new Currency(currency);
    }

    private void createComponents() throws SQLException {
        this.add(createCurrencyDisplay());
    }

    private JComboBox createCurrencyDisplay() throws SQLException {
        DataBaseSetLoader.load();
        MockExchangeRateLoader merl = new MockExchangeRateLoader();
        merl.getInstance().load();
        JComboBox comboBox = new JComboBox(CurrencySet.getInstance().toArray());
        comboBox.setSelectedItem(currency);
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event.getStateChange() != ItemEvent.SELECTED) return;
                currency = event.getItem().toString();
            }
        });
        return comboBox;
    }
}
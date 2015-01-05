package swing;

import Model.Currency;
import Model.CurrencySet;
import Model.Exchange;
import Model.Money;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Character.isDigit;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ui.ExchangeDialog;

public class ExchangePanelDialog extends JPanel implements ExchangeDialog {

    private CurrencySet currencySet;
    private JComboBox<Currency> currencyFrom;
    private JComboBox<Currency> currencyTo;
    private JTextField textField;

    public ExchangePanelDialog(CurrencySet currencySet) {
        this.currencySet = currencySet;
        setLayout(new FlowLayout(CENTER));
        add(createTextField());
        add(createCurrencyFromComboBox());
        add(createCurrencyToComboBox());
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(15);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent event) {
                if (!isDigit(event.getKeyChar())) {
                    event.consume();
                }
            }
        });
        this.textField = textField;
        return textField;
    }

    private JComboBox createCurrencyFromComboBox() {
        JComboBox<Currency> comboBox = new JComboBox<>(currencySet.toArray());
        this.currencyFrom = comboBox;
        return comboBox;
    }

    private JComboBox createCurrencyToComboBox() {
        JComboBox<Currency> comboBox = new JComboBox<>(currencySet.toArray());
        this.currencyTo = comboBox;
        return comboBox;
    }

    private double getValue() {
        if (textField.getText().length() == 0) return 0;        
        return Double.parseDouble(textField.getText());
    }

    public Currency getCurrencyFrom() {
        return currencyFrom.getItemAt(currencyFrom.getSelectedIndex());
    }

    public Currency getCurrencyTo() {
        return currencyTo.getItemAt(currencyTo.getSelectedIndex());
    }

    @Override
    public Exchange getExchange() {
        return new Exchange(new Money(getValue(), getCurrencyFrom()), getCurrencyTo());
    }

    @Override
    public void setDetailsTextField() {
        textField.setEditable(true);
        textField.setToolTipText("Enter some number");
    }
}
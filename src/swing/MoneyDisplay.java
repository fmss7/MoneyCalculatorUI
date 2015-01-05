package swing;

import Model.Money;
import javax.swing.JLabel;

public class MoneyDisplay extends JLabel {

    public MoneyDisplay() {
        super();
    }

    public void displayMoney(Money money_in, Money money_out) {
        super.setText("Exchange: " + String.valueOf(money_in.getAmount()) + " " + money_in.getCurrency().getCode()
                + " = " + String.valueOf(money_out.getAmount()) + " " + money_out.getCurrency().getCode());
    }
}
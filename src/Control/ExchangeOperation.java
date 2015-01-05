package Control;

import Model.Exchange;
import Model.ExchangeRate;
import Model.Money;
import Persistance.ExchangeRateLoader;
import Process.Exchanger;
import swing.MoneyDisplay;
import ui.ExchangeDialog;

public class ExchangeOperation {

    private final ExchangeDialog dialog;
    private final MoneyDisplay display;

    public ExchangeOperation(ExchangeDialog dialog, MoneyDisplay display) {
        this.dialog = dialog;
        this.display = display;
    }

    public void execute() {
        dialog.setDetailsTextField();
        Exchange exchange = dialog.getExchange();
        ExchangeRate exchangeRate = new ExchangeRateLoader().load(exchange.getMoney().getCurrency(), exchange.getCurrency());
        Money money_out = new Exchanger().exchangeOperation(exchange.getMoney(), exchangeRate);
        display.displayMoney(exchange.getMoney(), money_out);
    }
}
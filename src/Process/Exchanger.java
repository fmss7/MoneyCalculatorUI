package Process;

import Model.ExchangeRate;
import Model.Money;

public class Exchanger {

    public Money exchangeOperation(Money money_in, ExchangeRate exchangeRate) {
        return new Money(money_in.getAmount() * exchangeRate.getRate(), exchangeRate.getTo());
    }
}
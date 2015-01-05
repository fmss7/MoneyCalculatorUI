package Persistance;

import Model.Currency;
import Model.CurrencySet;

public class CurrencySetLoader {

    public CurrencySet load() {
        CurrencySet currencySet = new CurrencySet();
        currencySet.add(new Currency("Euro", "€", "EUR"));
        currencySet.add(new Currency("Dolar", "$", "USD"));
        currencySet.add(new Currency("Libra", "£", "GBP"));
        currencySet.add(new Currency("Brazilian Real", "R$", "BRL"));
        currencySet.add(new Currency("Canadian Dollar", "C$", "CAD"));
        currencySet.add(new Currency("Chinese Yuan", "¥", "CNY"));
        currencySet.add(new Currency("Belice Dollar", "BZ$", "BZD"));
        currencySet.add(new Currency("Japanese Yen", "¥", "JPY"));
        currencySet.add(new Currency("Swiss Franc", "CHF", "CHF"));
        currencySet.add(new Currency("Southadrican Rand", "ZAR", "ZAR"));
        return currencySet;
    }
}
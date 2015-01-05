package Model;

import java.util.HashSet;
import java.util.Set;

public class CurrencySet {

    private final Set<Currency> currencySet;

    public CurrencySet() {
        currencySet = new HashSet<>();
    }

    public void add(Currency currency) {
        currencySet.add(currency);
    }

    public Currency[] toArray() {
        return currencySet.toArray(new Currency[currencySet.size()]);
    }
}
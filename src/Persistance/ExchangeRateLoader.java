package Persistance;

import Model.Currency;
import Model.ExchangeRate;
import java.util.ArrayList;

public class ExchangeRateLoader {

    private ArrayList<String> currency;
    private ArrayList<Double> rate;

    public ExchangeRate load(Currency from, Currency to) {
        addCurrency();
        addRate();
        return new ExchangeRate(from, to, rateOperation(from, to));
    }

    private void addRate() {
        rate = new ArrayList<>();
        rate.add(1.0);
        rate.add(1.244325);
        rate.add(0.79610815);
        rate.add(3.20413287);
        rate.add(1.42159181);
        rate.add(7.5);
        rate.add(2.482);
        rate.add(147.0);
        rate.add(1.20168211);
        rate.add(13.79);
    }

    private void addCurrency() {
        currency = new ArrayList<>();
        currency.add("EUR");
        currency.add("USD");
        currency.add("GBP");
        currency.add("BRL");
        currency.add("CAD");
        currency.add("CNY");
        currency.add("BZD");
        currency.add("JPY");
        currency.add("CHF");
        currency.add("ZAR");
    }

    private double rateOperation(Currency from, Currency to) {
        return (1 / rate.get(currency.indexOf(from.getCode()))) * rate.get(currency.indexOf(to.getCode()));
    }
}
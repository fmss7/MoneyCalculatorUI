package App;

import Control.ExchangeOperation;
import Persistance.CurrencySetLoader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import swing.ApplicationFrame;

public class Aplication {

    public static void main(String[] args) {
        final ApplicationFrame appFrame = new ApplicationFrame(new CurrencySetLoader().load());
        appFrame.insert("Convert", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ExchangeOperation(appFrame.getDialog(), appFrame.getMoneyDisplay()).execute();
            }
        });
    }
}
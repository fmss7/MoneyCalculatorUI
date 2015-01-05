package swing;

import Model.CurrencySet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.ExchangeDialog;

public class ApplicationFrame extends JFrame {

    private CurrencySet currencySet;
    private Map<String, ActionListener> map = new HashMap<>();
    private ExchangeDialog exchangeDialog;
    private MoneyDisplay moneyDisplay;

    public ApplicationFrame(CurrencySet currencySet) {
        super();
        this.currencySet = currencySet;
        setTitle("Money Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 250));
        createComponents();
        setVisible(true);
        add(createMoneyDisplay(), NORMAL);
    }

    private void createComponents() {
        add(createExchangeDialog());
        add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createExchangeDialog() {
        ExchangePanelDialog panel = new ExchangePanelDialog(currencySet);;
        this.exchangeDialog = panel;
        return panel;
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createConvertButton());
        panel.add(createCloseButton());
        return panel;
    }

    private JButton createConvertButton() {
        JButton button = new JButton("Convert");
        button.addActionListener(createListener("Convert"));
        return button;
    }

    private JButton createCloseButton() {
        JButton button = new JButton("Close");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplicationFrame.this.dispose();
            }
        });
        return button;
    }

    private JLabel createMoneyDisplay() {
        MoneyDisplay moneyDisplay = new MoneyDisplay();
        this.moneyDisplay = moneyDisplay;
        return moneyDisplay;
    }
    
    private ActionListener createListener(final String string) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                map.get(string).actionPerformed(event);
            }
        };
    }

    public ExchangeDialog getDialog() {
        return exchangeDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
  
    public void insert(String string, ActionListener actionListener) {
        map.put(string, actionListener);
    }
}
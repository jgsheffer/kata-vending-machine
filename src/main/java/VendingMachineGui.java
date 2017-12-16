import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jared on 12/15/2017.
 */
public class VendingMachineGui {
    ButtonGroup coinSelection;
    private VendingMachine vendingMachine;
    protected JButton a1Button;
    protected JButton a2Button;
    protected JButton a3Button;
    protected JLabel displayLabel;
    protected JLabel coinReturnLabel;
    protected JLabel bankBalanceLabel;
    protected JPanel vendingPanel;
    protected JLabel product2;
    //((ItemSlot)vendingMachine.getInventory().get(1)).getItem();
    protected JLabel product3;
    protected JLabel product1;
    protected JRadioButton pennyRadio;
    protected JRadioButton dollarRadioButton;
    protected JRadioButton quarterRadioButton;
    protected JRadioButton dimeRadioButton;
    protected JRadioButton nickleRadioButton;
    protected JButton insertCoinButton;
    protected JButton emptyCoinReturnButton;
    protected JButton returnAllCoinsButton;
    protected JButton emptyBankButton;
    final String html1 = "<html><body style='width:137px'>";

    public VendingMachineGui(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        product1.setText(((ItemSlot) vendingMachine.getInventory().get(1)).getItem());
        product2.setText(((ItemSlot) vendingMachine.getInventory().get(2)).getItem());
        product3.setText(((ItemSlot) vendingMachine.getInventory().get(3)).getItem());
        displayLabel.setText(vendingMachine.getCurrentDisplay());
        bankBalanceLabel.setText(vendingMachine.getBank().toString());

        coinSelection = new ButtonGroup();
        coinSelection.add(pennyRadio);
        coinSelection.add(nickleRadioButton);
        coinSelection.add(dimeRadioButton);
        coinSelection.add(quarterRadioButton);
        coinSelection.add(dollarRadioButton);
        dollarRadioButton.setSelected(true);


        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendingMachine.pressButton(1);
                updateMachine();
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendingMachine.pressButton(2);
                updateMachine();
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendingMachine.pressButton(3);
                updateMachine();
            }
        });
        insertCoinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLabel.setText(vendingMachine.insert(getCoinForSelectedRadio()));
                updateMachine();
            }
        });
        returnAllCoinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendingMachine.pushChangeReturnButton();
                displayLabel.setText(vendingMachine.getCurrentDisplay());
                updateMachine();
            }
        });
        emptyCoinReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendingMachine.getCoinReturn().emptyCoinReturn();
                updateMachine();
            }
        });

        emptyBankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendingMachine.getBank().clear();
                updateMachine();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vending Machine");
        frame.setContentPane(new VendingMachineGui(new VendingMachine(5, new ArrayList<>())).vendingPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateMachine() {
        bankBalanceLabel.setText(html1+vendingMachine.getBank().toString());
        displayLabel.setText(vendingMachine.getCurrentDisplay());
        coinReturnLabel.setText(html1+vendingMachine.getCoinReturn().getCoinReturnString().toString());
    }

    protected Coin getCoinForSelectedRadio() {
        if (pennyRadio.isSelected()) {
            return Coin.PENNY;
        } else if (nickleRadioButton.isSelected()) {
            return Coin.NICKLE;
        } else if (dimeRadioButton.isSelected()) {
            return Coin.DIME;
        } else if (quarterRadioButton.isSelected()) {
            return Coin.QUARTER;
        } else {
            return Coin.DOLLAR;
        }
    }
}

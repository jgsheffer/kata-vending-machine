import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jared on 12/15/2017.
 */
public class VendingMachineGui {
    ButtonGroup coinSelection;
    private VendingMachine vendingMachine = new VendingMachine(5, new ArrayList<>());
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JLabel displayLabel;
    private JLabel coinReturnLabel;
    private JLabel bankBalanceLabel;
    private JPanel vendingPanel;
    private JLabel product2;
    //((ItemSlot)vendingMachine.getInventory().get(1)).getItem();
    private JLabel product3;
    private JLabel product1;
    private JRadioButton pennyRadio;
    private JRadioButton dollarRadioButton;
    private JRadioButton quarterRadioButton;
    private JRadioButton dimeRadioButton;
    private JRadioButton nickleRadioButton;
    private JButton insertCoinButton;
    private JButton emptyCoinReturnButton;
    private JButton returnAllCoinsButton;

    public VendingMachineGui() {
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

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vending Machine");
        frame.setContentPane(new VendingMachineGui().vendingPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateMachine() {
        bankBalanceLabel.setText(vendingMachine.getBank().toString());
        displayLabel.setText(vendingMachine.getCurrentDisplay());
        coinReturnLabel.setText(vendingMachine.getCoinReturn().getCoinReturnString().toString());
    }

    private Coin getCoinForSelectedRadio() {
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

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
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
        bankBalanceLabel.setText(html1 + vendingMachine.getBank().toString());
        displayLabel.setText(vendingMachine.getCurrentDisplay());
        coinReturnLabel.setText(html1 + vendingMachine.getCoinReturn().getCoinReturnString().toString());
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        vendingPanel = new JPanel();
        vendingPanel.setLayout(new GridLayoutManager(3, 1, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        vendingPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Bank Balance:");
        panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bankBalanceLabel = new JLabel();
        bankBalanceLabel.setText("0");
        panel1.add(bankBalanceLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, 1, 1, null, null, null, 0, false));
        emptyBankButton = new JButton();
        emptyBankButton.setText("Empty Bank");
        panel1.add(emptyBankButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(10, 1, new Insets(0, 0, 0, 0), -1, -1));
        vendingPanel.add(panel2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, 1, null, null, null, 0, false));
        displayLabel = new JLabel();
        displayLabel.setText("INSERT COIN");
        panel2.add(displayLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        coinReturnLabel = new JLabel();
        coinReturnLabel.setText("Empty");
        panel2.add(coinReturnLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pennyRadio = new JRadioButton();
        pennyRadio.setText("Penny");
        panel2.add(pennyRadio, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nickleRadioButton = new JRadioButton();
        nickleRadioButton.setText("Nickel");
        panel2.add(nickleRadioButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dimeRadioButton = new JRadioButton();
        dimeRadioButton.setText("Dime");
        panel2.add(dimeRadioButton, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        quarterRadioButton = new JRadioButton();
        quarterRadioButton.setText("Quarter");
        panel2.add(quarterRadioButton, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dollarRadioButton = new JRadioButton();
        dollarRadioButton.setText("Dollar");
        panel2.add(dollarRadioButton, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        insertCoinButton = new JButton();
        insertCoinButton.setText("Insert Coin");
        panel2.add(insertCoinButton, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        returnAllCoinsButton = new JButton();
        returnAllCoinsButton.setText("Return All Coins");
        panel2.add(returnAllCoinsButton, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        emptyCoinReturnButton = new JButton();
        emptyCoinReturnButton.setText("Empty Coin Return");
        panel2.add(emptyCoinReturnButton, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        vendingPanel.add(panel3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, 1, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, 1, null, null, null, 0, false));
        product1 = new JLabel();
        product1.setText("Label");
        panel4.add(product1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        product2 = new JLabel();
        product2.setText("Label");
        panel4.add(product2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        product3 = new JLabel();
        product3.setText("Label");
        panel4.add(product3, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel5, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, 1, null, null, null, 0, false));
        a1Button = new JButton();
        a1Button.setText("1");
        panel5.add(a1Button, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a2Button = new JButton();
        a2Button.setText("2");
        panel5.add(a2Button, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a3Button = new JButton();
        a3Button.setText("3");
        panel5.add(a3Button, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return vendingPanel;
    }
}

import javax.swing.*;

/**
 * Created by Jared on 12/15/2017.
 */
public class VendingMachineGui {
    private VendingMachine vendingMachine = new VendingMachine();
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

    public VendingMachineGui(){

    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Vending Machine");
        frame.setContentPane(new VendingMachineGui().vendingPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

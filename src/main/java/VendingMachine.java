import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachine {

    private double currentBalance;
    private HashMap<Integer, ItemSlot> inventory = new HashMap<>();
    private String currentDisplay = Constants.INSERT_COIN;
    private ArrayList<Coin> coinReturn = new ArrayList<>();

    public VendingMachine(){
        currentBalance = 0;
        setupInventory();
    }

    public String insert(Coin coin){
        if(isCoinValid(coin)) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            currentBalance = currentBalance + getCoinValue(coin);
            currentDisplay = Constants.CURRENT_BALANCE_STRING_START + formatter.format(currentBalance);
        }else {
            coinReturn.add(coin);
        }
        return currentDisplay;
    }

    private void setupInventory(){
        inventory.put(1, new ItemSlot(1.00, "cola"));
        inventory.put(2, new ItemSlot(0.50, "chips"));
        inventory.put(3, new ItemSlot(0.65, "candy"));
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public HashMap getInventory(){
        return inventory;
    }

    private boolean isCoinValid(Coin coin){
        return (coin == Coin.NICKLE || coin == Coin.DIME  || coin == Coin.QUARTER);
    }

    private double getCoinValue(Coin coin){
        switch (coin) {
            case QUARTER:
                return 0.25;
            case NICKLE:
                return 0.05;
            case DIME:
                return 0.10;
            default:
                return 0;
        }

    }

    public ArrayList<Coin> getCoinReturn() {
        return coinReturn;
    }


    public void emptyCoinReturn() {
        coinReturn.clear();
    }

    public ItemSlot getItemSlot(Integer position){
        return (ItemSlot)getInventory().get(position);
    }

    public String pressButton(Integer position){
     return "THANK YOU";
    }
}

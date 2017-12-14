import javax.management.openmbean.CompositeData;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachine {

    private int currentBalance;
    private HashMap<Integer, ItemSlot> inventory;
    private String currentDisplay;
    private CoinReturn coinReturn;
    private boolean hasDisplayedPrice;
    private boolean showInsertCoinSwitch;
    private ArrayList<Coin> currentCoinBalanceCollection;
    private ArrayList<Coin> bank;

    public VendingMachine(){
        initializeVendingMachine();
    }

    public void initializeVendingMachine(){

        currentBalance = 0;
        currentDisplay = Constants.INSERT_COIN;
        inventory = new HashMap<>();
        coinReturn = new CoinReturn();
        hasDisplayedPrice = false;
        showInsertCoinSwitch  = true;
        currentCoinBalanceCollection  = new ArrayList<>();
        bank = new ArrayList<>();
        setupInventory();
    }

    public String insert(Coin coin){
        if(isCoinValid(coin)) {
            currentBalance = currentBalance +getCoinValue(coin);
            currentCoinBalanceCollection.add(coin);
            currentDisplay = Constants.CURRENT_BALANCE_STRING_START + formatMoney(Double.valueOf(currentBalance)/100);
        }else {
            coinReturn.addCoinToCoinReturn(coin);
        }
        return currentDisplay;
    }

    public String getCurrentDisplay(){
        return currentDisplay;
    }
    private void setupInventory(){
        inventory.put(1, new ItemSlot(100, "cola"));
        inventory.put(2, new ItemSlot(50, "chips"));
        inventory.put(3, new ItemSlot(65, "candy"));
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public HashMap getInventory(){
        return inventory;
    }

    private boolean isCoinValid(Coin coin){
        return (coin == Coin.NICKLE || coin == Coin.DIME  || coin == Coin.QUARTER);
    }

    private int getCoinValue(Coin coin){
        switch (coin) {
            case QUARTER:
                return 25;
            case NICKLE:
                return 5;
            case DIME:
                return 10;
            default:
                return 0;
        }

    }

    public CoinReturn getCoinReturn() {
        return coinReturn;
    }

    public ItemSlot getItemSlot(Integer position){
        return (ItemSlot)getInventory().get(position);
    }

    public void pressButton(Integer position){
        ItemSlot selectedItem = getItemSlot(position);
        if(selectedItem != null) {
            if(isBalanceHighEnough(selectedItem.getPrice())) {
                currentBalance = currentBalance -selectedItem.getPrice();
                sendRemainingBalanceToCoinReturn();
                currentDisplay =  Constants.THANK_YOU;
            }else if(!hasDisplayedPrice){
                hasDisplayedPrice = true;
                currentDisplay =  "PRICE : "+formatMoney(Double.valueOf(selectedItem.getPrice())/100);
            }else{
                currentDisplay =  getInvalidBalanceMessage();
            }
        }else{
            currentDisplay =  Constants.INVALID_BUTTON;
        }
    }

    private void sendRemainingBalanceToCoinReturn(){
        coinReturn.addCorrectChangeToReturn(currentBalance);
        currentBalance = 0;
        getBank().addAll(currentCoinBalanceCollection);
    }

    private String formatMoney(double amount){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(amount);
    }

    private String getInvalidBalanceMessage(){
        String message;
        if(showInsertCoinSwitch){
            showInsertCoinSwitch = false;
            message = Constants.INSERT_COIN;
        }else{
            showInsertCoinSwitch = true;
            message =  Constants.CURRENT_BALANCE_STRING_START + formatMoney(Double.valueOf(currentBalance)/100);
        }
        return message;
    }

    private boolean isBalanceHighEnough(double cost){
        return currentBalance >= cost;
    }

    public ArrayList<Coin> getCurrentCoinBalanceCollection() {
        return currentCoinBalanceCollection;
    }


    public ArrayList<Coin> getBank() {
        return bank;
    }
}

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachine {

    int numberOfProducts;
    private int currentBalance;
    private HashMap<Integer, ItemSlot> inventory;
    private String currentDisplay;
    private CoinReturn coinReturn;
    private boolean hasDisplayedPrice1;
    private boolean hasDisplayedPrice2;
    private boolean hasDisplayedPrice3;
    private ArrayList<Coin> currentCoinBalanceCollection;
    private ArrayList<Coin> bank;

    public VendingMachine(int numberOfProducts, ArrayList<Coin> startingChange) {
        this.numberOfProducts = numberOfProducts;
        initializeVendingMachine(startingChange);
    }

    public void initializeVendingMachine(ArrayList<Coin> startingChange) {
        currentBalance = 0;
        currentDisplay = Constants.INSERT_COIN;
        inventory = new HashMap<>();
        coinReturn = new CoinReturn();
        hasDisplayedPrice1 = false;
        hasDisplayedPrice2 = false;
        hasDisplayedPrice3 = false;
        currentCoinBalanceCollection = new ArrayList<>();
        bank = startingChange;
        setupInventory();
        if (shouldShowExactChangeOnly()) {
            currentDisplay = Constants.EXACT_CHANGE_ONLY;
        }
    }

    public String insert(Coin coin) {
        if (isCoinValid(coin)) {
            currentBalance = currentBalance + getCoinValue(coin);
            currentCoinBalanceCollection.add(coin);
            currentDisplay = Constants.CURRENT_BALANCE_STRING_START + formatMoney(Double.valueOf(currentBalance) / 100);
        } else {
            coinReturn.addCoinToCoinReturn(coin);
        }
        return currentDisplay;
    }

    public String getCurrentDisplay() {
        return currentDisplay;
    }

    public void refeshDisplay() {
        currentDisplay = getInvalidBalanceMessage();
    }

    private void setupInventory() {
        inventory.put(1, new ItemSlot(100, "cola", numberOfProducts));
        inventory.put(2, new ItemSlot(50, "chips", numberOfProducts));
        inventory.put(3, new ItemSlot(65, "candy", numberOfProducts));
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public HashMap getInventory() {
        return inventory;
    }

    private boolean isCoinValid(Coin coin) {
        return (coin == Coin.NICKLE || coin == Coin.DIME || coin == Coin.QUARTER);
    }

    private int getCoinValue(Coin coin) {
        switch (coin) {
            case QUARTER:
                return 25;
            case NICKLE:
                return 5;
            default:
                return 10;
        }

    }

    public CoinReturn getCoinReturn() {
        return coinReturn;
    }

    public ItemSlot getItemSlot(Integer position) {
        return (ItemSlot) getInventory().get(position);
    }

    public void pressButton(Integer position) {
        ItemSlot selectedItem = getItemSlot(position);
        if (selectedItem != null) {

            if (isBalanceHighEnough(selectedItem.getPrice())) {
                boolean wasInStock = selectedItem.dispense();
                if (wasInStock) {
                    currentBalance = currentBalance - selectedItem.getPrice();
                    sendRemainingBalanceToCoinReturn();
                    currentDisplay = Constants.THANK_YOU;
                    resetHasShowPriceForItems();
                } else {
                    currentDisplay = Constants.SOLD_OUT;
                    resetHasShowPriceForItems();
                }
            } else if (!hasShownPriceForItem(position)) {
                ShowingPriceForItem(position);
                currentDisplay = "PRICE : " + formatMoney(Double.valueOf(selectedItem.getPrice()) / 100);
            } else {
                currentDisplay = getInvalidBalanceMessage();
            }
        } else {
            currentDisplay = Constants.INVALID_BUTTON;
        }
    }

    private boolean hasShownPriceForItem(int item){
        switch(item) {
            case 1:
                return hasDisplayedPrice1;
            case 2:
                return hasDisplayedPrice2;
            default:
                return hasDisplayedPrice3;
        }
    }

    private void ShowingPriceForItem(int item){
        switch(item) {
            case 1:
                hasDisplayedPrice1 = true;
            case 2:
                hasDisplayedPrice2 = true;
            default:
                hasDisplayedPrice3 = true;
        }
    }

    private void resetHasShowPriceForItems(){
        hasDisplayedPrice1 = false;
        hasDisplayedPrice2 = false;
        hasDisplayedPrice3 = false;
    }



    private void sendRemainingBalanceToCoinReturn() {
        getBank().addAll(currentCoinBalanceCollection);
        bank = coinReturn.addCorrectChangeToReturn(bank, currentBalance);
        currentCoinBalanceCollection.clear();
        currentBalance = 0;

    }

    public void pushChangeReturnButton() {
        coinReturn.getCoinReturnCollection().addAll(currentCoinBalanceCollection);
        currentCoinBalanceCollection.clear();
        currentBalance = 0;
    }

    private String formatMoney(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(amount);
    }

    private String getInvalidBalanceMessage() {
        String message;
        if (currentBalance > 0) {
            message = Constants.CURRENT_BALANCE_STRING_START + formatMoney(Double.valueOf(currentBalance) / 100);
        } else {
            if (shouldShowExactChangeOnly()) {
                message = Constants.EXACT_CHANGE_ONLY;
            } else {
                message = Constants.INSERT_COIN;
            }
        }
        return message;
    }

    private boolean isBalanceHighEnough(double cost) {
        return currentBalance >= cost;
    }

    public ArrayList<Coin> getCurrentCoinBalanceCollection() {
        return currentCoinBalanceCollection;
    }


    public ArrayList<Coin> getBank() {
        return bank;
    }

    private boolean shouldShowExactChangeOnly() {
        CoinUtility coinUtility = new CoinUtility();
        ItemSlot itemSlot1 = inventory.get(1);
        ItemSlot itemSlot2 = inventory.get(2);
        ItemSlot itemSlot3 = inventory.get(3);
        boolean canMakeChangeForSlot1 = coinUtility.canMakeChange(bank, inventory.get(1).getMostPossiblyOwed());
        boolean canMakeChangeForSlot2 = coinUtility.canMakeChange(bank, inventory.get(2).getMostPossiblyOwed());
        boolean canMakeChangeForSlot3 = coinUtility.canMakeChange(bank, inventory.get(3).getMostPossiblyOwed());
        return !canMakeChangeForSlot1 && !canMakeChangeForSlot2 && !canMakeChangeForSlot3;
    }

}

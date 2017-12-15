/**
 * Created by Jared on 12/13/2017.
 */
public class ItemSlot {

    private int price;
    private String item;
    private int numberOfItemsAvailable;
    private CoinUtility coinUtility = new CoinUtility();


    public ItemSlot(int price, String item, int numberOfItemsAvailable) {
        this.price = price;
        this.item = item;
        this.numberOfItemsAvailable = numberOfItemsAvailable;
    }


    public int getPrice() {
        return price;
    }

    public String getItem() {
        return item;
    }


    public int getNumberOfItemsAvailable() {
        return numberOfItemsAvailable;
    }

    public boolean dispense() {
        if (numberOfItemsAvailable > 0) {
            numberOfItemsAvailable--;
            return true;
        }
        return false;
    }


    public int getMostPossiblyOwed() {
        int balance = getPrice();
        if ((balance - Constants.QUARTER_AMOUNT) < 0) {
            return Math.abs(balance - Constants.QUARTER_AMOUNT);
        } else {
            return Constants.NICKLE_AMOUNT;
        }
    }

    public int removeQuartersFromBalance(int balance) {
        int balanceWithRemovedQuarters = balance;
        while ((balanceWithRemovedQuarters - Constants.QUARTER_AMOUNT) > 0) {
            balanceWithRemovedQuarters = balanceWithRemovedQuarters - Constants.QUARTER_AMOUNT;
        }
        return balanceWithRemovedQuarters;
    }
}

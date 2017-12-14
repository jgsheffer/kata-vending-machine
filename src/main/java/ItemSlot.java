/**
 * Created by Jared on 12/13/2017.
 */
public class ItemSlot {

    private int price;
    private String item;
    private int numberOfItemsAvailable;

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
        if(numberOfItemsAvailable>0) {
            numberOfItemsAvailable--;
            return true;
        }
        return false;


    }
}

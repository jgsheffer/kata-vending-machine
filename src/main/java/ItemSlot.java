/**
 * Created by Jared on 12/13/2017.
 */
public class ItemSlot {

    private int position;
    private double price;
    private String item;
    public ItemSlot(int position, double price, String item) {
        this.position = position;
        this.price = price;
        this.item = item;
    }

    public int getPosition() {
        return position;
    }

    public double getPrice() {
        return price;
    }

    public String getItem() {
        return item;
    }



}

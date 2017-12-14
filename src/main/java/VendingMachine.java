import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachine {

    double currentBalance;

    public VendingMachine(){
        currentBalance = 0;
    }
    private String currentDisplay = Constants.INSERT_COIN;
    private ArrayList<Coin> coinReturn = new ArrayList<>();

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

    public double getCurrentBalance() {
        return currentBalance;
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

    public ItemSlot getItemSlot(){
        return new ItemSlot(0, 0.0, null);
    }
}

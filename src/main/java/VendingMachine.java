import java.util.ArrayList;

/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachine {

    int currentBalance;

    public void VendingMachine(){
        currentBalance = 0;
    }
    private String currentDisplay = Constants.INSERT_COIN;
    private ArrayList<Coin> coinReturn = new ArrayList<>();

    public String insert(Coin coin){
        if(isCoinValid(coin)) {
            currentBalance = currentBalance + getCoinValue(coin);
            currentDisplay = Constants.CURRENT_BALANCE_STRING_START + currentBalance;
        }else {
            coinReturn.add(coin);
        }
        return currentDisplay;
    }

    public int getCurrentBalance() {
        return currentBalance;
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

    public ArrayList<Coin> getCoinReturn() {
        return coinReturn;
    }


    public void emptyCoinReturn() {
        coinReturn.clear();
    }
}

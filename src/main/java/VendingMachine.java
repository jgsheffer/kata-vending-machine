/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachine {

    int currentBalance;

    public void VendingMachine(){
        currentBalance = 0;
    }

    public boolean insert(Coin coin){
        return isCoinValid(coin);
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    private boolean isCoinValid(Coin coin){
        return (coin == Coin.NICKLE || coin == Coin.DIME  || coin == Coin.QUARTER);
    }
}

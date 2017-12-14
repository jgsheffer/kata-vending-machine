/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachine {



    public boolean insert(Coin coin){
        return isCoinValid(coin);
    }

    public String getCurrentBalance() {
        return "";
    }

    private boolean isCoinValid(Coin coin){
        return (coin == Coin.NICKLE || coin == Coin.DIME  || coin == Coin.QUARTER);
    }
}

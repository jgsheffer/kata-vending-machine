/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachine {

    int currentBalance;

    public void VendingMachine(){
        currentBalance = 0;
    }

    public String insert(Coin coin){
        if(isCoinValid(coin)){
            return Constants.CURRENT_BALANCE_STRING_START+currentBalance;
        }
        return "";
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    private boolean isCoinValid(Coin coin){
        return (coin == Coin.NICKLE || coin == Coin.DIME  || coin == Coin.QUARTER);
    }

}

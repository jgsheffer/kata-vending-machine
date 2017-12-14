/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachine {



    public boolean insert(Coin coin){
        if(coin != null && coin != Coin.PENNY)
            return true;
      return false;
    }

    public String getCurrentBalance() {
        return "";
    }
}

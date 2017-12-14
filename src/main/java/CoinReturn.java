import java.util.ArrayList;

/**
 * Created by Jared on 12/14/2017.
 */
public class CoinReturn {
    private ArrayList<Coin> coinReturnCollection = new ArrayList<>();

    public ArrayList getCoinReturnCollection(){
        return coinReturnCollection;
    }

    public  void addCoinToCoinReturn(Coin coin){
        coinReturnCollection.add(coin);
    }
    public void emptyCoinReturn(){
        coinReturnCollection.clear();
    }
}

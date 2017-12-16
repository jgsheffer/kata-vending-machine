import java.util.ArrayList;

/**
 * Created by Jared on 12/14/2017.
 */
public class CoinReturn {
    private ArrayList<Coin> coinReturnCollection = new ArrayList<>();
    private CoinUtility coinUtility = new CoinUtility();

    public ArrayList getCoinReturnCollection() {
        return coinReturnCollection;
    }

    public void addCoinToCoinReturn(Coin coin) {
        coinReturnCollection.add(coin);
    }

    public void emptyCoinReturn() {
        coinReturnCollection.clear();
    }

    public ArrayList addCorrectChangeToReturn(ArrayList<Coin> bank, int balanceDue) {
        ArrayList<Coin> changeDue = new ArrayList<>();
        while (balanceDue > 0) {
            int numberOfQuarters = balanceDue / Constants.QUARTER_AMOUNT;
            changeDue.addAll(coinUtility.addCoinsToCollection(Coin.QUARTER, numberOfQuarters));
            balanceDue = balanceDue - numberOfQuarters * Constants.QUARTER_AMOUNT;

            int numberOfDimes = balanceDue / Constants.DIME_AMOUNT;
            changeDue.addAll(coinUtility.addCoinsToCollection(Coin.DIME, numberOfDimes));
            balanceDue = balanceDue - numberOfDimes * Constants.DIME_AMOUNT;

            int numberOfNickels = balanceDue / Constants.NICKLE_AMOUNT;
            changeDue.addAll(coinUtility.addCoinsToCollection(Coin.NICKLE, numberOfNickels));
            balanceDue = balanceDue - numberOfNickels * Constants.NICKLE_AMOUNT;
        }
        CoinUtility coinUtility = new CoinUtility();
        coinReturnCollection = coinUtility.addCoinsOnlyIfAvailable(bank, changeDue, coinReturnCollection);
        return bank;
    }

    public ArrayList<String> getCoinReturnString() {
        ArrayList<String> coinReturnString = new ArrayList<>();
        for (Enum coin : coinReturnCollection) {
            coinReturnString.add(coin.toString());
        }
        return coinReturnString;
    }

}

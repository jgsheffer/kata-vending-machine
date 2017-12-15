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

    public void addCorrectChangeToReturn(int balanceDue) {
        ArrayList<Coin> changeDue = new ArrayList<>();
        while (balanceDue > 0) {
            int numberOfQuarters = balanceDue / Constants.QUARTER_AMOUNT;
            changeDue.addAll(coinUtility.addCoinsToCollection(Coin.QUARTER, numberOfQuarters));
            balanceDue = balanceDue - numberOfQuarters * Constants.QUARTER_AMOUNT;

            int numberOfDimes = balanceDue / Constants.DIME_AMOUNT;
            changeDue.addAll(coinUtility.addCoinsToCollection(Coin.DIME, numberOfDimes));
            balanceDue = balanceDue - numberOfDimes * Constants.DIME_AMOUNT;

            int numberOfNickles = balanceDue / Constants.NICKLE_AMOUNT;
            changeDue.addAll(coinUtility.addCoinsToCollection(Coin.NICKLE, numberOfNickles));
            balanceDue = balanceDue - numberOfNickles * Constants.NICKLE_AMOUNT;
        }
        coinReturnCollection.addAll(changeDue);
    }

    private ArrayList removeCoinsFromBalance(int balance, Coin coin, int coinValue, ArrayList changeDue) {
        int numberOfCoins = balance / coinValue;
        changeDue.addAll(coinUtility.addCoinsToCollection(coin, numberOfCoins));
        return changeDue;
    }

}

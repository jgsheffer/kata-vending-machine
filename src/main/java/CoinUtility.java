import java.util.ArrayList;

/**
 * Created by Jared on 12/14/2017.
 */
public class CoinUtility {
    public ArrayList<Coin> addCoinsToCollection(Coin coin, int numberOfCoins) {
        ArrayList<Coin> coinCollection = new ArrayList<>();
        while (numberOfCoins > 0) {
            coinCollection.add(coin);
            numberOfCoins--;
        }
        return coinCollection;
    }

    public ArrayList<ArrayList<Coin>> getChangeCombinations(int balance) {
        ArrayList<ArrayList<Coin>> coinCombinations = new ArrayList<>();
        for (int numOfNickles = balance; numOfNickles >= 0; numOfNickles--) {
            if (balance < 5) {
                break;
            }
            int newBalance = balance - 5 * numOfNickles;
            if (newBalance == 0) {
                coinCombinations.add(addCoinsToCollection(Coin.NICKLE, numOfNickles));
                System.out.println(numOfNickles + " Nickles ");
            }
            for (int numberOfDimes = newBalance / 5; numberOfDimes >= 0; numberOfDimes--) {
                if (newBalance < 10) {
                    break;
                }
                int finalBalance = newBalance - 10 * numberOfDimes;
                if (finalBalance == 0) {
                    ArrayList<Coin> nickleAndDimeCollection = addCoinsToCollection(Coin.NICKLE, numOfNickles);
                    nickleAndDimeCollection.addAll(addCoinsToCollection(Coin.DIME, numberOfDimes));
                    coinCombinations.add(nickleAndDimeCollection);
                    System.out.println(numOfNickles + " Nickles "
                            + numberOfDimes + " Dimes");
                }
            }
        }
        return coinCombinations;
    }

    public boolean canMakeChange(ArrayList<Coin> bank, int balanceDue){

    }
}

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
        for (int numOfNickels = balance; numOfNickels >= 0; numOfNickels--) {
            if (balance < 5) {
                break;
            }
            int newBalance = balance - 5 * numOfNickels;
            if (newBalance == 0) {
                coinCombinations.add(addCoinsToCollection(Coin.NICKLE, numOfNickels));
            }
            for (int numberOfDimes = newBalance / 5; numberOfDimes >= 0; numberOfDimes--) {
                if (newBalance < 10) {
                    break;
                }
                int finalBalance = newBalance - 10 * numberOfDimes;
                if (finalBalance == 0) {
                    ArrayList<Coin> nickleAndDimeCollection = addCoinsToCollection(Coin.NICKLE, numOfNickels);
                    nickleAndDimeCollection.addAll(addCoinsToCollection(Coin.DIME, numberOfDimes));
                    coinCombinations.add(nickleAndDimeCollection);
                }
            }
        }
        return coinCombinations;
    }

    public boolean canMakeChange(ArrayList<Coin> bank, int balanceDue) {
        boolean changeIsPossible = false;
        ArrayList<ArrayList<Coin>> changePossibilties = getChangeCombinations(balanceDue);
        for (ArrayList<Coin> change : changePossibilties) {
            if (bank.containsAll(change)) {
                changeIsPossible = true;
                break;
            }
        }
        return changeIsPossible;

    }

    public ArrayList removeCoins(ArrayList<Coin> bank, ArrayList<Coin> coinsToRemove) {
        for (Coin coin : coinsToRemove) {
            bank.remove(coin);
        }
        return bank;
    }

    public ArrayList addCoinsOnlyIfAvailable(ArrayList<Coin> bank, ArrayList<Coin> coinsToAdd, ArrayList<Coin> placeToAddCoins) {
        for (Coin coin : coinsToAdd) {
            if (bank.contains(coin)) {
                bank.remove(coin);
                placeToAddCoins.add(coin);
            }
        }
        return placeToAddCoins;
    }

}

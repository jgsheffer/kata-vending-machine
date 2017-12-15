import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Jared on 12/15/2017.
 */
public class CoinUtilityTests {

    CoinUtility coinUtility;

    @Before
    public void setup() {
        coinUtility = new CoinUtility();
    }

    @Test
    public void whenAddCoinToColletionIsCalled_ThenItReturnsAnArrayListWithTheCorrectNumberOfCoins() {
        ArrayList<Coin> expectedArrayList = new ArrayList<>();
        expectedArrayList.add(Coin.DIME);
        expectedArrayList.add(Coin.DIME);
        expectedArrayList.add(Coin.DIME);

        assertEquals(expectedArrayList, coinUtility.addCoinsToCollection(Coin.DIME, 3));
    }

    @Test
    public void whenAddCoinToColletionIsCalledWithZeroNumberOfCoins_ThenItReturnsAnEmptyArrayList() {
        ArrayList<Coin> expectedArrayList = new ArrayList<>();

        assertEquals(expectedArrayList, coinUtility.addCoinsToCollection(Coin.DIME, 0));
    }

    @Test
    public void whenGivenBalanceOf20_ThenGetChangeCombiationReturnsTheCorrectCombinationsOfCoins() {

        ArrayList<ArrayList<Coin>> expectedCollection = new ArrayList<>();
        ArrayList<Coin> combo1 = coinUtility.addCoinsToCollection(Coin.NICKLE, 2);
        combo1.add(Coin.DIME);
        ArrayList<Coin> combo2 = coinUtility.addCoinsToCollection(Coin.DIME, 2);
        expectedCollection.add(coinUtility.addCoinsToCollection(Coin.NICKLE, 4));
        expectedCollection.add(combo1);
        expectedCollection.add(combo2);

        assertEquals(expectedCollection, coinUtility.getChangeCombinations(20));
    }


    @Test
    public void whenGivenBalanceOf15_ThenGetChangeCombiationReturnsTheCorrectCombinationsOfCoins() {

        ArrayList<ArrayList<Coin>> expectedCollection = new ArrayList<>();
        ArrayList<Coin> combo1 = new ArrayList<>();
        combo1.add(Coin.NICKLE);
        combo1.add(Coin.DIME);
        expectedCollection.add(coinUtility.addCoinsToCollection(Coin.NICKLE, 3));
        expectedCollection.add(combo1);

        assertEquals(expectedCollection, coinUtility.getChangeCombinations(15));
    }


    @Test
    public void whenGivenBalanceOf10_ThenGetChangeCombiationReturnsTheCorrectCombinationsOfCoins() {

        ArrayList<ArrayList<Coin>> expectedCollection = new ArrayList<>();
        ArrayList<Coin> combo1 = coinUtility.addCoinsToCollection(Coin.NICKLE, 2);
        ArrayList<Coin> combo2 = coinUtility.addCoinsToCollection(Coin.DIME, 1);
        expectedCollection.add(combo1);
        expectedCollection.add(combo2);

        assertEquals(expectedCollection, coinUtility.getChangeCombinations(10));
    }

    @Test
    public void whenGivenBalanceOf5_ThenGetChangeCombiationReturnsTheCorrectCombinationsOfCoins() {

        ArrayList<ArrayList<Coin>> expectedCollection = new ArrayList<>();
        ArrayList<Coin> combo1 = coinUtility.addCoinsToCollection(Coin.NICKLE, 1);
        expectedCollection.add(combo1);

        assertEquals(expectedCollection, coinUtility.getChangeCombinations(5));
    }

    @Test
    public void whenGivenBalanceOf0_ThenReturnsEmptyArray() {

        ArrayList<ArrayList<Coin>> expectedCollection = new ArrayList<>();

        assertEquals(expectedCollection, coinUtility.getChangeCombinations(0));
    }

    @Test
    public void whenTheGivenCollectionCanNotMakeAllPossibleChange_ThenDoesCollectionContainAllPossibleChangeReturnsFalse() {

        ArrayList<ArrayList<Coin>> expectedCollection = new ArrayList<>();

        assertEquals(expectedCollection, coinUtility.getChangeCombinations(0));
    }

    @Test
    public void whenTheGivenCollectionCanMakeChange_ThenCanMakeChangeReturnsTrue() {

        ArrayList<Coin> bank = new ArrayList<>();
        bank.add(Coin.NICKLE);
        bank.add(Coin.NICKLE);
        bank.add(Coin.NICKLE);
        bank.add(Coin.NICKLE);
        assertTrue(coinUtility.canMakeChange(bank, 20));
    }

    @Test
    public void whenTheGivenCollectionCanNotMakeChange_ThenCanMakeChangeReturnsFalse() {

        ArrayList<Coin> bank = new ArrayList<>();

        assertFalse(coinUtility.canMakeChange(bank, 20));
    }


    @Test
    public void removingCoinsOnlyRemovesTheCorrectNumberOfCoins() {
        ArrayList<Coin> expected = new ArrayList<>();
        expected.add(Coin.QUARTER);
        expected.add(Coin.NICKLE);

        ArrayList<Coin> bank = new ArrayList<>();
        bank.add(Coin.QUARTER);
        bank.add(Coin.NICKLE);

        bank.add(Coin.NICKLE);
        ArrayList<Coin> coinsToRemove = new ArrayList<>();
        coinsToRemove.add(Coin.NICKLE);

        assertEquals(expected, new CoinUtility().removeCoins(bank, coinsToRemove));

    }

    @Test
    public void addCoinsOnlyIfAvailableTest() {
        ArrayList<Coin> expected = new ArrayList<>();
        expected.add(Coin.QUARTER);

        ArrayList<Coin> bank = new ArrayList<>();
        bank.add(Coin.QUARTER);

        ArrayList<Coin> coinsToAdd = new ArrayList<>();
        coinsToAdd.add(Coin.NICKLE);
        coinsToAdd.add(Coin.QUARTER);

        assertEquals(expected, new CoinUtility().addCoinsOnlyIfAvailable(bank, coinsToAdd, new ArrayList<>()));

    }


}


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Jared on 12/14/2017.
 */
public class CoinReturnTests {
    CoinReturn coinReturn;

    @Before
    public void setup() {
        coinReturn = new CoinReturn();
    }

    @Test
    public void whenGetCoinReturnCollectionIsCalled_ThenItReturnsTheCurrentCoinCollection() {
        assertEquals(new ArrayList<Coin>(), coinReturn.getCoinReturnCollection());
    }

    @Test
    public void whenAddCoinToReturnIsCalled_ThenItAddsTheGivenCoinToTheReturnCollection() {
        ArrayList<Coin> expectedCollection = new ArrayList();
        expectedCollection.add(Coin.DOLLAR);

        coinReturn.addCoinToCoinReturn(Coin.DOLLAR);

        assertEquals(expectedCollection, coinReturn.getCoinReturnCollection());
    }

    @Test
    public void whenReturnIsCleared_ThenEmptiesTheReturnCollection() {
        ArrayList<Coin> expectedCollection = new ArrayList();
        expectedCollection.add(Coin.DOLLAR);

        coinReturn.addCoinToCoinReturn(Coin.DOLLAR);
        assertEquals(expectedCollection, coinReturn.getCoinReturnCollection());
        coinReturn.emptyCoinReturn();

        assertEquals(new ArrayList(), coinReturn.getCoinReturnCollection());
    }

    @Test
    public void whenGivenABalanceOf005_ThenGetChangeToReturnWillReturnANickle() {
        ArrayList<Coin> expectedCollection = new ArrayList();
        expectedCollection.add(Coin.NICKLE);

        coinReturn.addCorrectChangeToReturn(5);

        assertEquals(expectedCollection, coinReturn.getCoinReturnCollection());


    }

    @Test
    public void whenGivenABalanceOf015_ThenGetChangeToReturnWillReturnANickleAndADime() {
        ArrayList<Coin> expectedCollection = new ArrayList();
        expectedCollection.add(Coin.NICKLE);
        expectedCollection.add(Coin.DIME);


        coinReturn.addCorrectChangeToReturn(15);

        assertTrue(coinReturn.getCoinReturnCollection().containsAll(expectedCollection));
        assertTrue(expectedCollection.containsAll(coinReturn.getCoinReturnCollection()));


    }

    @Test
    public void whenGivenABalanceOf040_ThenGetChangeToReturnWillReturnANickleQuarterAndADime() {
        ArrayList<Coin> expectedCollection = new ArrayList();
        expectedCollection.add(Coin.NICKLE);
        expectedCollection.add(Coin.DIME);
        expectedCollection.add(Coin.QUARTER);

        coinReturn.addCorrectChangeToReturn(40);
        Collections.sort(expectedCollection);
        assertTrue(coinReturn.getCoinReturnCollection().containsAll(expectedCollection));
        assertTrue(expectedCollection.containsAll(coinReturn.getCoinReturnCollection()));
    }

    @Test
    public void whenGivenABalanceOf115_ThenGetChangeToReturnWillReturnANickleDimeAndFourQuarters() {
        ArrayList<Coin> expectedCollection = new ArrayList();
        expectedCollection.add(Coin.NICKLE);
        expectedCollection.add(Coin.DIME);
        expectedCollection.add(Coin.QUARTER);
        expectedCollection.add(Coin.QUARTER);
        expectedCollection.add(Coin.QUARTER);
        expectedCollection.add(Coin.QUARTER);

        coinReturn.addCorrectChangeToReturn(115);

        assertTrue(coinReturn.getCoinReturnCollection().containsAll(expectedCollection));
        assertTrue(expectedCollection.containsAll(coinReturn.getCoinReturnCollection()));
    }

}

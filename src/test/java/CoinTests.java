import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jared on 12/13/2017.
 */
public class CoinTests {
    VendingMachine vendingMachine;
    String currentBalanceString = "|| Current Balance  : ";
    String emptyMachine = "INSERT COIN";


    @Before
    public void setup() {
        ArrayList<Coin> startingChange = new ArrayList<>();
        startingChange.add(Coin.NICKLE);
        startingChange.add(Coin.NICKLE);
        startingChange.add(Coin.NICKLE);
        startingChange.add(Coin.NICKLE);
        vendingMachine = new VendingMachine(3, startingChange);
    }

    @Test
    public void whenNothingIsInsertedIntoTheVendingMachine_ThenItReturnsCurrentBalanceString() {
        assertEquals("INSERT COIN", vendingMachine.insert(null));
    }

    @Test
    public void vendingMachineCanReturnCurrentBalanceInMachine() {
        assertEquals(0, vendingMachine.getCurrentBalance(), 0);
    }

    @Test
    public void whenAPennyIsInserted_ThenTheVendingMachineReturnsBlankString() {
        assertEquals(emptyMachine, vendingMachine.insert(Coin.PENNY));
    }

    @Test
    public void whenAQuarterIsInserted_ThenTheVendingMachineReturnsItAddedToTheCurrentBalanceString() {
        String expectedBalanceString = currentBalanceString + "$0.25";

        assertEquals(expectedBalanceString, vendingMachine.insert(Coin.QUARTER));
    }

    @Test
    public void whenMultipleQuartersAreInserted_ThenTheBalanceIsAddedTogether() {
        String expectedBalanceFirstCoin = currentBalanceString + "$0.25";
        String expectedBalanceSecondCoin = currentBalanceString + "$0.50";

        assertEquals(expectedBalanceFirstCoin, vendingMachine.insert(Coin.QUARTER));
        assertEquals(expectedBalanceSecondCoin, vendingMachine.insert(Coin.QUARTER));
    }

    @Test
    public void whenANickelIsInserted_ThenTheVendingMachineReturnsCurrentBalanceString() {
        String expectedBalanceString = currentBalanceString + "$0.05";

        assertEquals(expectedBalanceString, vendingMachine.insert(Coin.NICKLE));
    }

    @Test
    public void whenMultipleNickelsAreInserted_ThenTheBalanceIsAddedTogether() {
        String expectedBalanceFirstCoin = currentBalanceString + "$0.05";
        String expectedBalanceSecondCoin = currentBalanceString + "$0.10";

        assertEquals(expectedBalanceFirstCoin, vendingMachine.insert(Coin.NICKLE));
        assertEquals(expectedBalanceSecondCoin, vendingMachine.insert(Coin.NICKLE));
    }

    @Test
    public void whenANickelAndAQuarterAreInserted_ThenTheBalanceIsCompounded() {
        String expectedBalanceFirstCoin = currentBalanceString + "$0.05";
        String expectedBalanceSecondCoin = currentBalanceString + "$0.30";

        assertEquals(expectedBalanceFirstCoin, vendingMachine.insert(Coin.NICKLE));
        assertEquals(expectedBalanceSecondCoin, vendingMachine.insert(Coin.QUARTER));
    }


    @Test
    public void whenADimeIsInserted_ThenTheVendingMachineReturnsCurrentBalanceString() {
        String expectedBalanceString = currentBalanceString + "$0.10";

        assertEquals(expectedBalanceString, vendingMachine.insert(Coin.DIME));
    }

    @Test
    public void whenMultipleDimesAreInserted_ThenTheBalanceIsAddedTogether() {
        String expectedBalanceFirstCoin = currentBalanceString + "$0.10";
        String expectedBalanceSecondCoin = currentBalanceString + "$0.20";

        assertEquals(expectedBalanceFirstCoin, vendingMachine.insert(Coin.DIME));
        assertEquals(expectedBalanceSecondCoin, vendingMachine.insert(Coin.DIME));
    }

    @Test
    public void whenADimeANickelAndAQuarterAreInserted_ThenTheBalanceIsCompounded() {
        String expectedBalanceFirstCoin = currentBalanceString + "$0.05";
        String expectedBalanceSecondCoin = currentBalanceString + "$0.30";
        String expectedBalanceThirdCoin = currentBalanceString + "$0.40";

        assertEquals(expectedBalanceFirstCoin, vendingMachine.insert(Coin.NICKLE));
        assertEquals(expectedBalanceSecondCoin, vendingMachine.insert(Coin.QUARTER));
        assertEquals(expectedBalanceThirdCoin, vendingMachine.insert(Coin.DIME));
    }

    @Test
    public void whenADollarCoinIsInserted_ThenTheVendingMachineReturnsBlankString() {
        assertEquals(emptyMachine, vendingMachine.insert(Coin.DOLLAR));
    }

    @Test
    public void whenNothingIsInsertedAfterAQuarter_ThenItStillReturnsTheCurrentBalanceString() {
        String expectedBalanceFirstCoin = currentBalanceString + "$0.25";

        assertEquals(expectedBalanceFirstCoin, vendingMachine.insert(Coin.QUARTER));
        assertEquals(expectedBalanceFirstCoin, vendingMachine.insert(null));
    }

    @Test
    public void whenADollarCoinIsInserted_ThenItIsAddedToTheCoinReturn() {
        ArrayList<Coin> expectedCoinReturn = new ArrayList<>();
        assertEquals(expectedCoinReturn, vendingMachine.getCoinReturn().getCoinReturnCollection());

        vendingMachine.insert(Coin.DOLLAR);
        expectedCoinReturn.add(Coin.DOLLAR);
        vendingMachine.insert(Coin.QUARTER);

        assertEquals(expectedCoinReturn, vendingMachine.getCoinReturn().getCoinReturnCollection());
    }

    @Test
    public void whenMultipleInvalidCoinsAreInserted_ThenTheyAreAllSentToTheCoinReturn() {
        ArrayList<Coin> expectedCoinReturn = new ArrayList<>();
        expectedCoinReturn.add(Coin.DOLLAR);
        expectedCoinReturn.add(Coin.PENNY);


        vendingMachine.insert(Coin.DOLLAR);
        vendingMachine.insert(Coin.PENNY);

        assertEquals(expectedCoinReturn, vendingMachine.getCoinReturn().getCoinReturnCollection());
    }

    @Test
    public void theCoinReturnCanBeEmptied() {
        ArrayList<Coin> expectedCoinReturn = new ArrayList<>();
        vendingMachine.insert(Coin.DOLLAR);
        vendingMachine.insert(Coin.DOLLAR);

        vendingMachine.getCoinReturn().emptyCoinReturn();

        assertEquals(expectedCoinReturn, vendingMachine.getCoinReturn().getCoinReturnCollection());
    }

    @Test
    public void whenACoinIsInserted_ThenItIsAddedToTheCoinBalanceCollection() {
        vendingMachine.insert(Coin.DIME);
        assertEquals(Coin.DIME, vendingMachine.getCurrentCoinBalanceCollection().get(0));
    }


}

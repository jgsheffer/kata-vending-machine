import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jared on 12/13/2017.
 */
public class CoinTests {
    VendingMachine vendingMachine;
    String currentBalanceString = "|| Current Balance  : ";
    String emptyMachine = "INSERT COIN";


    @Before
    public void setup() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void whenNothingIsInsertedIntoTheVendingMachine_ThenItReturnsCurrentBalanceString() {
        assertEquals("INSERT COIN",vendingMachine.insert(null));
    }

    @Test
    public void vendingMachineCanReturnCurrentBalanceInMachine() {
        assertEquals(0, vendingMachine.getCurrentBalance(), 0);
    }

    @Test
    public void whenAPennyIsInserted_ThenTheVendingMachineReturnsBlankString() {
        assertEquals(emptyMachine,vendingMachine.insert(Coin.PENNY));
    }

    @Test
    public void whenAQuarterIsInserted_ThenTheVendingMachineReturnsItAddedToTheCurrentBalanceString() {
        String expectedBalanceString = currentBalanceString+"$0.25";

        assertEquals(expectedBalanceString,vendingMachine.insert(Coin.QUARTER));
    }

    @Test
    public void whenMultipleQuartersAreInserted_ThenTheBalanceIsAddedTogether() {
        String expectedBalanceFirstCoin = currentBalanceString+"$0.25";
        String expectedBalanceSecondCoin = currentBalanceString+"$0.50";

        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.QUARTER));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.QUARTER));
    }

    @Test
    public void whenANickleIsInserted_ThenTheVendingMachineReturnsCurrentBalanceString() {
        String expectedBalanceString = currentBalanceString+"$0.05";

        assertEquals(expectedBalanceString,vendingMachine.insert(Coin.NICKLE));
    }

    @Test
    public void whenMultipleNicklesAreInserted_ThenTheBalanceIsAddedTogether() {
        String expectedBalanceFirstCoin = currentBalanceString+"$0.05";
        String expectedBalanceSecondCoin = currentBalanceString+"$0.10";

        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.NICKLE));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.NICKLE));
    }

    @Test
    public void whenANickleAndAQuarterAreInserted_ThenTheBalanceIsCompounded() {
        String expectedBalanceFirstCoin = currentBalanceString+"$0.05";
        String expectedBalanceSecondCoin = currentBalanceString+"$0.30";

        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.NICKLE));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.QUARTER));
    }


    @Test
    public void whenADimeIsInserted_ThenTheVendingMachineReturnsCurrentBalanceString() {
        String expectedBalanceString = currentBalanceString+"$0.10";

        assertEquals(expectedBalanceString ,vendingMachine.insert(Coin.DIME));
    }

    @Test
    public void whenMultipleDimesAreInserted_ThenTheBalanceIsAddedTogether() {
        String expectedBalanceFirstCoin = currentBalanceString+"$0.10";
        String expectedBalanceSecondCoin = currentBalanceString+"$0.20";

        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.DIME));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.DIME));
    }

    @Test
    public void whenADimeANickleAndAQuarterAreInserted_ThenTheBalanceIsCompounded() {
        String expectedBalanceFirstCoin = currentBalanceString+"$0.05";
        String expectedBalanceSecondCoin = currentBalanceString+"$0.30";
        String expectedBalanceThirdCoin = currentBalanceString+"$0.40";

        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.NICKLE));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.QUARTER));
        assertEquals(expectedBalanceThirdCoin,vendingMachine.insert(Coin.DIME));
    }
    @Test
    public void whenADollarCoinIsInserted_ThenTheVendingMachineReturnsBlankString() {
        assertEquals(emptyMachine,vendingMachine.insert(Coin.DOLLAR));
    }

    @Test
    public void whenNothingIsInsertedAfterAQuarter_ThenItStillReturnsTheCurrentBalanceString() {
        String expectedBalanceFirstCoin = currentBalanceString+"$0.25";

        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.QUARTER));
        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(null));
    }

    @Test
    public void whenADollarCoinIsInserted_ThenItIsAddedToTheCoinReturn() {
        ArrayList<Coin> expectedCoinReturn = new ArrayList<>();
        assertEquals(expectedCoinReturn,vendingMachine.getCoinReturn());

        vendingMachine.insert(Coin.DOLLAR);
        expectedCoinReturn.add(Coin.DOLLAR);
        vendingMachine.insert(Coin.QUARTER);

        assertEquals(expectedCoinReturn,vendingMachine.getCoinReturn());
    }

    @Test
    public void whenMultipleInvalidCoinsAreInserted_ThenTheyAreAllSentToTheCoinReturn() {
        ArrayList<Coin> expectedCoinReturn = new ArrayList<>();
        expectedCoinReturn.add(Coin.DOLLAR);
        expectedCoinReturn.add(Coin.PENNY);


        vendingMachine.insert(Coin.DOLLAR);
        vendingMachine.insert(Coin.PENNY);

        assertEquals(expectedCoinReturn,vendingMachine.getCoinReturn());
    }

    @Test
    public void theCoinReturnCanBeEmptied() {
        ArrayList<Coin> expectedCoinReturn = new ArrayList<>();
        vendingMachine.insert(Coin.DOLLAR);
        vendingMachine.insert(Coin.DOLLAR);

        vendingMachine.emptyCoinReturn();

        assertEquals(expectedCoinReturn,vendingMachine.getCoinReturn());
    }


}

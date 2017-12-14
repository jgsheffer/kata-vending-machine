import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jared on 12/13/2017.
 */
public class CoinTests {
    VendingMachine vendingMachine;
    String currentBalanceString = "|| Current Balance  : ";
    String emptyMachine = currentBalanceString+"0";


    @Before
    public void setup() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void whenNothingIsInsertedIntoTheVendingMachineReturnsCurrentBalanceString() {
        assertEquals("INSERT COIN",vendingMachine.insert(null));
    }

    @Test
    public void vendingMachineCanReturnCurrentBalanceInMachine() {
        assertEquals(0, vendingMachine.getCurrentBalance());
    }

    @Test
    public void whenAPennyIsInsertedThenTheVendingMachineReturnsBlankString() {
        assertEquals("",vendingMachine.insert(Coin.PENNY));
    }

    @Test
    public void whenAQuarterIsInsertedThenTheVendingMachineReturnsItAddedToTheCurrentBalanceString() {
        String expectedBalanceString = currentBalanceString+"25";
        assertEquals(expectedBalanceString,vendingMachine.insert(Coin.QUARTER));
    }

    @Test
    public void whenMultipleQuartersAreInsertedThenTheBalanceIsAddedTogether() {
        String expectedBalanceFirstCoin = currentBalanceString+"25";
        String expectedBalanceSecondCoin = currentBalanceString+"50";
        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.QUARTER));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.QUARTER));
    }

    @Test
    public void whenANickleIsInsertedThenTheVendingMachineReturnsCurrentBalanceString() {
        String expectedBalanceString = currentBalanceString+"5";
        assertEquals(expectedBalanceString,vendingMachine.insert(Coin.NICKLE));
    }

    @Test
    public void whenMultipleNicklesAreInsertedThenTheBalanceIsAddedTogether() {
        String expectedBalanceFirstCoin = currentBalanceString+"5";
        String expectedBalanceSecondCoin = currentBalanceString+"10";
        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.NICKLE));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.NICKLE));
    }

    @Test
    public void whenANickleAndAQuarterAreInsertedThenTheBalanceIsCompounded() {
        String expectedBalanceFirstCoin = currentBalanceString+"5";
        String expectedBalanceSecondCoin = currentBalanceString+"30";
        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.NICKLE));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.QUARTER));
    }


    @Test
    public void whenADimeIsInsertedThenTheVendingMachineReturnsCurrentBalanceString() {
        String expectedBalanceString = currentBalanceString+"10";
        assertEquals(expectedBalanceString ,vendingMachine.insert(Coin.DIME));
    }

    @Test
    public void whenMultipleDimesAreInsertedThenTheBalanceIsAddedTogether() {
        String expectedBalanceFirstCoin = currentBalanceString+"10";
        String expectedBalanceSecondCoin = currentBalanceString+"20";
        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.DIME));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.DIME));
    }

    @Test
    public void whenADimeANickleAndAQuarterAreInsertedThenTheBalanceIsCompounded() {
        String expectedBalanceFirstCoin = currentBalanceString+"5";
        String expectedBalanceSecondCoin = currentBalanceString+"30";
        String expectedBalanceThirdCoin = currentBalanceString+"40";
        assertEquals(expectedBalanceFirstCoin,vendingMachine.insert(Coin.NICKLE));
        assertEquals(expectedBalanceSecondCoin,vendingMachine.insert(Coin.QUARTER));
        assertEquals(expectedBalanceThirdCoin,vendingMachine.insert(Coin.DIME));
    }
    @Test
    public void whenADollarCoinIsInsertedThenTheVendingMachineReturnsBlankString() {
        assertEquals("",vendingMachine.insert(Coin.DOLLAR));
    }

}

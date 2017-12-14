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
    String emptyMachine = "|| Current Balance  : 0";

    @Before
    public void setup() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void whenNothingIsInsertedIntoTheVendingMachineReturnsCurrentBalanceString() {
        assertEquals("",vendingMachine.insert(null));
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
    public void whenAQuarterIsInsertedThenTheVendingMachineReturnsCurrentBalanceString() {
        assertEquals(emptyMachine,vendingMachine.insert(Coin.QUARTER));
    }

    @Test
    public void whenANickleIsInsertedThenTheVendingMachineReturnsCurrentBalanceString() {
        assertEquals(emptyMachine,vendingMachine.insert(Coin.NICKLE));
    }

    @Test
    public void whenADimeIsInsertedThenTheVendingMachineReturnsCurrentBalanceString() {
        assertEquals(emptyMachine ,vendingMachine.insert(Coin.DIME));
    }
    @Test
    public void whenADollarCoinIsInsertedThenTheVendingMachineReturnsBlankString() {
        assertEquals("",vendingMachine.insert(Coin.DOLLAR));
    }

}

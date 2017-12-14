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

    @Before
    public void setup() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void whenNothingIsInsertedIntoTheVendingMachineReturnsFalse() {
        assertFalse(vendingMachine.insert(null));
    }

    @Test
    public void vendingMachineCanReturnCurrentBalanceInMachine() {
        assertEquals(0, vendingMachine.getCurrentBalance());
    }

    @Test
    public void whenAPennyIsInsertedThenTheVendingMachineReturnsFalse() {
        assertFalse(vendingMachine.insert(Coin.PENNY));
    }

    @Test
    public void whenAQuarterIsInsertedThenTheVendingMachineReturnsTrue() {
        assertTrue(vendingMachine.insert(Coin.QUARTER));
    }

    @Test
    public void whenANickleIsInsertedThenTheVendingMachineReturnsTrue() {
        assertTrue(vendingMachine.insert(Coin.NICKLE));
    }

    @Test
    public void whenADimeIsInsertedThenTheVendingMachineReturnsTrue() {
        assertTrue(vendingMachine.insert(Coin.DIME));
    }
    @Test
    public void whenADollarCoinIsInsertedThenTheVendingMachineReturnsFalse() {
        assertFalse(vendingMachine.insert(Coin.DOLLAR));
    }

}

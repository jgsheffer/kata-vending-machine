import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jared on 12/13/2017.
 */
public class CoinTests {
@Test
    public void whenNothingIsInsertedIntoTheVendingMachineReturnsFalse(){
        VendingMachine vendingMachine = new VendingMachine();
        assertFalse(vendingMachine.insert(null));
    }
@Test
    public void whenCoinIsInsertedIntoTheVendingMachineItReturnTrue(){
        VendingMachine vendingMachine = new VendingMachine();
        assertTrue(vendingMachine.insert(Coin.COIN));
    }

    @Test
    public void vendingMachineCanReturnCurrentBalanceInMachine(){
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals("", vendingMachine.getCurrentBalance());
    }
}

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jared on 12/13/2017.
 */
public class CoinTests {
@Test
    public void whenNothingIsInsertedIntoTheVendingMachineReturnsFalse(){
        VendingMachine vendingMachine = new VendingMachine();
        assertFalse(vendingMachine.insert());
    }
}

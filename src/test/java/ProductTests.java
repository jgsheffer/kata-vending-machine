import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Target;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jared on 12/13/2017.
 */
public class ProductTests {
    VendingMachine vendingMachine;

    @Before
    public void setup(){
        vendingMachine = new VendingMachine();
    }
    @Test
    public void getItemSlotReturnsAnItemSlotObject(){
        assertEquals(ItemSlot.class, vendingMachine.getItemSlot().getClass());
    }
}
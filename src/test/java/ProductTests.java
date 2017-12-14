import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jared on 12/13/2017.
 */
public class ProductTests {
    VendingMachine vendingMachine;
    String slotOneName ="cola";
    double slotOnePrice =1.00;

    @Before
    public void setup(){
        vendingMachine = new VendingMachine();
    }
    @Test
    public void getItemSlotReturnsAnItemSlotObject(){
        assertEquals(ItemSlot.class, vendingMachine.getItemSlot().getClass());
    }
    @Test
    public void whenGetInventoryIsCalled_ThenItReturnsACollectionOfItemSlotsIsReturned(){
        assertEquals(HashMap.class, vendingMachine.getInventory().getClass());
    }

    @Test
    public void whenVendingMachineIsCreatedItHasAnInventoryWithAnItemSlotContainingCola(){
        assertEquals(slotOneName, ((ItemSlot)vendingMachine.getInventory().get(1)).getItem());
        assertEquals(slotOnePrice, ((ItemSlot)vendingMachine.getInventory().get(1)).getPrice(),0);
    }
}

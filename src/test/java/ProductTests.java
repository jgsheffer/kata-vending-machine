import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Jared on 12/13/2017.
 */
public class ProductTests {
    VendingMachine vendingMachine;
    String slotOneName ="cola";
    double slotOnePrice =1.00;
    String slotTwoName ="chips";
    double slotTwoPrice =0.50;
    String slotThreeName ="candy";
    double slotThreePrice =0.65;

    @Before
    public void setup(){
        vendingMachine = new VendingMachine();
    }
    @Test
    public void getItemSlotReturnsAnItemSlotObject(){
        assertEquals(ItemSlot.class, vendingMachine.getItemSlot(1).getClass());
    }
    @Test
    public void whenGetInventoryIsCalled_ThenItReturnsACollectionOfItemSlotsIsReturned(){
        assertEquals(HashMap.class, vendingMachine.getInventory().getClass());
    }

    @Test
    public void whenVendingMachineIsCreated_ThenItHasAnInventoryWithAnItemSlotContainingCola(){
        assertEquals(slotOneName, ((ItemSlot)vendingMachine.getInventory().get(1)).getItem());
        assertEquals(slotOnePrice, ((ItemSlot)vendingMachine.getInventory().get(1)).getPrice(),0);
    }

    @Test
    public void whenVendingMachineIsCreated_ThenItHasAnInventoryWithAnItemSlotContainingChips(){
        assertEquals(slotTwoName, ((ItemSlot)vendingMachine.getInventory().get(2)).getItem());
        assertEquals(slotTwoPrice, ((ItemSlot)vendingMachine.getInventory().get(2)).getPrice(),0);
    }

    @Test
    public void whenVendingMachineIsCreated_ThenItHasAnInventoryWithAnItemSlotContainingCandy(){
        assertEquals(slotThreeName, ((ItemSlot)vendingMachine.getInventory().get(3)).getItem());
        assertEquals(slotThreePrice, ((ItemSlot)vendingMachine.getInventory().get(3)).getPrice(),0);
    }

    @Test
    public void whenGetItemSlotIsCalledOnAnInValidSlot_ThenItReturnsNull(){
        assertNull(vendingMachine.getItemSlot(5));
    }

    @Test
    public void whenIInsertEnoughMoneyAndIPressThe1Button_ThenIWillGetAThankYouMessage(){
        String expectedMessage = "THANK YOU";
        assertEquals(expectedMessage, vendingMachine.pressButton(1));
    }

}

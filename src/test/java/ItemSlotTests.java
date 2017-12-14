import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Jared on 12/13/2017.
 */
public class ItemSlotTests {
    @Test
    public void whenItemSlotIsCreated_ThenYouCanGetTheAttributes(){
        int expectedPrice = 100;
        String expectedItem = "cola";
        int numberOfItems = 5;
        ItemSlot itemSlot = new ItemSlot(expectedPrice, expectedItem, numberOfItems);
        assertEquals(expectedItem, itemSlot.getItem());
        assertEquals(expectedPrice, itemSlot.getPrice());
        assertEquals(numberOfItems, itemSlot.getNumberOfItemsAvailable());
    }

    @Test
    public void whenIPurchaseAnItem_ThenItIsRemovedFromTheItemSlot(){
        int expectedNumberOfItems = 5;

        ItemSlot itemSlot = new ItemSlot(100, "cola", 6);
        itemSlot.dispense();

        assertEquals(expectedNumberOfItems, itemSlot.getNumberOfItemsAvailable());
    }


    @Test
    public void whenITryToPurchaseAnItemButItIsNotAvailable_ThenItIsNotDispensed(){
        int expectedNumberOfItems = 0;

        ItemSlot itemSlot = new ItemSlot(100, "cola", 0);
        assertFalse(itemSlot.dispense());

        assertEquals(expectedNumberOfItems, itemSlot.getNumberOfItemsAvailable());
    }
}

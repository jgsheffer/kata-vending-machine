import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jared on 12/13/2017.
 */
public class ItemSlotTests {
    @Test
    public void whenItemSlotIsCreated_ThenYouCanGetTheAttributes(){
        double expectedPrice = 1.00;
        String expectedItem = "cola";
        ItemSlot itemSlot = new ItemSlot(expectedPrice, expectedItem);
        assertEquals(itemSlot.getItem(), expectedItem);
        assertEquals(itemSlot.getPrice(), expectedPrice, 0);
    }
}

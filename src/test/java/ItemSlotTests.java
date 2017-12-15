import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Jared on 12/13/2017.
 */
public class ItemSlotTests {
    @Test
    public void whenItemSlotIsCreated_ThenYouCanGetTheAttributes() {
        int expectedPrice = 100;
        String expectedItem = "cola";
        int numberOfItems = 5;
        ItemSlot itemSlot = new ItemSlot(expectedPrice, expectedItem, numberOfItems);
        assertEquals(expectedItem, itemSlot.getItem());
        assertEquals(expectedPrice, itemSlot.getPrice());
        assertEquals(numberOfItems, itemSlot.getNumberOfItemsAvailable());
    }

    @Test
    public void whenIPurchaseAnItem_ThenItIsRemovedFromTheItemSlot() {
        int expectedNumberOfItems = 5;

        ItemSlot itemSlot = new ItemSlot(100, "cola", 6);
        itemSlot.dispense();

        assertEquals(expectedNumberOfItems, itemSlot.getNumberOfItemsAvailable());
    }


    @Test
    public void whenITryToPurchaseAnItemButItIsNotAvailable_ThenItIsNotDispensed() {
        int expectedNumberOfItems = 0;

        ItemSlot itemSlot = new ItemSlot(100, "cola", 0);
        assertFalse(itemSlot.dispense());

        assertEquals(expectedNumberOfItems, itemSlot.getNumberOfItemsAvailable());
    }

    //    @Test
//    public void foo(){
//        ArrayList<Coin> expectedWorstCaseCollection = new ArrayList<>();
//        expectedWorstCaseCollection.add(Coin.NICKLE);
//        ItemSlot itemSlot = new ItemSlot(100, "cola", 0);
//        assertEquals(expectedWorstCaseCollection, itemSlot.getWorstCaseCollection())
//    }
    @Test
    public void reduceCoinsWillReturnTheMinmumAmountOfChangeWithoutMeetingOrGoingOver() {
        ItemSlot itemSlot = new ItemSlot(65, "cola", 6);

        assertEquals(15, itemSlot.removeQuartersFromBalance(65));
        assertEquals(25, itemSlot.removeQuartersFromBalance(50));
        assertEquals(10, itemSlot.removeQuartersFromBalance(60));
        assertEquals(5, itemSlot.removeQuartersFromBalance(5));
        assertEquals(25, itemSlot.removeQuartersFromBalance(50));
    }

    @Test
    public void whenGivenABalnceOf70_ThenTheCorrectChangeCombinationsAreReturned() {
        ArrayList<ArrayList<Coin>> expectedCoinCombinations = new ArrayList<>();
        ArrayList<Coin> coinCombinationOne = new ArrayList<>();
        coinCombinationOne.add(Coin.NICKLE);
        expectedCoinCombinations.add(coinCombinationOne);

    }
}

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Jared on 12/13/2017.
 */
public class VendingMachineTests {
    VendingMachine vendingMachine;
    String slotOneName = "cola";
    int slotOnePrice = 100;
    String slotTwoName = "chips";
    int slotTwoPrice = 50;
    String slotThreeName = "candy";
    int slotThreePrice = 65;

    @Before
    public void setup() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void getItemSlotReturnsAnItemSlotObject() {
        assertEquals(ItemSlot.class, vendingMachine.getItemSlot(1).getClass());
    }

    @Test
    public void whenGetInventoryIsCalled_ThenItReturnsACollectionOfItemSlotsIsReturned() {
        assertEquals(HashMap.class, vendingMachine.getInventory().getClass());
    }

    @Test
    public void whenVendingMachineIsCreated_ThenItHasAnInventoryWithAnItemSlotContainingCola() {
        assertEquals(slotOneName, ((ItemSlot) vendingMachine.getInventory().get(1)).getItem());
        assertEquals(slotOnePrice, ((ItemSlot) vendingMachine.getInventory().get(1)).getPrice(), 0);
    }

    @Test
    public void whenVendingMachineIsCreated_ThenItHasAnInventoryWithAnItemSlotContainingChips() {
        assertEquals(slotTwoName, ((ItemSlot) vendingMachine.getInventory().get(2)).getItem());
        assertEquals(slotTwoPrice, ((ItemSlot) vendingMachine.getInventory().get(2)).getPrice(), 0);
    }

    @Test
    public void whenVendingMachineIsCreated_ThenItHasAnInventoryWithAnItemSlotContainingCandy() {
        assertEquals(slotThreeName, ((ItemSlot) vendingMachine.getInventory().get(3)).getItem());
        assertEquals(slotThreePrice, ((ItemSlot) vendingMachine.getInventory().get(3)).getPrice());
    }

    @Test
    public void whenGetItemSlotIsCalledOnAnInValidSlot_ThenItReturnsNull() {
        assertNull(vendingMachine.getItemSlot(5));
    }

    @Test
    public void whenIInsertEnoughMoneyAndIPressThe1Button_ThenIWillGetAThankYouMessage() {
        String expectedMessage = "THANK YOU";

        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.pressButton(1);

        assertEquals(expectedMessage, vendingMachine.getCurrentDisplay());
    }

    @Test
    public void whenIInsertEnoughMoneyAndIPressThe2Button_ThenTheAmountWillBeDeductedFromTheBalance() {
        Double expectedBalance = 0.0;

        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.pressButton(2);

        assertEquals(expectedBalance, vendingMachine.getCurrentBalance(), 0);
    }

    @Test
    public void whenNotEnoughMoneyAndIPressThe1Button_ThenIWillGetAPriceMessage() {
        String expectedMessage = "PRICE : $1.00";

        vendingMachine.pressButton(1);

        assertEquals(expectedMessage, vendingMachine.getCurrentDisplay());
    }

    @Test
    public void whenNotEnoughMoneyAndIPressThe1Button_ThenIWillGetAPriceMessageTheFirstTimeOnly() {
        String firstExpectedMessage = "PRICE : $1.00";
        String secondExpectedMessage = "INSERT COIN";

        vendingMachine.pressButton(1);
        assertEquals(firstExpectedMessage, vendingMachine.getCurrentDisplay());
        vendingMachine.pressButton(1);

        assertEquals(secondExpectedMessage, vendingMachine.getCurrentDisplay());
    }

    @Test
    public void whenNotEnoughMoneyAndIPressThe3Button_ThenTheMessageWillAlternate() {
        vendingMachine.insert(Coin.QUARTER);
        String firstExpectedMessage = "PRICE : $1.00";
        String secondExpectedMessage = "|| Current Balance  : $0.25";

        vendingMachine.pressButton(1);
        assertEquals(firstExpectedMessage, vendingMachine.getCurrentDisplay());
        vendingMachine.pressButton(1);
        assertEquals(secondExpectedMessage, vendingMachine.getCurrentDisplay());
        vendingMachine.pressButton(1);
        assertEquals(secondExpectedMessage, vendingMachine.getCurrentDisplay());
    }

    @Test
    public void whenIInsertEnoughMoneyAndIPressTheAnInvalidButton_ThenIWillGetAnInvalidMessage() {
        String expectedMessage = "INVALID OPTION PLEASE SELECT AGAIN";
        vendingMachine.pressButton(9);

        assertEquals(expectedMessage, vendingMachine.getCurrentDisplay());
    }

    @Test
    public void whenProductIsPurchased_ThenTheCoinsAreAddedToTheBank() {
        ArrayList<Coin> expectedBank = new ArrayList<>();
        expectedBank.add(Coin.QUARTER);
        expectedBank.add(Coin.QUARTER);

        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.pressButton(2);

        assertEquals(expectedBank, vendingMachine.getBank());
    }


    @Test
    public void whenProductIsPurchasedWithExtraMoney_ThenTheCoinsAreAddedToTheBankButTheExtraIsSentToTheCoinReturn() {
        ArrayList<Coin> expectedBank = new ArrayList<>();
        ArrayList<Coin> expectedCoinReturn = new ArrayList<>();
        expectedCoinReturn.add(Coin.NICKLE);
        expectedCoinReturn.add(Coin.QUARTER);
        expectedBank.add(Coin.QUARTER);
        expectedBank.add(Coin.QUARTER);
        expectedBank.add(Coin.QUARTER);
        expectedBank.add(Coin.NICKLE);


        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.NICKLE);
        vendingMachine.pressButton(2);

        assertEquals(expectedBank, vendingMachine.getBank());
        assertTrue(expectedCoinReturn.containsAll(vendingMachine.getCoinReturn().getCoinReturnCollection()));
    }

    @Test
    public void whenAnItemIsSoldOut_ThenIGetASoldOutMessage() {
        vendingMachine = new VendingMachine(0);
        String expectedMessage = "SOLD OUT";

        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.pressButton(1);

        assertEquals(expectedMessage, vendingMachine.getCurrentDisplay());
    }

    @Test
    public void whenPressingCoinReturnButton_ThenAllChangeIsReturnedToCoinReturn() {
        ArrayList<Coin> expectedCoinReturnCollection = new ArrayList<>();
        expectedCoinReturnCollection.add(Coin.QUARTER);
        expectedCoinReturnCollection.add(Coin.QUARTER);
        expectedCoinReturnCollection.add(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);
        vendingMachine.insert(Coin.QUARTER);

        vendingMachine.pushChangeReturnButton();

        assertEquals(expectedCoinReturnCollection, vendingMachine.getCoinReturn().getCoinReturnCollection());
    }

    @Test
    public void whenMachineCantMakeChange_ThenCurrentDisplayShowsCorrectMessage() {
        String expectedMessage = "EXACT CHANGE ONLY";

        assertEquals(expectedMessage, vendingMachine.getCurrentDisplay());
    }

}

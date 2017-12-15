import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by Jared on 12/15/2017.
 */
public class VendingMachineGuiTests {
    private  VendingMachineGui subject;

    @Mock
    VendingMachine vendingMachineMock;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        subject  = new VendingMachineGui(new VendingMachine(5, new ArrayList<>()));
    }

    @Test
    public void whenCreated_ThenTheVendingMachineLabelsAreSetCorrectly() {
        assertEquals("Penny", subject.pennyRadio.getText());
        assertEquals("Nickle", subject.nickleRadioButton.getText());
        assertEquals("Dime", subject.dimeRadioButton.getText());
        assertEquals("Quarter", subject.quarterRadioButton.getText());
        assertEquals("Dollar", subject.dollarRadioButton.getText());
    }

    @Test
    public void whenItemButtonsArePressThenItWillCallVendingMachinePushButton(){
        setupMock();

        subject.a1Button.doClick();
        verify(vendingMachineMock, times(1)).pressButton(1);
        subject.a2Button.doClick();
        verify(vendingMachineMock, times(1)).pressButton(2);
        subject.a3Button.doClick();
        verify(vendingMachineMock, times(1)).pressButton(3);
    }

    @Test
    public void whenTheRadioIsSelected_ThenTheCorrectCoinIsReturned(){
        subject.quarterRadioButton.setSelected(true);
        assertEquals(Coin.QUARTER, subject.getCoinForSelectedRadio());
        subject.dimeRadioButton.setSelected(true);
        assertEquals(Coin.DIME, subject.getCoinForSelectedRadio());
        subject.nickleRadioButton.setSelected(true);
        assertEquals(Coin.NICKLE, subject.getCoinForSelectedRadio());
        subject.pennyRadio.setSelected(true);
        assertEquals(Coin.PENNY, subject.getCoinForSelectedRadio());
        subject.dollarRadioButton.setSelected(true);
        assertEquals(Coin.DOLLAR, subject.getCoinForSelectedRadio());
    }

    @Test
    public void whenInsertCoinButtonIsPressed_ThenItWillCallInsertCoinWithTheSelectedCoin(){
        setupMock();
        subject.nickleRadioButton.setSelected(true);
        subject.insertCoinButton.doClick();
        verify(vendingMachineMock, times(1)).insert(Coin.NICKLE);
    }

    @Test
    public void whenCoinReturnButtonIsPress_ThenItWillTheCoinReturnMethodOnTheVendingMachineBrain(){
        setupMock();
        subject.nickleRadioButton.setSelected(true);
        subject.returnAllCoinsButton.doClick();
        verify(vendingMachineMock, times(1)).pushChangeReturnButton();
    }


    @Test
    public void whenEmptyCoinReturnButtonISPressed_ThenItWillCallTheEmptyCoinReturnMethodOnTheVendingMachineBrain(){
        setupMock();

        subject.nickleRadioButton.setSelected(true);
        subject.emptyCoinReturnButton.doClick();
        verify(vendingMachineMock.getCoinReturn(), times(1)).emptyCoinReturn();
    }

    private void setupMock() {
        HashMap<Integer, ItemSlot> inventory = new HashMap<>();
        when(vendingMachineMock.getInventory()).thenReturn(inventory);
        CoinReturn mockCoinReturn = mock(CoinReturn.class);
        when(vendingMachineMock.getCoinReturn()).thenReturn(mockCoinReturn);
        inventory.put(1, new ItemSlot(100, "cola", 5));
        inventory.put(2, new ItemSlot(50, "chips", 5));
        inventory.put(3, new ItemSlot(65, "candy", 5));
        subject = new VendingMachineGui(vendingMachineMock);

    }



}

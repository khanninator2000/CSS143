
/*
 * JUnit tests for Date, Money, and Bill classes
 * @author Lesley Kalmin
 *  CSS162
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyDateBillTest {
    //
    // Tests for the Money class.
    //

    @Test
    public void ConstructMoneyTest() {
        Money money1 = new Money(10);

        assertEquals(10, money1.getDollars());
    }

    @Test
    public void SetMoneyTest() {
        Money money1 = new Money();

        money1.setMoney(30, 50);
        assertEquals(30, money1.getDollars());
        assertEquals(50, money1.getCents());
    }

    @Test
    public void InvalidMoneyTest() {
        Money money = new Money(1, 156);
        assertEquals("$2.56", money.toString());
    }

    @Test
    public void ConstructMoneyCopyTest() {
        Money money1 = new Money();
        money1.setMoney(10, 40);

        Money money2 = new Money(money1);

        assertEquals(10, money1.getDollars());
        assertEquals(40, money2.getCents());
    }

    @Test
    public void addMoneyTests() {
        Money base = new Money(0, 0);

        base.add(1);
        assertEquals("$1.00", base.toString());

        base.add(0, 50);
        assertEquals("$1.50", base.toString());

        base.add(0, 150);
        assertEquals("$3.00", base.toString());

        base.add(new Money(1));
        assertEquals("$4.00", base.toString());
    }

    @Test
    public void PrintMoneyTest() {
        Money money1 = new Money(10);

        money1.setMoney(30, 50);
        assertEquals("$30.50", money1.toString());

    }

    //
    // Tests for the Date class
    //

    @Test
    public void CreateProperDate() {
        try {
            new Date(2014, 1, 1);
            new Date(2024, 12, 31);
            new Date(2020, 11, 7);
        } catch (IllegalArgumentException x) {
            assertTrue(false);
        }
    }

    @Test
    public void createErroneousDate() {
        try {
            new Date(2013, 12, 31);
            assertTrue(false);
        } catch (IllegalArgumentException x) {}

        try {
            new Date(2014, 0, 4);
            assertFalse(false);
        }catch (IllegalArgumentException x) {}
    }

    @Test
    public void dateComparator() {
        Date present = new Date(2018, 3, 31);
        Date after = new Date(2018, 4, 1);
        Date before = new Date(2018, 3, 30);

        assertTrue(present.isAfter(before));
        assertTrue(after.isAfter(present));
        assertFalse(before.isAfter(before));
    }

    @Test
    public void equalityTest() {
        Date present = new Date(2018, 3, 31);
        Date copy = new Date(present);

        assertTrue(present.equals(copy));
        assertTrue(copy.equals(present));
        assertFalse(present.equals(new Date(2018, 3, 30)));
    }

    //
    // Bill Tests
    //
}

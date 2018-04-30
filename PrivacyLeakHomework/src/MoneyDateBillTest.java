// Krish Kalai
// CSS 143 B
// PrivacyLeakHomework

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyDateBillTest {
  
    @Test
    public void constructor_test() {
        Money money1 = new Money(10);
        Money money2 = new Money(8, 250);
        Money money3 = new Money(money2);
        Money empty = new Money();
        
        assertEquals("$10.00", money1.toString());
        assertEquals("$10.50", money2.toString());
        assertEquals("$10.50", money3.toString());
        assertEquals("$0.00", empty.toString());
        
        try {
            Money money = new Money(-1, 0);
            assertTrue("Money was created", false);
        } catch (IllegalArgumentException ignored){}
    }
    
    @Test
    public void SetMoneyTest() {
        Money money1 = new Money(10);
        money1.setMoney(0, 5);
        assertEquals("$0.05", money1.toString());
    }
    
    @Test
    public void InvalidMoneyTest() {
        Money money = new Money(1, 156);
        assertEquals("$2.56", money.toString());
    }
    
    @Test
    public void ConstructMoneyCopyTest() {
        Money money1 = new Money(0, 0);
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
            new Date(1, 1, 2014);
            new Date(12, 31, 2024);
            new Date(11, 7, 2020);
        } catch (IllegalArgumentException x) {
            assertTrue(false);
        }
    }
    
    @Test
    public void createErroneousDate() {
        try {
            new Date(2013, 12, 31);
            assertTrue(false);
        } catch (IllegalArgumentException ignored) {
        }
        
        try {
            new Date(2014, 0, 4);
            assertFalse(false);
        } catch (IllegalArgumentException ignored) { }
    }
    
    @Test
    public void dateComparator() {
        Date present = new Date(3, 31, 2018);
        Date after = new Date(12, 4, 2018);
        Date before = new Date(1, 3, 2018);
        
        assertTrue(present.isAfter(before));
        assertTrue(after.isAfter(present));
        assertFalse(before.isAfter(before));
    }
    
    @Test
    public void equalityTest() {
        Date present = new Date(3, 31, 2018);
        Date copy = new Date(present);
        
        assertTrue(present.equals(copy));
        assertTrue(copy.equals(present));
        assertFalse(present.equals(new Date(3, 30, 2018)));
    }
    
    //
    // Bill Tests
    //
    
    @Test
    public void constructorTest() {
        Bill bill = new Bill(new Money(), new Date(10, 10, 2017), "CAKE");
        assertEquals("$0.00", bill.getAmount().toString());
        assertEquals("10/10/2017", bill.getDueDate().toString());
        assertEquals("CAKE", bill.getOriginator());
        Bill bill2 = new Bill(bill);
        assertEquals("$0.00", bill2.getAmount().toString());
        assertEquals("10/10/2017", bill2.getDueDate().toString());
        assertEquals("CAKE", bill2.getOriginator());
    }
    
    @Test
    public void setMoneyTests() {
        Bill bill = new Bill(new Money(), new Date(10, 10, 2017), "CAKE");
        assertEquals("$0.00", bill.getAmount().toString());
        bill.setAmount(new Money(100, 0));
        assertEquals("$100.00", bill.getAmount().toString());
        bill.setPaid(new Date(11, 11, 2018));
        bill.setAmount(new Money(200, 0));
        assertEquals("$100.00", bill.getAmount().toString());
    }
    
    @Test
    public void setDueDateTests() {
        Bill bill = new Bill(new Money(), new Date(10, 10, 2015), "CAKE");
        assertEquals("10/10/2015", bill.getDueDate().toString());
        bill.setDueDate(new Date(10, 10, 2014));
        assertEquals("10/10/2014", bill.getDueDate().toString());
    }
    
    @Test
    public void privacyLeakTest() {
        Bill b1; {
            Date b1_due_date = new Date(8, 7, 2018);
            Money b1_amount_due = new Money(32, 64);
            b1 = new Bill(b1_amount_due, b1_due_date, "Cake place");
        }
        Bill b2 = new Bill(b1);
        assertTrue(b1.equals(b2));
        b2.setDueDate(new Date(9, 12, 2021));
        assertFalse(b1.equals(b2));
    }
}

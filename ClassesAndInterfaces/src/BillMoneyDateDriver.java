/**
 HW3.java: Simple driver to test Money, Date, and Bill classes
 @author Rob Nash, borrowed from cfolsen
 */
public class BillMoneyDateDriver {
    /**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args) {
        //Construct some money
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        money1.setMoney(30,50);
        System.out.println(money2);

        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);

        //Construct some bills
        Money amount = new Money(20);
        Date dueDate = new Date(4, 30, 2017);
        Bill bill1 = new Bill(amount, dueDate, "The phone company");

        Bill bill2 = new Bill(bill1);
        bill2.setDueDate(new Date(5, 30, 2017));
        amount.setMoney(31, 99);
        dueDate.setDay(29);
        Bill bill3 = new Bill(amount, dueDate, "The record company");

        System.out.println("Bill objects output:");
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);

        System.out.println("Paying a bill.");
        System.out.println(bill1.setPaid(new Date(4, 31, 2017)));
        System.out.println(bill1.setPaid(new Date(4, 30, 2016)));
        System.out.println(bill1.setPaid(new Date(5, 31, 2017)));

        System.out.println(bill1);
    }
}

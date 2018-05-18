import java.util.function.Consumer;

public class Driver {
    public static void main(String[] args) {
        ExpenseAccount<Bill> account = new ExpenseAccount<>();
        account.add(new Bill(new Money(2499, 99), new Date(6, 2, 2019), "Housing Payment"));
        account.add(new Bill(new Money(27, 99), new Date(6, 8, 2019), "Class Fee"));
        account.add(new Bill(new Money(99, 27), new Date(4, 2, 2018), "Bulk cat food payment"));
        account.add(new Bill(new Money(200, 5), new Date(5, 16, 2018), "Bulk shoe payment"));
        account.add(new Bill(new Money(Integer.MAX_VALUE), new Date(1, 1, 2014), "Start of the world"));
        account.add(new Bill(new Money(0), new Date(12, 31, 2024), "End of the world"));
        
        for (Bill item:account) {
            System.out.println(item);
        }
        System.out.println();
        
        Consumer<? super Bill> payment = t -> t.setPaid(new Date(6, 1, 2019));
        account.forEach(payment);
        
        System.out.println("All Items");
        account.forEach(System.out::println);
    }
}

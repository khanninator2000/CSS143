public class Driver {
    public static void main(String[] args) {
        ExpenseAccount<Bill> account = new ExpenseAccount<>();
        account.add(new Bill(new Money(2499, 99), new Date(6, 2, 2019), "Housing Payment"));
        account.add(new Bill(new Money(27, 99), new Date(6, 8, 2019), "Class Fee"));
        account.add(new Bill(new Money(99, 27), new Date(4, 2, 2018), "Bulk cat food payment"));
    
        for (Bill item:account) {
            System.out.println(item);
        }
        System.out.println();
        
        account.forEach(t->t.setPaid(new Date(6, 1, 2019)));
    
        System.out.println("All Items");
        account.forEach(System.out::println);
        
        account.writeObject("cat.txt");
        
        ExpenseAccount<Bill> account2 = new ExpenseAccount<>();
        account2.readObject("cat.txt");
    
        System.out.println();
        for (Bill item:account2) {
            System.out.println(item);
        }
    }
}

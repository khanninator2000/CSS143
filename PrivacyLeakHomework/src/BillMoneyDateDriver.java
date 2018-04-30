// Krish Kalai
// CSS 143 B
// PrivacyLeakHomework

public class BillMoneyDateDriver {
    /**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args) {
        moneyTests();
        dateTests();
        billTests();
    }
    
    private static void moneyTests() {
        Money money1;
        Money money2;
        System.out.println("<init>");
        construction: {
            money1 = new Money(10);
            System.out.println(money1); //$10.00
    
            money2 = new Money(10, 240);
            System.out.println(money2); //$12.40
            
            try {
                System.out.println(new Money(0, -1));
            } catch (IllegalArgumentException ignored) {}
            try {
                System.out.println(new Money(-1, 0));
            } catch (IllegalArgumentException ignored) {}
            try {
                System.out.println(new Money(-1, -1));
            } catch (IllegalArgumentException ignored) {}
        }
    
        System.out.println("add");
        addition: {
            money1.add(10);
            System.out.println(money1); //$20.00
    
            money2.add(0, 760);
            System.out.println(money2); //$12.40 + $7.60 = $20.00
    
            money1.add(money2);
            System.out.println(money1); //$40.00
            System.out.println(money2); //$20.00
    
            Money test_case = new Money(1, 0);
            test_case.add(0, 33333333);
            System.out.println(test_case); //$333_333.33
            
            try {
                money1.add(0, -1);
                System.out.println(money1);
            } catch (IllegalArgumentException ignored) { }
            try {
                money1.add(-1, 0);
                System.out.println(money1);
            } catch (IllegalArgumentException ignored) { }
            try {
                money1.add(-1, -1);
                System.out.println(money1);
            } catch (IllegalArgumentException ignored) { }
        }
    
        System.out.println("setMoney");
        setting: {
            money1.setMoney(1, 100);
            System.out.println(money1);
    
            try {
                money1.setMoney(0, -1);
                System.out.println(money1);
            } catch (IllegalArgumentException ignored) { }
            try {
                money1.setMoney(-1, 0);
                System.out.println(money1);
            } catch (IllegalArgumentException ignored) { }
            try {
                money1.setMoney(-1, -1);
                System.out.println(money1);
            } catch (IllegalArgumentException ignored) { }
        }
        
        
    }
    
    private static void dateTests() {
        Date past;
        Date present;
        Date future;
    
        System.out.println("<init>");
        {
            past = new Date(1, 1, 2014);
            present = new Date(4, 23, 2018);
            future = new Date(12, 31, 2024);
    
            System.out.printf("%s\n%s\n%s\n",past, present, future);
            
            try {
                new Date(0, 1, 2014);
            }catch (IllegalArgumentException ignored) { }
    
            try {
                new Date(1, 0, 2014);
            }catch (IllegalArgumentException ignored) { }
    
            try {
                new Date(0, 1, 2000);
            }catch (IllegalArgumentException ignored) { }
        }
    
        System.out.println("\nisAfter");
        {
            Date[] dates = {past, present, future};
            for (Date d : dates) {
                for (Date e: dates) {
                    System.out.print(d.isAfter(e) + " ");
                }
                System.out.println();
            }
        }
    
        System.out.println("Equality");
        System.out.println();
        {
            Date[] dates = {past, present, future};
            for (Date d : dates) {
                for (Date e: dates) {
                    System.out.print(d.equals(e) + " ");
                }
                System.out.println();
            }
        }
    }
    
    private static void billTests() {
        Bill b1; {
            Date b1_due_date = new Date(8, 7, 2018);
            Money b1_amount_due = new Money(32, 64);
            b1 = new Bill(b1_amount_due, b1_due_date, "Cake place");
        }
        Bill b2 = new Bill(b1);
        b2.setOriginator("Cat store");
        
        System.out.println(b1);
        b1.getAmount().setMoney(0, 0);
        b1.getDueDate().setYear(2024);
        System.out.println(b1);
    
        System.out.println(b1.setPaid(new Date(8, 8, 2018)) ? "Success" : "Failure");
        System.out.println(b1);
    
        System.out.println(b1.setPaid(new Date(3, 3, 2017)) ? "Success" : "Failure");
        System.out.println(b1);
    
        System.out.println(b1.setPaid(new Date(3, 2, 2017)) ? "Success" : "Failure");
        System.out.println(b1);
        
        System.out.println(b1);
        
        System.out.println(b2);
    }
}

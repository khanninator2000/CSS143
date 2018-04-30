public class PermanentHire extends SalariedWorker {
    public PermanentHire() {
    }

    public PermanentHire(String name, int social) {
        super(name, social);
    }

    public PermanentHire(String name, int social, double pay) {
        super(name, social, pay);
    }

    @Override
    public double calculateWeeklyPay() {
        return super.calculateWeeklyPay()+10.01;
    }
}

/*
 * What methods are polymorphic in the Employee hierarchy?
 * calculateWeeklyPay() and constructors.
 *
 * How could we build a method like getRandShape() above but for use with Employees?
 * Employee return_value;
 * switch((int)(Math.random() * 5)) {
 * case 0:
 *     return_value = new SalariedWorker();
 *     break;
 * case 1:
 *     return_value = new Accountant();
 *     break;
 * case 2:
 *     return_value = new PermanentHire();
 *     break;
 * case 3:
 *     return_value = new HourlyWorker();
 *     break;
 * case 4:
 *     return_value = new Consultant();
 *     break;
 * }
 *
 * If we built a getRandomEmployee() method that returns various Employee subclass objects; write a few lines of code that would demonstrate late binding
 * List<Employee> people = new ArrayList<>();
 *      for (int i = 0; i < 10; i++) {
 *          people.add(getRandomEmployee("sfsdfsdf", 2434242, 200.22));
 *      }
 * people.stream().mapToDouble(Employee::calculateWeeklyPay).forEach(System.out::println);
 */
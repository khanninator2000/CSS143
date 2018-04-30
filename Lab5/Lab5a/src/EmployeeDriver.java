import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Driver
 * Lab 
 * 
 * A simple driver to exercise the Employee hierarchy 
 */

public class EmployeeDriver {
	public static void main(String[] args) {
		Accountant emp1 = new Accountant( "Rick", 123456789);
		//this next employee makes a bit more than Rick
		Accountant emp2 = new Accountant( "Tim", 55555555,10000);
		//and lets make an hourly worker
		HourlyWorker emp3 = new HourlyWorker( "Jim", 11111111);
		//then a salaried worker
		SalariedWorker emp4 = new SalariedWorker( "Jane", 222222222, 5000);
		HourlyWorker emp5 = new HourlyWorker( "Joe", 11111111,20);
		
		//todo: Build some PermanentHire and Consultant objects here
        PermanentHire emp6 = new PermanentHire("Bob", 1 << 16, 100);
        Consultant emp7 = new Consultant("0", 1 << 15, 984732);
		//and add them to the ArrayList below
		
		//and build a set of workers, all of which are employees
		ArrayList<Employee> myEmployees = new ArrayList<>();
		
		myEmployees.add(emp1);
		myEmployees.add(emp2);
		myEmployees.add(emp3);
		myEmployees.add(emp4);
		myEmployees.add(emp5);
		
		//todo: add a sixth and seventh employee to this list that you create
        myEmployees.add(emp6);
        myEmployees.add(emp7);
		
		//this code doesn't need to change, even if you add 10 new employee classes and 
		//add 102 new employees - this is an example of generic code that can be written 
		//when inheritance hierarchies are in use
		for( int i = 0; i < myEmployees.size(); i++) {
			Employee current = myEmployees.get(i);
			System.out.println( current.getName() + " makes " + current.calculateWeeklyPay() + " per week.");
		}
        
        List<Employee> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            people.add(getRandomEmployee("sfsdfsdf", 2434242, 200.22));
        }
        people.stream().mapToDouble(Employee::calculateWeeklyPay).forEach(System.out::println);
	}
	
	public static Employee getRandomEmployee(String name, int social, double pay) {
        Employee return_value;
        switch((int)(Math.random() * 5)) {
            case 0:
                return_value = new SalariedWorker(name, social, pay);
                break;
            case 1:
                return_value = new Accountant(name, social, pay);
                break;
            case 2:
                return_value = new PermanentHire(name, social, pay);
                break;
            case 3:
                return_value = new HourlyWorker(name, social, pay);
                break;
            case 4:
                return_value = new Consultant(name, social, pay);
                break;
            default:
                return_value = null;
                
        }
        return return_value;
    }
}

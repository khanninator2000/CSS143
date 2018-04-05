/*
 *  Incomplete Driver for ArrayList(ObjectList), Stack and Queue
 * 
 * 
 */

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
        System.out.println("Stack");
		stackTests();
        System.out.println("Queue");
		queueTests();
        System.out.println("Arrays");
		arrayListTests();
	}

	private static void arrayListTests() {
		ArrayList a = new ArrayList();

		a.insert('B', 0);
		a.insert('a',0);
		a.insert('t',1);

		System.out.println(a.toString());

		while(!a.isEmpty()) {
			System.out.println(a.remove(0));
		}

		a.insert("<><", 0);
		a.insert("()(", 1);
		a.insert("{}{)", 0);
        System.out.println(a + " " + a.size());
        try {
            a.insert("[]]", 4);
        } catch (IndexOutOfBoundsException x) {
            System.out.println("That's not a fish");
        }

        while (true) {
            try {
                a.remove(0);
            }catch (IndexOutOfBoundsException x) {
                break;
            }
        }
        System.out.println(a);
	}

	private static void queueTests() {
		Queue a = new Queue();

		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');

		System.out.println(a.toString());

        Queue b = new Queue();

        b.enqueue('B');
        b.enqueue('a');
        b.enqueue('t');

        System.out.println(a.equals(b));

		while(!a.isEmpty()) {
			System.out.println(a.dequeue());
		}

        System.out.println(a.equals(b));
	}

	private static void stackTests() {
		Stack a = new Stack();
		
		a.push('B');
		a.push('a');
		a.push('t');
		
		System.out.println(a.toString());
		
		while(!a.isEmpty()) {
			System.out.println(a.pop());
		}
	}
	

}

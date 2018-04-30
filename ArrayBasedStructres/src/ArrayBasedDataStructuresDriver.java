// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

public class ArrayBasedDataStructuresDriver {
	public static void main(String[] args) {
        System.out.println("Stack");
		stackTests();
        System.out.println("Queue");
		queueTests();
        System.out.println("ArrayList");
		arrayListTests();
	}

	private static void arrayListTests() {
		ArrayList<Integer> array = new ArrayList<>();

		// Tests for basic insertion, size and empty checking.
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        array.insert(0,0);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        array.insert(1,0);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        array.insert(2,2);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        array.insert(3,2);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        
        // Tests of silent failing
        array.remove(array.size());
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        
        // Tests for removal
        array.remove(array.size()-1);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));

        // Tests removal after insertion
        array.insert(array.size(), array.size()-1);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));

        //Tests removal of index 0 and middle
        array.remove(0);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        array.remove(1);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        array.remove(1);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        array.remove(0);
        System.out.println(array + " " + array.size() + " " + (array.isEmpty() ? 1 : 0));
        
        //Tests insertion and resizing
        for (int i = 0; i < 10; array.insert(i, i), i++);
        System.out.println(array);
        
        //Tests get method.
        for (int i = 0; i < 10; System.out.print(array.get(i) + " "), i++);
        System.out.println();
        
        //Tests indexOf
        for (int i = -1; i < 12; System.out.print(array.indexOf(i) + " "), i++);
        System.out.println();
        
        //Tests removal of the last element and silent failing of remove, and isEmpty.
        for (int i = array.size(); !array.isEmpty(); array.remove(i), i--);
        System.out.println(array);
        
        //Tests for equality.
        ArrayList<Integer> a2 = new ArrayList<>();
        for (int i = 0; i < 10; array.insert(i, 0), a2.insert(i, 0), i++);
        System.out.println(array);
        System.out.println(a2);
        System.out.println(array.equals(a2) ? "equal" : "not equal");
        a2.remove(2);
        System.out.println(array.equals(a2) ? "equal" : "not equal");
        a2.insert(3, 2);
        System.out.println(array.equals(a2) ? "equal" : "not equal");
    }

	private static void stackTests() {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack + " " + stack.size());
        stack.push(0);
        System.out.println(stack + " " + stack.size());
        stack.push(1);
        System.out.println(stack + " " + stack.size());
        stack.push(2);
        System.out.println(stack + " " + stack.size());
        stack.push(3);
        System.out.println(stack + " " + stack.size());

        stack.pop();
        System.out.println(stack + " " + stack.size());

        stack.push(4);
        System.out.println(stack + " " + stack.size());

        System.out.println(stack.pop());
        System.out.println(stack + " " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack + " " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack + " " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack + " " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack + " " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack + " " + stack.size());
        
        for (int i = 0; i < 10; stack.push(i), i++);
        System.out.println(stack);
        
        for (; stack.isEmpty(); System.out.print(stack.pop() + " "));
        System.out.println(stack);
        
    }

	private static void queueTests() {
		Queue<Integer> queue = new Queue<>(); // [null, null, null, null]
        
        //Test enqueue size, and toString
        for (int i = 0; i < 10; queue.enqueue(i), System.out.println(queue + " " + queue.size()), i++);
        
        //Test isEmpty, dequeue, size, and toString
        for (; !queue.isEmpty(); System.out.println(queue.dequeue()), System.out.println(queue + " " + queue.size()));
        
        Queue<Integer> other = new Queue<>();
        
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            other.enqueue(i);
        }
        System.out.println(queue.equals(other));
        other.dequeue();
        System.out.println(queue.equals(other));
        
        //Curious
        {
            Stack<Integer> stack = new Stack<>();
            System.out.println(queue.equals(stack));
        }
	}

}

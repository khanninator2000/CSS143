// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

public class ArrayBasedDataStructuresDriver {
	public static void main(String[] args) {
	    String s = "Stack";
        System.out.println(s.charAt(0));
        System.out.println('S' == 's');

//        System.out.println("Stack");
//		stackTests();
//        System.out.println("Queue");
//		queueTests();
//        System.out.println("Arrays");
//		arrayListTests();
	}

	private static void arrayListTests() {
		ArrayList<Integer> array = new ArrayList<>();

        System.out.println(array + " " + array.size());
        array.insert(0,0);
        System.out.println(array + " " + array.size());
        array.insert(1,0);
        System.out.println(array + " " + array.size());
        array.insert(2,2);
        System.out.println(array + " " + array.size());
        array.insert(3,2);
        System.out.println(array + " " + array.size());

        array.remove(array.size()-1);
        System.out.println(array + " " + array.size());

        array.insert(array.size(), array.size()-1);
        System.out.println(array + " " + array.size());

        array.remove(0);
        System.out.println(array + " " + array.size());
        array.remove(1);
        System.out.println(array + " " + array.size());
        array.remove(0);
        System.out.println(array + " " + array.size());
        array.remove(0);
        System.out.println(array + " " + array.size());
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
    }

	private static void queueTests() {
		Queue<Integer> arrayQueue = new Queue<>(); // [null, null, null, null]
        System.out.println(arrayQueue + " " + arrayQueue.size());
		arrayQueue.enqueue(0);
		System.out.println(arrayQueue + " " + arrayQueue.size());
        arrayQueue.enqueue(1);
        System.out.println(arrayQueue + " " + arrayQueue.size());
        arrayQueue.enqueue(2);
        System.out.println(arrayQueue + " " + arrayQueue.size());
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue + " " + arrayQueue.size());
        arrayQueue.enqueue(4);
        System.out.println(arrayQueue + " " + arrayQueue.size());
//        arrayQueue.enqueue(5);
//        System.out.println(arrayQueue + " " + arrayQueue.size());

        arrayQueue.dequeue();
        System.out.println(arrayQueue + " " + arrayQueue.size());

        arrayQueue.enqueue(5);
        System.out.println(arrayQueue + " " + arrayQueue.size());

        arrayQueue.dequeue();
        System.out.println(arrayQueue + " " + arrayQueue.size());
        arrayQueue.dequeue();
        System.out.println(arrayQueue + " " + arrayQueue.size());
        arrayQueue.dequeue();
        System.out.println(arrayQueue + " " + arrayQueue.size());
        arrayQueue.dequeue();
        System.out.println(arrayQueue + " " + arrayQueue.size());
        arrayQueue.dequeue();
        System.out.println(arrayQueue + " " + arrayQueue.size());
        arrayQueue.dequeue();
        System.out.println(arrayQueue + " " + arrayQueue.size());
	}

}

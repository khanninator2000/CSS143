// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
//        System.out.println("LinkedListStack");
//		stackTests();
//		arrayStackTests();
//        System.out.println("LinkedListQueue");
		arrayQueueTests();
//		queueTests();
//        System.out.println("Arrays");
//		arrayListTests();
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
		a.insert("{}{", 0);
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
        LinkedListQueue queue= new LinkedListQueue();
        System.out.println(queue + " " + queue.size());
        queue.enqueue(0);
        System.out.println(queue + " " + queue.size());
        queue.enqueue(1);
        System.out.println(queue + " " + queue.size());
        queue.enqueue(2);
        System.out.println(queue + " " + queue.size());
        queue.enqueue(3);
        System.out.println(queue + " " + queue.size());

        queue.dequeue();
        System.out.println(queue + " " + queue.size());

        queue.enqueue(4);
        System.out.println(queue + " " + queue.size());

        queue.dequeue();
        System.out.println(queue + " " + queue.size());
        queue.dequeue();
        System.out.println(queue + " " + queue.size());
        queue.dequeue();
        System.out.println(queue + " " + queue.size());
        queue.dequeue();
        System.out.println(queue + " " + queue.size());
	}

	private static void stackTests() {
        LinkedListStack stack = new LinkedListStack();
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

        stack.pop();
        System.out.println(stack + " " + stack.size());
        stack.pop();
        System.out.println(stack + " " + stack.size());
        stack.pop();
        System.out.println(stack + " " + stack.size());
        stack.pop();
        System.out.println(stack + " " + stack.size());
	}

	private static void arrayStackTests() {
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

        stack.pop();
        System.out.println(stack + " " + stack.size());
        stack.pop();
        System.out.println(stack + " " + stack.size());
        stack.pop();
        System.out.println(stack + " " + stack.size());
        stack.pop();
        System.out.println(stack + " " + stack.size());
    }

	private static void arrayQueueTests() {
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

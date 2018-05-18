//import java.util.LinkedList;
//import java.util.Queue;

/* CSSSKL 162
 *
 * UsingStacksSuitorsLab
 *
 * This class is mostly a driver for playing with Strings as palindromes,
 * both iteratively and recursively.  The UsingStacksSuitorsLab class itself is
 * a runnable object, so it can be passed to a thread in our Queue demo
 *
 *
 */

public class UsingStacksSuitorsLab implements Runnable {
    private static int threadCount = 0;
    private String name;
    
    public UsingStacksSuitorsLab() {
        name = "#" + threadCount++ + "Thread";
    }
    
    public static void main(String[] args) {
        String s1 = "food";            //not a palindrome
        String s2 = "racecar";      //a palindrome
        
        System.out.println("String1 is \"" + s1 + "\"");
        System.out.println("String2 is \"" + s2 + "\"");
        
        System.out.println(s1 + " reversed is: ");
        printReverse(s1);
        System.out.println(s2 + " reversed is: ");
        printReverse(s2);
        
        recPrintReverse(s1);
        System.out.println();
        recPrintReverse(s2);
        System.out.println();
        
        System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
        System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));
        
        System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
        System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));
        
        System.out.println("Did we build a Queue of Threads and start them? " + buildThreadQueue());
        
        int n = 6;
        System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
        System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n, true));
        
        n = 10;
        System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
        System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n, true));
    }
    
    public static void printReverse(String target) {
        System.out.println(new StringBuilder(target).reverse().toString());
    }
    
    public static void recPrintReverse(String target) {
        if (target.length() == 0) {
            //System.out.println();
            return;
        }
        recPrintReverse(target.substring(1));
        System.out.print(target.charAt(0));
    }
    
    public static boolean isPalindrome(String input) {
        Stack<Character> letters = new Stack<>();
        int i = 0;
        for (; i < input.length() / 2; i++) {
            letters.push(input.charAt(i));
        }
        
        if (input.length() % 2 == 1) {
            i++;
        }
        
        for (; letters.size() > 0; i++) {
            char current = letters.pop();
            if (current != input.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isPalindromeRec(String sentence) {
        if (sentence.length() == 1 || sentence.length() == 0) {
            return true;
        }
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }
        return isPalindromeRec(sentence.substring(1, sentence.length() - 1));
    }
    
    public static int findPlaceToStand(int numSuitors) {
        Queue<Integer> suitors = new Queue<>();
        for (int i = 0; i < numSuitors; i++) {
            suitors.enqueue(i);
        }
        
        for (int count = 0; suitors.size() > 1; count++) {
            if (count != 0 && count % 3 == 0) {
                suitors.dequeue();
            } else {
                suitors.enqueue(suitors.dequeue());
            }
        }
        return suitors.dequeue();
    }
    
    public static int findPlaceToStand(int numSuitors, boolean dummy) {
        Stack<Integer> suitors = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < numSuitors; i++) {
            suitors.push(i);
        }
        
        for (int count = 0; suitors.size() + temp.size() > 1; count++) {
            if (count != 0 && count % 3 == 0) {
                suitors.pop();
            } else {
                temp.push(suitors.pop());
            }
            if (suitors.size() == 0) {
                for (int i = 0; i < temp.size(); i++) {
                    suitors.push(temp.pop());
                }
            }
        }
        return suitors.pop();
    }
    
    
    public static boolean buildThreadQueue() {    //returns true upon success
        //Queue<Thread> q = new LinkedList<Thread>(); //comment this out and use your own Queue
        Queue<Thread> q = new Queue<>();
        
        //when our program starts up, it might create multiple threads to use
        q.enqueue(new Thread(new UsingStacksSuitorsLab()));
        
        
        System.out.println("Initial Thread order:");
        System.out.println(q.toString());
        
        //We need to iterate over our pool of threads and call start() on each one
        //Make a loop that dequeues a thread, calls start on it, and enqueues it again
        //for(?) {
        
        Thread current = q.dequeue();
        current.start();
        q.enqueue(current);
		/*	current = get a thread
			current.start();
			put the thread back
		}*/
        System.out.println("Thread order after start()ing:");
        System.out.println(q.toString());
        
        return true;  //on successful start
    }
    
    
    /*
     * No need to edit anything below here,
     * unless you'd like to change the
     * behaviour of each thread in the thread pool above
     */
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + ": " + i + "th iteration");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                //do nothing here
            }
        }
    }
}

/*
 * Should you use a List, a Stack, or a Queue to solve this?
 * - A list would be the easiest option. Queue comes next, because you need one instance
 *   and Stack is the most difficult.
 * Does the selection of structure affect your results?
 * - Yes. A List or Queue maintains the order of the elements. The Stack reverses it.
 */
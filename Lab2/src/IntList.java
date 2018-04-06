import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/** for Class Design - IntList  */

public class IntList {   //or IntList, caps at 100 elements with no bullet-proofing or bounds checks, etc.
 	private int[] data = new int[100];
	private int numElements = 0;

 	public void add(int letter) {
 		data[numElements++] = letter;
 	}

 	public String toString() {
 		StringBuilder retVal = new StringBuilder();
 		for(int i = 0; i < numElements; retVal.append(data[i]).append(i < numElements - 1 ? ", " : ""), i++);
 		return retVal.toString();
 	}

 	public int sum() {
 	    int sum = 0;
        for (int i = 0; i < numElements; sum += data[i], i++);
 	    return sum;
    }

    public int indexOf(int target) {
 	    int i;
        for (i = 0; i < numElements && data[i] != target; i++);
 	    return i == numElements ? -1 : i;
    }

    public void save() throws FileNotFoundException {
 	    new PrintWriter(new FileOutputStream("array.txt"), true).println(this);
    }

	public static void main(String[] args) throws FileNotFoundException {
		IntList a = new IntList();
		a.add(95);
		a.add(100);
		a.add(58);
		System.out.println(a.toString());
		System.out.println(a.sum() );
		System.out.println(a.indexOf(100));
//		uncomment these to work on next
		System.out.println(a.indexOf(20));
		a.save();
	}
}

import java.io.*;

public class TestFinally{
    public static void main(String[] args){
        FileInputStream in1 = null;
        FileInputStream in2 = null;

        //Open an existing file trycatch.txt
        File inputFile1 = new File("trycatch.txt");
        //Open a non-existent file nosuchfile.abc
        File inputFile2 = new File("nosuchfile.abc");

		//1. Add the try statement here
        try {
            //Get file handlers in Byte Stream format
            in1 = new FileInputStream(inputFile1);
            in2 = new FileInputStream(inputFile2);
    
            int c1;
    
            //Try to read 'nosuchfile.abc' till the end of File
            while ((c1 = in2.read()) != -1) {
                System.out.println("Read from nosuchfile.abc");
            }
            
        } catch (java.io.IOException x) {
            //2. Close the try block here
            //3. Add a catch block containing meaningful error messages.
            System.err.println("The exception is: " + x);
        } finally {
            //4. Add the finally block here.  See instructions in the handout.
            try {
                //Close the files
                in1.close();
                System.out.println("Closing file 'trycatch.txt' inside finally block.");
                in2.close();
                System.out.println("Closing file 'nosuchfile.abc' inside finally block.");
            } catch (java.io.IOException | NullPointerException x) {
                System.err.println(x.getMessage() == null ? "Caught java.lang.NullPointerException" : x.getMessage());
            }
        }
        
        //5. Close the finally block here.
    }
}



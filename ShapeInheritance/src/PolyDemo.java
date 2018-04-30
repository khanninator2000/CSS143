import java.util.*;
import javax.swing.*;
import java.awt.*;

import static java.lang.Math.PI;
import static java.lang.Math.random;

/*
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 * 
 * Author: Rob Nash
 */


class PolyDemo extends JFrame {
    
    
    public PolyDemo() {
        setSize(300, 300);
        getContentPane().add(new PolyDemoPanel());
        //just some windowing stuff that must happen for all Frames
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    public static void main(String args[]) {
        PolyDemo myApp = new PolyDemo();
    }
    
    
    //this is our first "inner" or internal class
    //the purpose of this class is solely to support the JFrame class above, and I don't want it reused in arbitrary contexts, so by nesting this class here
    //I can indicate the intent a bit more clearly that this class "goes with" the class above it
    //In general, each class is a separate entity that should be contained in a separate file
    public class PolyDemoPanel extends JPanel {
        final int num = 20;
        Shape[] myShapes = new Shape[num];
        
        public PolyDemoPanel() {
            setSize(PolyDemo.this.getWidth(), PolyDemo.this.getHeight());
            for (int i = 0; i < num; i++) {
                myShapes[i] = getRandShape();
            }
        }
        
        public void paint(Graphics g) {
            super.paint(g);
            
            for (int i = 0; i < myShapes.length; i++) {
                myShapes[i].draw(g);
            }
        }
        
        public int getRandInt(int bound) {
            return (int)(random() * bound);
        }
        
        public Shape getRandShape() {
            Shape retVal = null;
            final int x = getRandInt(getSize().width);
            final int y = getRandInt(getSize().height);
            
            int size = (int)(Math.random() * 250);
            /********************************
             * Polymorphic extensibility demo
             *******************************/
            switch ((int)(random() * 4)) {
                case 0:
                    //retVal = new Square(x, y, getRandInt(300), getRandInt(0xFFFFFF));
                    retVal = new PokeBall(x, y, size);
                    break;
                case 1:
//                    retVal = new Circle(x, y, (Math.random() * 91) + 10);
                    retVal = new PokeBall(x, y, size);
                    break;
                case 2:
//                    retVal = new Polygon((int) (random() * 200), (int) (random() * 200), (int)(random() * 100), (int)(random() * 0xFF_FF_FF), (int)(random() * 10) + 3);
                    retVal = new PokeBall(x, y, size);
                    break;
                case 3:
//                    retVal = new SemiCircle(x, y, (Math.random() * 91) + 10, Math.random() * 2 * PI);
                    retVal = new PokeBall(x, y, size);
                    break;
            }
            
            return retVal;
        }
    }
    
}












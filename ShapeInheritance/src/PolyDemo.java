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
        new PolyDemo();
    }
    
    
    //this is our first "inner" or internal class
    //the purpose of this class is solely to support the JFrame class above, and I don't want it reused in arbitrary contexts, so by nesting this class here
    //I can indicate the intent a bit more clearly that this class "goes with" the class above it
    //In general, each class is a separate entity that should be contained in a separate file
    public class PolyDemoPanel extends JPanel {
        Shape[] myShapes = new Shape[20];
        
        public PolyDemoPanel() {
            setBackground(new Color(0xAA_AA_AA));
            setSize(PolyDemo.this.getWidth(), PolyDemo.this.getHeight());
            for (int i = 0; i < myShapes.length; i++) {
                myShapes[i] = getRandShape();
            }
        }
        
        public void paint(Graphics g) {
            super.paint(g);
            
            for (int i = 0; i < myShapes.length; i++) {
                myShapes[i].draw(g);
            }
        }
        
        public int getRandInt(int bound, int increment) {
            return (int)(random() * bound) + increment;
        }
        
        public Shape getRandShape() {
            Shape retVal = null;
            final int x = getRandInt(getSize().width, 0);
            final int y = getRandInt(getSize().height, 0);
            /********************************
             * Polymorphic extensibility demo
             *******************************/
            switch ((int)(random() * 4)) {
                case 0:
                    retVal = new Square(x, y, getRandInt(300, 0),
                                              getRandInt(0xFFFFFF, 0));
                    break;
                case 1:
                    retVal = new Cylinder(x, y, 50, 50, Color.green);
                    break;
                case 2:
                    retVal = new Polygon((int) (random() * 200), (int) (random() * 200), (int)(random() * 100),
                                         (int)(random() * 0xFF_FF_FF), (int)(random() * 10) + 3);
                    break;
                case 3:
                    retVal = new PokeBall(x, y, (int)(Math.random() * 91) + 10);
                    break;
            }
            
            return retVal;
        }
    }
    
}












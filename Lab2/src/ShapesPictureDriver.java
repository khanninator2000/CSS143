import javax.swing.*;
import java.util.Random;

/**
 * Driver for CSS 162 Lab
 * 
 * uncomment sections to test Square, Circle, and Picture
 * 
 * @author Rob Nash
 */


public class ShapesPictureDriver {
	//precondition: assumes {Square, Circle, Picture} all exist in the same working directory
	//postcondition: 2 Squares, 2 Circles, and 1 Picture are constructed and manipulated, then reclaimed once main exits
	public static void main(String[] args) {
		// Uncomment for Square Tests
		Square firstSquare = new Square();
		Square secondSquare = new Square(10,20);
		
		firstSquare.setX(3);
		firstSquare.setY(4);
		
		System.out.println( "Drawing the first square : " + firstSquare.toString());
		
		firstSquare.draw();
		
		secondSquare.setLength(30);
		
		System.out.println( "Drawing the next square with area : " + secondSquare.getArea());
		
		secondSquare.draw();
		
		
		
		// Uncomment for Circle Tests
		//now for some circles
		Circle firstCircle = new Circle();
		Circle secondCircle = new Circle(5,5);
		
		firstCircle.setX(1);
		firstCircle.setY(5);
		firstCircle.setRadius(3);
		
		System.out.println( "Drawing the first circle : " + firstCircle.toString());
		
		firstCircle.draw();
		
		secondCircle.setX(2);
		secondCircle.setY(10);
		secondCircle.setRadius(6);
		
		System.out.println( "Drawing the second circle with area " + secondCircle.getArea());
		
		secondCircle.draw();
		
		// Uncomment for Picture Tests
		//now, lets see the bigger picture
		Picture picture = new Picture();
		
		picture.addSquare( firstSquare );
		picture.addSquare( secondSquare );
		picture.addCircle( firstCircle );
		picture.addCircle( secondCircle );
		
		System.out.println( "Drawing a Picture with Circles and Squares:\n" );
		
		System.out.println(picture.toString());

		ObjectList obj = new ObjectList();
		obj.add(new Square(10, 30, 50));
		obj.add(new Circle(2, 30, Math.PI));
		obj.add(new Square(10, 30, 50));

		System.out.println(obj);

		painting();
	}

	public static void painting() {
	    PicturePanel panel = new PicturePanel();
	    Random random = new Random();
        for (int i = 0; i < 10; i++) {
            panel.add(new Circle(random.nextInt(500), random.nextInt(500), random.nextInt(1000) + 10));
            panel.add(new Square(random.nextInt(500), random.nextInt(500), random.nextInt(1000) + 10));
        }

		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

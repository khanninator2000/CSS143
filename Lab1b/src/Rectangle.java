//Another shape class.  Now that we've seen Circles and Squares, what if our simulation required
//even more shapes such as this Rectangle?  As our software grows in (1) size, (2) complexity, and
//(3) the number of classes involved, we'll need to plan flexibly and generically or our software
//will require major overhauls with just the addition of new shapes (like Rectangle below)

//Once you're comfortable with the Rectangle class, see if you could add this shape to our first Lab
//and look for new rectangle output once you're done.
public class Rectangle extends Shape {

	//Here are 4 instance variables (will be pushed up to Shape)
	private int x,y,x2,y2;
	
	public Rectangle() {  //first, notice there are no static methods in this class...
		//this constructor is called if we don't pass any data when we build a rectangle
	}

	//The parameters are local variable
	public Rectangle(int newX, int newY) {
		//This constructor allows you to build a rectangle with only one coordinate pair
		x = newX;
		y = newY;
	}
	
	public Rectangle(int newX, int newY, int newX2, int newY2) {
		//with this constructor, you can fully initialize a Rectangle
		x = newX;
		y = newY;
		x2 = newX2;
		y2 = newY2;   //new Y2K!
	}
	
	public void setXY(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public String getXY() {
		return " " + x + " " + y;
	}
	
	
	public void printMemoryAddress() {
		System.out.println( "Inside the object, I use \'this\' to gain access to memory location:" + this.toString());
	}
	
	
	//Equals VS isEquals  (note you could have named the functions identically - overloading)
	//static method means you can call this without a target object reference!
	//do static methods then have any concept of this?
	public static boolean isEquals(Rectangle one, Rectangle two) {
		return one.x == two.x && one.y == two.y && one.x2 == two.x2 && one.y2 == two.y2;
	}

	//The inherited equals compares to see if the objects occupy the same address - ie, literally the same object in memory
	//We'd like to replace (or override) this function so it does a better job of comparing Rectangles
	@Override
	public boolean equals(Object other) {
		if (other instanceof Rectangle) {
			Rectangle theOther = (Rectangle) other;
			return this.x == theOther.x && this.y == theOther.y && this.x2 == theOther.x2 && this.y2 == theOther.y2;
		}
		
		return false;
	}
	
	public double getArea() {
		return x2-x * y2-y;
	}
	
	public String draw() {
		return "[==]";  //a, uh, rectangle?
	}
	
}
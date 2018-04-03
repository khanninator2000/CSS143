public class Car {
    private String make;
    private String model;
    private int odometer;

    public Car() {
        this.make = "Fast";
        this.model = "Forward";
        this.odometer = 1337;
    }

    public Car(String make) {
        this.make = make;
        this.model = "<><";
        this.odometer = 0;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.odometer = 0;
    }

    //Returns the same memory address as Object::toString
    public String memory_address() {
        return "this = " + this;
    }

    @Override
    public String toString() {
        return make + " " + model + " " + odometer;
    }

    public static void main(String[] $) {
        Car c1 = new Car("Cat");
        System.out.println(c1);
        System.out.println(c1.memory_address());
        Car c2 = new Car("Dog", "Bun");
        System.out.println(c2);
        System.out.println(c2.memory_address());

        //Error: odometer has private access in Car
        //System.out.println(c1.odometer);
    }
}

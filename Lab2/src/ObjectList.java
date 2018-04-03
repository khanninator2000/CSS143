public class ObjectList {
    private int numElements = 0;
    private Object[] data = new Object[100];

    public void add(Object item) {
        data[numElements++] = item;
    }

    public String toString() {
        StringBuilder retVal = new StringBuilder();
        for(int i = 0; i < numElements; retVal.append(data[i]).append(i < numElements - 1 ? ", " : ""), i++);
        return retVal.toString();
    }
}

/*
 * QA:
 * (1) Why did we do so much copying-and-pasting in our software above?
 * Multiple classes had similar data, and it would be more inefficient to rewrite by scratch.
 *
 * (1a) How can this approach be problematic?
 * If a change occurs to one class, it needs to be applied to the other classes as well, which may lead to errors.
 *
 * (2) Are there obvious improvements that could be made herewith respect the software design for Squares and Circles?
 * Yes, applying inheritance/polymorphism and having Square and Circle inherit from a superclass such as Shape.
 *
 * (3) What programming constructs were you familiar with, and which did you need to look up?
 * I was familiar with everything except the term "programming construct".
 *
 * (4) How would this complicate the task of adding a new Shape (say, a Triangle) to our ObjectList class?
 * Another array would be needed for Triangle.
 */
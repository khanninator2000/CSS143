@SuppressWarnings("all")
public class BillMoneyDateDriver {

    public static void main(String[] args) {
        Bill orig = new Bill(new Money(99, 99), new Date(5, 10, 2020), "Your face");
        Bill clone = orig.clone();
        Bill impl_clone = orig;

        System.out.println(clone);

        System.out.println(orig.equals(clone));
        System.out.println(orig.equals(impl_clone));
        System.out.println(clone.equals(impl_clone));
        System.out.println(orig == clone);
        System.out.println(orig == impl_clone);
        System.out.println(clone == impl_clone);
    }
}

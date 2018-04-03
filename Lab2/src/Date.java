public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void set_date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void print() {
        System.out.println((this.month < 10 ? ("0" + this.month) : this.month) + "/" +
                (this.day < 10 ? ("0" + this.day) : this.day) + "/" +
                this.year);
    }

    public static void main(String[] $) {
        Date test = new Date(2014, 3, 5);
        test.print();
    }
}

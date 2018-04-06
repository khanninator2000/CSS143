public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
        this(1, 1, 0);
    }

    public Date(int month, int day, int year) {
        setDate(month, day, year);
    }

    public Date(Date date) {
        this(date.month, date.day, date.year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (month < 0 || month > 31) {
            return;
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 0 || month > 12) {
            return;
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) {
            return;
        }
        this.year = year;
    }

    public void setDate(int month, int day, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    @Override
    public String toString() {
        return (this.month < 10 ? ("0" + this.month) : this.month) + "/" +
                (this.day < 10 ? ("0" + this.day) : this.day) + "/" +
                this.year;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Date &&
                this.day == ((Date)obj).day && this.month == ((Date)obj).month &&
                this.year == ((Date)obj).year;
    }
}

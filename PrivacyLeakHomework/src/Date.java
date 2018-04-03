
public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int month, int day, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public Date(Date date) {
        this(date.month, date.day, date.year);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        if (year >= 2014 && year <= 2024) {
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("Year is out of range.");
        }
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("Month is out of range.");
        }
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        }
        else {
            throw new IllegalArgumentException("Day is out of range.");
        }
    }

    public boolean isAfter(Date other) {
        return this.year > other.year || this.year == other.year &&
                (this.month > other.month || this.month == other.month &&
                        this.day > other.day);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Date &&
                this.year == ((Date) obj).year && this.month == ((Date) obj).month && this.day == ((Date) obj).day;
    }

    @Override
    public String toString() {
        return (this.month > 10 ? ("0" + this.month) : this.month) + "/" +
                (this.day > 10 ? ("0" + this.month) : this.day) + "/" +
                this.year;
    }
}

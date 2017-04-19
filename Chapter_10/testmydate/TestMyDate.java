package testmydate;

public class TestMyDate {

    public static void main(String[] args) {
        MyDate d1 = new MyDate();
        MyDate d2 = new MyDate(34355555133101L);
        System.out.println(d1.getYear() + " " + d1.getMonth() + " " + d1.getDay());
        System.out.println(d2.getYear() + " " + d2.getMonth() + " " + d2.getDay());
    }
}

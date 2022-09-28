package Com;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Rahat", "Employee", LocalDate.of(1999, 10, 28));
        Person p2 = new Person("Nazmul", "Student", LocalDate.of(1996, 1, 8));
        Person p3 = new Person("Jawad", "Employee", LocalDate.of(1992, 12, 12));

        Calculator ca = new Calculator(p1.dateOfBirth);
        Calculator ca2 = new Calculator(p2.dateOfBirth);
        Calculator ca3 = new Calculator(p3.dateOfBirth);

        Period r1=ca.calc();
        Period r2=ca2.calc();
        Period r3=ca3.calc();

        p1.setAge(r1);
        p2.setAge(r2);
        p3.setAge(r3);

        p1.ShowDetails();
        p2.ShowDetails();
        p3.ShowDetails();
    }

}
package Com;

import java.time.LocalDate;

public class Employees extends Person {

    public Employees(){

    }
    public Employees(String name, String userType, LocalDate dateOfBirth) {
        super(name, userType, dateOfBirth);
    }
}
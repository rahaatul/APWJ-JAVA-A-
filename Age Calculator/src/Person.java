package Com;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    String name;
    String userType;
    LocalDate dateOfBirth;

    Period age;

    public Person(){

    }

    public Person(String name, String userType, LocalDate dateOfBirth) {
        this.name = name;
        this.userType = userType;
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(Period age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Period getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getUserType() {
        return userType;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void ShowDetails(){
        System.out.println("\nName: "+getName());
        System.out.println("Position: "+getUserType());
        System.out.println("Date of Birth: " +getDateOfBirth());
        System.out.println("Age: "+age.getYears()+"years "+age.getMonths()+"Months "+age.getDays()+"days");
    }

}
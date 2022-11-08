import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class person {

public void  getAge(){
    LocalDate date = LocalDate.of(2017,8,03);

    LocalDate curDate = LocalDate.now();

    int age = Period.between(date,curDate).getYears();
    int months = Period.between(date,curDate).getMonths();
    int days = Period.between(date,curDate).getDays();
    System.out.println(age+ "Year  " + months+ "Months  "  +days + "days");

}
}

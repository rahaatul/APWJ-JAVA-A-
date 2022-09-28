package Com;

import java.time.LocalDate;
import java.time.Period;

public class Calculator{

    LocalDate curDate = LocalDate.now();
    LocalDate db;

    public Calculator(LocalDate db) {

        this.db = db;
    }

    public void setCurDate(LocalDate curDate) {
        this.curDate = curDate;
    }

    public void setDb(LocalDate db) {
        this.db = db;
    }

    public LocalDate getCurDate() {
        return curDate;
    }

    public LocalDate getDb() {
        return db;
    }

    public Period calc(){
    Period age = Period.between(getDb(), curDate);
        return age;
    }

}
package hw2;

public class Planning extends Employee {
    public Planning(String name){
        super(name);
        depCode = 0;
        baseWage = 500000;
    }
    public void calculate(){
        pay += baseWage + (Math.max(weekWorkTime - 40, 0)) * 20000;
        mileage += (Math.max(weekWorkTime - 40, 0)) * 1000;
    }

    public void add(){
        if (working)
        {
            weekWorkTime++;
            dayWorkTime++;
            mileage += dayWorkTime * 15;
        }
    }
}

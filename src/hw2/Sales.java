package hw2;

public class Sales extends Employee {

    public Sales(String name){
        super(name);
        depCode = 0;
        baseWage = 550000;
    }

    @Override
    public void calculate(){
        pay += baseWage + (Math.max(weekWorkTime - 40, 0)) * 15000;
        mileage += (Math.max(weekWorkTime - 40, 0)) * 2000;
    }

    @Override
    public void add(){
        if (working)
        {
            weekWorkTime++;
            dayWorkTime++;
            mileage += dayWorkTime * 10;
        }
    }
}

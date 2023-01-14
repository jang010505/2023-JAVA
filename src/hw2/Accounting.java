package hw2;

public class Accounting extends Employee {

    public Accounting(String name){
        super(name);
        depCode = 2;
        baseWage = 450000;
    }
    public void calculate(){
        pay += baseWage + (Math.max(weekWorkTime - 40, 0)) * 23000;
    }
}

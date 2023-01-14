package hw2;

import java.util.Objects;

public class Employee {
    private String name;
    private int startTime;
    private int endTime;
    protected int depCode;
    protected boolean working = false;
    protected int weekWorkTime = 0;
    protected int dayWorkTime = 0;
    protected int mileage = 0;
    protected int baseWage;
    protected int pay = 0;

    public Employee(String name){
        this.name = name;
    }

    public void start(String name, int time){
        if(Objects.equals(this.name, name)){
            dayWorkTime = 0;
            startTime = time;
            working = true;
        }
    }

    public void end(String name, int time){
        if(Objects.equals(this.name, name)){
            endTime = time;
            working = false;
        }
    }

    public void printDayWork(){
        if(depCode == 0)
            System.out.print("영업부 ");
        else if (depCode == 1)
            System.out.print("기획부 ");
        else if (depCode == 2)
            System.out.print("회계부 ");


        System.out.println(name + " (" + startTime + " ~ " + endTime + ") -->");
        System.out.println("    [근무시간 : " + dayWorkTime + "시간, 주간 근무시간 : " + weekWorkTime + "시간, 마일리지 : " + mileage + "포인트]");
    }

    public void calculate(){

    }

    public void add(){
        if(working){
            weekWorkTime++;
            dayWorkTime++;
        }
    }

    public void showInfo(){
        if(depCode == 0)
            System.out.print("영업부 ");
        else if (depCode == 1)
            System.out.print("기획부 ");
        else if (depCode == 2)
            System.out.print("회계부 ");

        System.out.println(name + "-->");
        System.out.println("    주간 근무시간 : " + weekWorkTime + ", 초과 근무시간 : " +  (Math.max(weekWorkTime - 40, 0)));
        System.out.println("    주급 : " + pay);
        System.out.println("    마일리지 : " + mileage);
    }
}

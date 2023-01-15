package hw3;

import java.util.Objects;
import java.util.Scanner;

public class Side extends Menu {
    private boolean add_fork;

    public Side(){

    }

    public Side(String name, int base_price, int size_diff){
        super(name, base_price, size_diff);
    }

    @Override
    public int get_price(){
        return super.get_price() + (add_fork ? 200 : 0);
    }

    @Override
    public void option(){
        System.out.print("        + 포크가 필요하십니까(환경부담금 200원)?(y or n) ");
        Scanner sc = new Scanner(System.in);
        if(Objects.equals(sc.next(), "y"))
            add_fork = true;
        else
            add_fork = false;
    }

    @Override
    public void print_option(){
        if(add_fork)
            System.out.println("    + 포크 추가(환경 부담금 200원)");
    }
}
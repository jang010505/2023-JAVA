package hw3;

import java.util.Objects;
import java.util.Scanner;

public class Drink extends Menu {
    private boolean add_ice;

    public Drink(){

    }

    public Drink(String name, int base_price, int size_diff){
        super(name, base_price, size_diff);
    }

    @Override
    public void option(){
        System.out.print("        + 얼음을 추가하시겠습니까?(y or n) ");
        Scanner sc = new Scanner(System.in);
        if(Objects.equals(sc.next(), "y"))
            add_ice = true;
        else
            add_ice = false;
    }

    @Override
    public void print_option(){
        if(add_ice)
            System.out.println("    + 얼음 추가");
    }
}
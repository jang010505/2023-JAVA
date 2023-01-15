package hw3;

import java.util.Objects;
import java.util.Scanner;

public class Pizza extends Menu{
    private boolean add_cheese_crust;

    public Pizza(){

    }

    public Pizza(String name, int base_price, int size_diff){
        super(name, base_price, size_diff);
    }

    @Override
    public int get_price(){
        return super.get_price() + (add_cheese_crust ? 2000 : 0);
    }

    @Override
    public void option(){
        System.out.print("        + 치즈 크러스트를 추가하시겠습니까(2000 원)?(y or n) ");
        Scanner sc = new Scanner(System.in);
        if(Objects.equals(sc.next(), "y"))
            add_cheese_crust = true;
        else
            add_cheese_crust = false;
    }

    @Override
    public void print_option(){
        if(add_cheese_crust)
            System.out.println("    + 치즈크러스트 추가(2000원)");
    }
}
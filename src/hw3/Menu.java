package hw3;

import hw2.Planning;

public class Menu {
    private int base_price;
    private String name;
    private int size_diff;
    private Size size;

    public Menu(){

    }

    public Menu(String name, int base_price, int size_diff){
        this.name = name;
        this.base_price = base_price;
        this.size_diff = size_diff;
    }

    public void set_size(int i){
        if(i == 1)
            size = Size.SMALL;
        else if(i == 2)
            size = Size.MEDIUM;
        else if(i == 3)
            size = Size.LARGE;
    }

    public int get_price(){
        if(size == Size.SMALL)
            return base_price - size_diff;
        else if(size == Size.MEDIUM)
            return base_price;
        else if(size == Size.LARGE)
            return base_price + size_diff;
        else
            return -1;
    }

    public void option(){

    }

    public void print_option(){

    }

    public String get_name(){
        return name;
    }

    public void print(){
        System.out.println(name + "     " + size + "        W" + get_price());
        print_option();
    }

    @Override
    public String toString(){
        return name;
    }
}

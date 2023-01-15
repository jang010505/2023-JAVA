package hw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Management {
    private final ArrayList<Menu> cart = new ArrayList<Menu>();
    private final ArrayList<Pizza> pizza_list = new ArrayList<Pizza>();
    private final ArrayList<Side> side_list = new ArrayList<Side>();
    private final ArrayList<Drink> drink_list = new ArrayList<Drink>();

    public void load_menu(FileReader menu) throws IOException {
        BufferedReader bufReader = new BufferedReader(menu);
        String data;

        while((data = bufReader.readLine()) != null){
            String[] info = data.split(";");

            String[] names = info[0].split(" ");
            String type = names[0];
            StringBuilder sb = new StringBuilder();
            sb.append(names[1]);
            for(int i = 2; i < names.length; i++) {
                sb.append(" ");
                sb.append(names[i]);
            }
            String name = sb.toString();

            String[] prices = info[1].split(" ");
            int base_price = Integer.parseInt(prices[1]);
            int price_diff = Integer.parseInt(prices[2]);

            if(Objects.equals(type, "p"))
                pizza_list.add(new Pizza(name, base_price, price_diff));
            else if(Objects.equals(type, "d"))
                drink_list.add(new Drink(name, base_price, price_diff));
            else if(Objects.equals(type, "s"))
                side_list.add(new Side(name, base_price, price_diff));
        }
    }

    public void receipt(){
        if(cart.isEmpty()){
            System.out.println("장바구니에 물건이 없습니다!");
            return;
        }

        System.out.println();
        System.out.println();
        System.out.println("               == Order list ==");
        System.out.println();
        System.out.println("                < 주문 명세표 >");
        System.out.println();
        System.out.println("        description             price");
        System.out.println("----------------------------------------------");

        int total_price = 0;
        for(int i = 0; i < cart.size(); i++){
            Menu menu = cart.get(i);
            menu.print();
            total_price += menu.get_price();
        }
        System.out.println("----------------------------------------------");
        System.out.println("                        총 금액 : W" + total_price);
    }

    public void order(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("INU 피자가게에 오신것을 환영합니다");
            System.out.println("다음 메뉴를 골라주세요");
            System.out.println("0 : 결제하기");
            System.out.println("1 : 피자메뉴 보기");
            System.out.println("2 : 사이드메뉴 보기");
            System.out.println("3 : 음료매뉴 보기");
            System.out.print(">>");
            int type = sc.nextInt();

            if(type == 0)
                return;
            else if (type == 1) {
                System.out.println(" [ 피자메뉴 ]");
                print_vector(pizza_list);
                System.out.print("    >>");
                int menu_num = sc.nextInt();

                System.out.println("    사이즈 선택");
                System.out.println("    0: 메뉴 선택 취소    1: 스몰    2: 미디움    3: 라지");
                System.out.print("    >>");
                int menu_size = sc.nextInt();

                if(menu_size == 0)
                    continue;

                Pizza pizza = pizza_list.get(menu_num-1);
                pizza.set_size(menu_size);
                pizza.option();
                cart.add(pizza);
            }
            else if(type == 2) {
                System.out.println(" [ 사이드메뉴 ]");
                print_vector(side_list);
                System.out.print("    >>");
                int menu_num = sc.nextInt();

                System.out.println("    사이즈 선택");
                System.out.println("    0: 메뉴 선택 취소    1: 스몰    2: 미디움    3: 라지");
                System.out.print("    >>");
                int menu_size = sc.nextInt();

                if(menu_size == 0)
                    continue;

                Side side = side_list.get(menu_num-1);
                side.set_size(menu_size);
                side.option();
                cart.add(side);
            }
            else if(type == 3) {
                System.out.println(" [ 음료메뉴 ]");
                print_vector(drink_list);
                System.out.print("    >>");
                int menu_num = sc.nextInt();

                System.out.println("    사이즈 선택");
                System.out.println("    0: 메뉴 선택 취소    1: 스몰    2: 미디움    3: 라지");
                System.out.print("    >>");
                int menu_size = sc.nextInt();

                if(menu_size == 0)
                    continue;

                Drink drink = drink_list.get(menu_num-1);
                drink.set_size(menu_size);
                drink.option();
                cart.add(drink);
            }
        }
    }

    public<T> void print_vector(ArrayList<T> v){
        for(int i = 1; i <= v.size(); i++) {
            T menu = v.get(i-1);
            System.out.println("    " + i + " : " + menu.toString());
        }
    }

    public void clear_cart(){
        cart.clear();
    }
}
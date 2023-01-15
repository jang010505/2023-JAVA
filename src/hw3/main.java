package hw3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Management m = new Management();
        File file = new File("C:\\Users\\user\\hg_yellow\\STUDY\\2023-JAVA\\src\\hw3\\menu.txt");
        FileReader menu = new FileReader(file);

        m.load_menu(menu);
        menu.close();

        while(true){
            m.order();
            m.receipt();

            String  c;
            System.out.print("주문을 새로 진행하시겠습니까? (y or n) ");
            Scanner sc = new Scanner(System.in);
            c = sc.next();

            if(Objects.equals(c, "n"))
                return;

            m.clear_cart();
        }


    }
}
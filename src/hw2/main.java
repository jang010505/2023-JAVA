package hw2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\user\\hg_yellow\\STUDY\\2023-JAVA\\src\\hw2\\setting.txt");
        FileReader setting = new FileReader(file);
        Management m = new Management(setting);
        setting.close();

        file = new File("C:\\Users\\user\\hg_yellow\\STUDY\\2023-JAVA\\src\\hw2\\TimeCard.txt");
        FileReader TimeCard = new FileReader(file);
        m.read(TimeCard);
        TimeCard.close();
        m.calc_salary();
    }
}

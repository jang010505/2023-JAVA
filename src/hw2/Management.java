package hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Management {
    private Employee[] employees;
    private int num;
    private String date;

    public Management(FileReader fin) throws IOException {
        BufferedReader bufReader = new BufferedReader(fin);

        num = Integer.parseInt(bufReader.readLine());
        employees = new Employee[num];

        for(int i = 0; i < num; i++){
            String[] data = bufReader.readLine().split(" ");
            if(Objects.equals(data[0], "s"))
                employees[i] = new Sales(data[1]);
            else if(Objects.equals(data[0], "p"))
                employees[i] = new Planning(data[1]);
            else if(Objects.equals(data[0], "a"))
                employees[i] = new Accounting(data[1]);
        }

        bufReader.close();
    }

    public void read(FileReader fin) throws IOException {
        int time = 0;
        BufferedReader bufReader = new BufferedReader(fin);
        String data = "";
        while ((data = bufReader.readLine()) != null){
            String[] info = data.split(" ");
            if(Objects.equals(info[0], "d")) {
                date = info[1];
                time = 8;
                System.out.println("["+date+"]-------------------------");
            }
            else if(Objects.equals(info[0], "a")) {
                time++;
                for(int i = 0; i < num; i++)
                    employees[i].add();
            }
            else if(Objects.equals(info[0], "s")) {
                for(int i = 0; i < num; i++)
                    employees[i].start(info[1], time);
            }
            else if(Objects.equals(info[0], "e")) {
                for(int i = 0; i < num; i++)
                    employees[i].end(info[1], time);
            }
            else if(Objects.equals(info[0], "o")) {
                for(int i = 0; i < num; i++)
                    employees[i].printDayWork();
            }
        }
    }

    public void calc_salary(){
        System.out.println("[주급 계산] -------------");
        for(int i = 0; i < num; i++){
            employees[i].calculate();
            employees[i].showInfo();
        }
    }
}

package hw1;

import java.util.*;

public class Race {
    private Horse[] horses;
    private int pick;
    private int num;
    private int winner = 0;
    private int[] rank;
    private int[] positions;

    public Race(){
        System.out.println("경마게임!");
        input_num();
        input_pick();

        horses = new Horse[num];
        for(int i = 0; i < num; i++)
            horses[i] = new Horse();

        rank = new int[num];
        positions = new int[num];
    }

    public void start(){
        int turn = 0;
        int nowRank = 1;

        while (!is_over()){
            turn++;
            advance();
            getPositions();
            nowRank = ranking(nowRank);
            print(turn);
        }
        result();
    }

    public void input_num(){
        Scanner sc = new Scanner(System.in);
        System.out.println("몇 마라의 말로 플레이하시겠습니까?");
        while(true){
            try {
                num = sc.nextInt();
                if (2 <= num && num <= 5)
                    break;
                else if (num > 5){
                    System.out.println("최대 5마리의 말까지 플레이 가능합니다.");
                    System.out.println("다시 입력해주세요");
                }
                else{
                    System.out.println("최소 2마리의 말까지 플레이 가능합니다.");
                    System.out.println("다시 입력해주세요");
                }
            }
            catch (InputMismatchException e){
                sc.next();
                System.out.println("잘못된 숫자입력입니다.");
                System.out.println("다시 입력해주세요");
            }
        }
    }

    public void input_pick(){
        Scanner sc = new Scanner(System.in);
        System.out.println("몇 번쨰 말을 선택하시겠습니까?");
        while(true){
            try {
                pick = sc.nextInt();
                if (1 <= pick && pick <= num)
                    break;
                else{
                    System.out.println("잘못된 입력입니다. 입력은 1이상 "+num+"이하여야 합니다.");
                    System.out.println("다시 입력해주세요");
                }
            }
            catch (InputMismatchException e){
                sc.next();
                System.out.println("잘못된 숫자입력입니다.");
                System.out.println("다시 입력해주세요");
            }
        }
    }

    public void advance(){
        for(int i = 0; i < num; i++)
            horses[i].move();
    }

    public boolean is_over(){
        for(int i = 0; i < num; i++)
            if(positions[i] != 20)
                return false;

        return true;
    }

    public void print(int turn){
        System.out.println();
        System.out.println();
        System.out.println("Time : "+ turn);
        System.out.println("===========================================");

        for(int i = 0; i < num; i++){
            System.out.print(i+1);
            horses[i].print();
        }

        System.out.println("===========================================");
    }

    public void result(){
        System.out.printf("우승자는 ");
        for(int i = 0; i < num; i++){
            if(rank[i] == 1)
                System.out.printf("%d번쨰 ", i+1);
        }
        System.out.println("말입니다!");
        System.out.println("===========================================");
        for(int i = 1; i <= num; i++)
            for(int j = 0; j < num; j++)
                if(rank[j] == i)
                    System.out.printf("%d등 : %d번째 말\n", i, j+1);

        System.out.println("===========================================");
        if(rank[pick] == 1)
            System.out.println("축하드립니다! 당신은 승리하셨습니다!");
        else
            System.out.println("당신은 패배하셨습니다. :(");
    }

    public int ranking(int nowRank){
        int count = 0;
        for(int i = 0; i < num; i++){
            if(positions[i] == 20 && rank[i] == 0){
                rank[i] = nowRank;
                count++;
            }
        }
        return nowRank+count;
    }

    public void getPositions(){
        for(int i = 0 ; i < num; i++){
            positions[i] = horses[i].getPosition();
        }
    }
}

package hw1;

public class Horse {
    private int position = 0;

    public void move(){
        position += (int)(Math.random() * 5);
        position = (position > 20 ? 20 : position);
    }

    public boolean isFinished() {
        return position == 20;
    }

    public void print(){
        System.out.print("|");
        for(int i = 0; i < position; i++)
            System.out.print("--");

        System.out.println("(  )=> " + position);
    }

    public int getPosition(){
        return position;
    }
}

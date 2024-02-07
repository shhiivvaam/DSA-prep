import java.util.*;
public class Team {
    public static void main(String args[]) {
        Scanner ask = new Scanner(System.in);
        int input = ask.nextInt();
        
        int count = 0;
        while(input-- >0) {
            int x = ask.nextInt();
            int y = ask.nextInt();
            int z = ask.nextInt();
            
            if(x+y+z >= 2) count++;
        }
        System.out.println(count);
        ask.close();
    }
}
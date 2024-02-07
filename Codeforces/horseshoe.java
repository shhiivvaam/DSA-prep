import java.util.*;

public class horseshoe { 
    public static void main(String args[]) {
        Scanner ask = new Scanner(System.in);
        int arr[] = new int[4];
        
        for(int i = 0;i<4;i++) {
            arr[i] = ask.nextInt();
        }
        
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0;i<3;i++) {
            if(arr[i] == arr[i+1]) count++;
        }
        System.out.println(count);
        ask.close();
    }
}
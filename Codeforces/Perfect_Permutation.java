import java.util.*;

public class Perfect_Permutation {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        
        int n = ask.nextInt();
        
        if(n%2 != 0) System.out.println(-1);
        else {
            int arr[] = new int[n+1];
            
            // array initialization according to the 2nd condition given -> Pi != i
            for(int i = 1;i<=n;i++){
                arr[i] = i;
            }
            
            for(int i = 1;i<n;i+=2) {
                int temp = arr[i];
                arr[i] =  arr[i+1];
                arr[i+1] = temp;
            }
            
            for(int i = 1;i<=n;i++) {
                System.out.print(arr[i] + " ");
            }
        }

        ask.close();
    }
}
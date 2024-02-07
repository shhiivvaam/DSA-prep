import java.util.Scanner;

public class Boy_or_Girl {
    public static void main(String args[]) {
        Scanner ask = new Scanner(System.in);
        
        String str = ask.nextLine();
        
        int arr[] = new int[26];
        for(int i = 0;i<str.length();i++) {
            arr[str.charAt(i) - 'a']++;
        }
        
        int count = 0;
        for(int i = 0;i<arr.length;i++) {
            if(arr[i] >= 1) count++;
        }
        
        if(count%2 == 0) System.out.println("CHAT WITH HER!");
        else System.out.println("IGNORE HIM!");
        
        ask.close();
    }
}

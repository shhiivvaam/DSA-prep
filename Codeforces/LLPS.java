import java.util.*;
public class LLPS {
    public static void main(String args[]) {
        Scanner ask = new Scanner(System.in);
        
        String s = ask.nextLine();
        char c[] = s.toCharArray();
        Arrays.sort(c);
        
        int n = c.length;
        char ch = c[n-1];
        
        int count = 0;
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i) == ch) {
                count++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(count > 0){
            sb.append(ch);
            count--;
        }
        
        System.out.println(sb.toString());
    }
}
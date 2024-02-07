import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;                    // JAVA 7

public class Java_Currency_formatter {
    public static void main(String[] args) {

        Scanner ask = new Scanner(System.in);
        double payment = ask.nextDouble();  

        String u,i,c,f;

        // Locale i = new Locale("en", "IN");

        u = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        // i = NumberFormat.getCurrencyInstance(new Locale("en" , "IN")).format(payment);
        c = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        f = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        
        System.out.println("US: "+u);
        System.out.println("India: "+i);
        System.out.println("China: "+c);
        System.out.println("France: "+f);
    }
}

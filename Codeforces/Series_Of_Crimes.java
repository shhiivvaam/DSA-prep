import java.util.*;

public class Series_Of_Crimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        int row = -1, col = -1;
        
        for (int i = 0; i < n; i++) {
            String rowStr = scanner.next();
            rowCount[i] = rowStr.indexOf('*');
            if (rowCount[i] != -1) {
                row = i + 1;
            }
        }
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (scanner.next().charAt(j) == '*') {
                    colCount[j]++;
                    if (rowCount[i] == -1) {
                        col = j + 1;
                    }
                }
            }
        }
        
        System.out.println(row + " " + col);
    }
}

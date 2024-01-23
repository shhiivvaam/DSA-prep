import java.util.ArrayList;
import java.util.List;

public class Generate_Parenthesis {

    static void Generate_Parenthesis1(int n, int opening, int closing, String str) {
        if (opening == n && closing == n) {
            System.out.println(str);
            return;
        }

        if (opening < n) {
            Generate_Parenthesis1(n, opening + 1, closing, str + "(");
        }
        if (closing < opening) {
            Generate_Parenthesis1(n, opening, closing + 1, str + ")");
        }
    }

    static void Generate_Parenthesis2(int n, int opening, int closing, String str, List<String> list) {
        if (opening == n && closing == n) {
            list.add(str);
            return;
        }

        if (opening < n) {
            Generate_Parenthesis2(n, opening + 1, closing, str + "(", list);
        }
        if (closing < opening) {
            Generate_Parenthesis2(n, opening, closing + 1, str + ")", list);
        }
    }

    public static void main(String[] args) {
        Generate_Parenthesis1(3, 0, 0, "");

        List<String> list = new ArrayList<>();
        Generate_Parenthesis2(3, 0, 0, "", list);
        System.out.println(list);
    }
}
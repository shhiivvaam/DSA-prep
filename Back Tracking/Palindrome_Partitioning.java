import java.util.ArrayList;

public class Palindrome_Partitioning {

    static void printPartitioning1(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 1; i <= ques.length(); i++) {

            String str = ques.substring(0, i);
            if (isPalindrome(str)) {
                printPartitioning1(ques.substring(i), ans + str + "|");
            }
        }
    }

    static void printPartitioning2(String str, ArrayList<String> arr, ArrayList<ArrayList<String>> list) {
        if (str.length() == 0) {
            list.add(new ArrayList<>(arr));
            return;
        }

        for (int i = 1; i <= str.length(); i++) {
            String ans = str.substring(0, i);

            if (isPalindrome(ans)) {
                arr.add(ans);
                printPartitioning2(str.substring(i), arr, list);
                arr.remove(arr.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "nitin";
        String ans = "";
        printPartitioning1(str, ans);

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> arr = new ArrayList<>();
        printPartitioning2(str, arr, list);
        System.out.println(list);
    }

}

public class palindrome_rec {
    public static Boolean checkP(String str, int i, int j) {
        if(i>j) return true;

        if(str.charAt(i++) != str.charAt(j--)) return false;

        return checkP(str, i, j);

    }
    public static void main(String[] args) {
        String str = "Shivam";

        boolean ans = checkP(str, 0, str.length()-1);

        if(ans) System.out.println("Palindrome");
        else System.out.println("Not Palindrome");
    }
}

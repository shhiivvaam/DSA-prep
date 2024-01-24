public class Phone_KeyPad_Problem {

    // All keypads string at respective key(index) -> ex: 1 = abc, 2 = def....
    static String[] key = { "", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz" };

    static void printKeyPad(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        char ch = ques.charAt(0);
        String pressedKeyValues = key[ch - 48];

        for (int i = 0; i < pressedKeyValues.length(); i++) {
            printKeyPad(ques.substring(1), ans + pressedKeyValues.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str = "12";
        printKeyPad(str, "");
    }
}

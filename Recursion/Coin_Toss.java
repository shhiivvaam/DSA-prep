public class Coin_Toss {

    static void coin_toss(int n, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        coin_toss(n - 1, str + 'H');
        coin_toss(n - 1, str + 'T');
    }

    public static void main(String[] args) {
        int toss = 3;
        coin_toss(toss, "");
    }
}

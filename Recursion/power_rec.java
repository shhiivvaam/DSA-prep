public class power_rec {
    public static int power(int a, int b) {
        if(b == 0) return 1;
        if(b == 1) return a;

        int ans = power(a, b/2);

        if(ans% 2 == 0) return ans * ans;
        else return a * ans * ans;
    }
    public static void main(String[] args) {

        int a = 3;
        int b = 11;
        int ans = power(a, b);
        System.out.println(ans);
    }
}

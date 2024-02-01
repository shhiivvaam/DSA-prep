public class Power_logN {

    static int power_logN(int a, int n) { // a is the number and n is the power

        if (n == 0)
            return 1;

        int ans = power_logN(a, n / 2);

        ans = ans * ans; // a^n

        // This is for checking if the given power is odd
        if (n % 2 != 0) {
            ans = ans * a;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(power_logN(2, 10));
    }

}

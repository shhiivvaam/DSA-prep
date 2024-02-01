public class check_Prime {

    static boolean checkprime(int n) {
        int prime = 2;
        while (prime * prime <= n) {
            if (n % prime == 0) {
                return false;
            }
            prime++;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 47;
        System.out.println(checkprime(n));
    }

}

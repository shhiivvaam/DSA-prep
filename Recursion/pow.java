public class pow {

    static int power(int a, int b) {
        if (b == 0)
            return 1;

        // this is also correct
        // if(b == 1) return a;

        int ans = power(a, b - 1);
        return ans * a;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 5;

        //! Remember: This does not takes care of negative numbers
        System.out.println(power(a, b));
    }
}

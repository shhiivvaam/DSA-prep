public class fact {

    //* Function following head Recursion 
    static int factorial1(int n) {
        if (n == 0 || n == 1)
        return 1;
        
        factorial1(n - 1);
        return n * factorial1(n - 1);
    }
    
    //* Function following tail Recursion 
    static int factorial2(int n, int ans) {
        if (n == 0 || n == 1)
            return ans;

        return factorial2(n - 1, ans * n);
    }

    public static void main(String[] args) {
        System.out.println(factorial1(5 ));
        System.out.println(factorial2(5, 1));
    }
}

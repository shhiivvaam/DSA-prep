public class fibonacci {

    //? Question :  To print the nth fibonacci number     ( where the current no. is the sum of the previous two numbers)
        //*   fibonacci series    :  0   1   1   2   3   5   8  13   21 ....
                                 // 0th 1st 2nd 3rd 4th 5th 6th 7th 8th 9th.... fibonacci of the seris

    static int fibonacci1(int n) {
        if(n == 0 || n == 1) return n;

        int fib1 = fibonacci1(n-1);
        int fib2 = fibonacci1(n-2);

        return fib1 + fib2;
        // return fibonacci1(n-1) + fibonacci1(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibonacci1(8));
    }
}

public class Prime_Sieve_Algorithm {

    // ! Prime Seive Algorithm (O log(log(n)))

    //? This is an ALgorithm to check for the prime numbers in very optimistic
    
    //* Approach: We will iterate the boolean array and will mark all the indexes of the boolea array as true if they are not prime and leave it if it is a prime, since the boolean array by defualt comes with all the values as false, so we need not to take care of this case
            // also if we are checking for number (ex: 4) then in each iteration we will also mark all the indexes of the boolean array as true(i.e, not prime) if it comes in its table(means they are the multiples of that number(index)) and will do this similarily for each indexes but also checking for (stricly less than case A/q)

    static void print_prime(int n) {
        // Prime Sieve Algorithm
        // complexity ( N log(log(n)) )

        // true -> number not prime
        // false -> number prime

        // base case
        if (n == 0)
            System.out.println("koi bhi nahi");
        if (n == 1)
            System.out.println("koi bhi nahi");

        boolean[] prime = new boolean[n + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == false) { // i prime number hai, i k multiples ko cut kro
                for (int j = 2; j * i <= n; j++) { // this loop will work as a table for the current {i th } element,
                                                   // and will mark all the numbers as false, where this can be a
                                                   // divisor
                    prime[i * j] = true; // mark as not prime
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == false)
                System.out.print(i + " ");
        }
        return;
    }

    static int count_prime(int n) {
        // Prime Sieve Algorithm
        // complexity ( N log(log(n)) )

        // Approach: We will iterate the boolean array and will mark all the indexes of the boolea array as true if they are not prime and leave it if it is a prime, since the boolean array by defualt comes with all the values as false, so we need not to take care of this case
                    // also if we are checking for number (ex: 4) then in each iteration we will also mark all the indexes of the boolean array as true(i.e, not prime) if it comes in its table(means they are the multiples of that number(index)) and will do this similarily for each indexes.

        // true -> number not prime
        // false -> number prime

        // base case
        if (n == 0 || n == 1)
            return 0;

        boolean[] prime = new boolean[n + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == false) { // i prime number hai, i k multiples ko cut kro
                for (int j = 2; j * i <= n; j++) { // this loop will work as a table for the current {i th } element,
                                                   // and will mark all the numbers as false, where this can be a
                                                   // divisor
                    prime[i * j] = true; // mark as not prime
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i] == false)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

        int ans = count_prime(100);
        System.out.println(ans + " ");

        System.out.println();
        print_prime(100);
    }
}

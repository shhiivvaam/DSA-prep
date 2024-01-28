public class Board_Path {

    // ! This ques is also famous with the name -> total Steps / total ways (Jumps)

    // ! Question :
    // ? We are allowed to take either 1/2 or 3 steps at a time, and find what all
    // are the possible steps to complete n steps and the total count of the
    // possible ways

    static int Board_Path1(int n, int steps, String str) {

        if (n == steps) {
            System.out.print(str + " "); // this is to keep track of the steps taken at every instance
            return 1; // this is used to keep track of the total steps taken for achieving ever
                      // possibility
        }

        if (steps > n) { // this is the most important BASE CASe -> the termination (not considering this
                         // case will result in infinite stack trace and out of memory)
            return 0;
        }

        int first_possibility = Board_Path1(n, steps + 1, str + 1);
        int second_possibility = Board_Path1(n, steps + 2, str + 2);
        int third_possibility = Board_Path1(n, steps + 3, str + 3);

        return first_possibility + second_possibility + third_possibility;
    }

    static int Board_Path2(int n, int steps, String str) {

        if (n == steps) {
            System.out.print(str + " "); // this is to keep track of the steps taken at every instance
            return 1; // this is used to keep track of the total steps taken for achieving ever
                      // possibility
        }

        if (steps > n) { // this is the most important BASE CASe -> the termination (not considering this
                         // case will result in infinite stack trace and out of memory)
            return 0;
        }

        int count = 0;
        for (int dice = 1; dice <= 3; dice++) { // we have taken the terminatio(ending) index to be 3 because we have
                                                // asked int the ques to take 1 -> 2 -> 3 steps in any order and so we
                                                // are recursively finding every possibility of the steps to complete {
                                                // n } steps.
            count += Board_Path2(n, steps + dice, str + dice);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 4; // total stairs
        System.out.println("\n" + Board_Path1(n, 0, ""));
        System.out.println("\n" + Board_Path2(n, 0, ""));
    }
}

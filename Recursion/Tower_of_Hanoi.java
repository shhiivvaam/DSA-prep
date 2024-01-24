public class Tower_of_Hanoi {

    static void TOH(int n, String source, String helper, String destination) {
        if(n == 0) {
            return;
        }

        TOH(n-1, source, destination, helper);
        System.out.println("Move " + n + "th disk from " + source + " to " + destination);
        TOH(n-1, helper, source, destination);
    }
    public static void main(String[] args) {
        int n = 3;
        TOH(n, "A", "B", "C");
    }
}

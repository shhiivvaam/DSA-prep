public class Palindromic_Substrings {

    // ! Axis Orbit Concept

    // ? This is a very optimistic approach to find the Palindromic Substrings,
    // because all other methids takes more time than this.

    // * Approach :

    static int count_palindromic(String str) {
        // odd length of String
        int count = 0;
        for (int axis = 0; axis < str.length(); axis++) {
            for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
                if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
                    count++;
                } else {
                    break;
                }
            }
        }

        // even length fo String
        for (double axis = 0.5; axis < str.length(); axis++) {
            for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
                if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "shhiivvaamm";

        System.out.println(count_palindromic(str));
    }
}

import java.util.ArrayList;

public class Subsets {

    static void subset1(int[] array, int index, String str) {

        if (index == array.length) {
            System.out.println(str);
            return;
        }

        subset1(array, index + 1, str);
        subset1(array, index + 1, str + array[index]);
    }

    static void subset2(int[] array, int index, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> list) {

        if (index == array.length) {
            list.add(new ArrayList<>(arr));
            return;
        }

        subset2(array, index + 1, arr, list);
        arr.add(array[index]);
        subset2(array, index + 1, arr, list);
        arr.remove(arr.size() - 1);

    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4 };
        // subset1(array, 0, "");

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        subset2(array, 0, arr, list);
        System.out.println(list);
    }

}

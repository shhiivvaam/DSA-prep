import java.util.ArrayList;

public class multiple_occurence {
    static ArrayList<Integer> first_occurence1(int[] arr, int index, int element, ArrayList<Integer> list) {
        if (index == arr.length)
            return list;
        if (arr[index] == element)
            list.add(index);

        return first_occurence1(arr, index + 1, element, list);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9 };

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(first_occurence1(arr, 0, 7, list));
    }
}

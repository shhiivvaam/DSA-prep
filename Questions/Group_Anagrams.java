import java.util.*;

public class Group_Anagrams {

    public static void main(String[] args) {
        String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return list;

        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = GenerateKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }

    public static String GenerateKey(String str) {
        int[] frq = new int[26];
        for (char c : str.toCharArray()) {
            frq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : frq) {
            sb.append(i + " "); // ! this { " " } is very important to make differnece in the generated Keys,
                                // ex: one string with key {0 10 1 0 0 0} and another with key {0 10 10 00} will result in the same key ie., { 0101000} so to distinguish add some space to avaid generating the same key.
        }

        return sb.toString();
    }
}

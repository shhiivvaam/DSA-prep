import java.util.*;

public class HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Shivam", 04);
        map.put("Somya", 10);
        map.put("Surbhi", 07);
        map.put("Shachi", 05);
        map.put("Rajesh", 12);

        System.out.println(map);

        // 1st Way
        Set<String> set = new map.keySet();
        System.out.println(set);
        
        for (String str : set) {
            System.out.println(str+ " " + map.get(str));
        }
        
        // 2nd Way
        ArrayList<String> ll = new ArrayList<>(map.keySet());
        for(int i = 0;i<ll.size();i++) {
            System.out.println(ll.get(i) + " " + map.get(ll.get(i)));
        }
    }
}

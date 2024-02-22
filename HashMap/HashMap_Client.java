public class HashMap_Client {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Shivam", 10);
        map.put("Somya", 20);
        map.put("Surbhi", 30);
        map.put("Shachi", 40);
        map.put("Rajesh", 50);

        System.out.println(map);
        map.put("Surbhi", 11);
        System.out.println(map);
        System.out.println(map.get("Shivam"));
        System.out.println(map.get("Shiva"));
        System.out.println(map.containsKey("Shivam"));
        System.out.println(map.containsKey("Shiva"));
        System.out.println(map.remove("Shivam"));
        System.out.println(map);
    }
}
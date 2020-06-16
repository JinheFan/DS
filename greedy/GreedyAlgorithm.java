package greedy;

import java.util.*;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("beijing");
        set1.add("shanghai");
        set1.add("tianjin");
        HashSet<String> set2 = new HashSet<>();
        set2.add("beijing");
        set2.add("guangzhou");
        set2.add("shenzhen");
        HashSet<String> set3 = new HashSet<>();
        set3.add("chengdu");
        set3.add("shanghai");
        set3.add("hangzhou");
        HashSet<String> set4 = new HashSet<>();
        set4.add("shanghai");
        set4.add("tianjin");
        HashSet<String> set5 = new HashSet<>();
        set5.add("hangzhou");
        set5.add("dalian");
        map.put("k1", set1);
        map.put("k2", set2);
        map.put("k3", set3);
        map.put("k4", set4);
        map.put("k5", set5);
        HashSet<String> cities = new HashSet<>();
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            HashSet<String> entryValue = entry.getValue();
            for (String city : entryValue) {
                cities.add(city);
            }
        }
        List<String> res = new ArrayList<>();
        HashSet<String> temp = new HashSet<>();
        String maxKey;
        while (cities.size() != 0) {
            maxKey = null;
            for (String key : map.keySet()) {
                HashSet<String> set = map.get(key);
                temp.clear();
                temp.addAll(set);
                temp.retainAll(cities);
                if (temp.size() > 0 && (maxKey == null || temp.size() > map.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                res.add(maxKey);
                cities.removeAll(map.get(maxKey));
            }
        }
        System.out.println(res);
    }
}

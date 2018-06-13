import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest34 {


    //  599. Minimum Index Sum of Two Lists
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }

        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (String str : map1.keySet()) {
            if (map2.containsKey(str) && min >= (map1.get(str) + map2.get(str))) {
                int cur = map1.get(str) + map2.get(str);
                if (cur < min) {
                    res = new ArrayList<>();
                    res.add(str);
                    min = cur;
                } else {
                    res.add(str);
                }
            }
        }

        return res.toArray(new String[0]);
    }
}

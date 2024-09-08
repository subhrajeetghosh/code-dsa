package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/kth-distinct-string-in-an-array
 * 
 * @author subhrajeetghosh
 */
public class KthDistinctArrElement {
    public String kthDistinct(String[] arr, int k) { //time complexity - O(n)
        Map<String, Boolean> map = new HashMap<>();
        for (String string : arr) {
            if (map.containsKey(string)) {
                map.put(string, false);
            } else {
                map.put(string, true);
            }
        }
        for (String string : arr) {
            if (map.get(string) == true) {
                --k;
                if (k == 0) {
                    return string;
                }
            }
        }
        return "";
    }
}

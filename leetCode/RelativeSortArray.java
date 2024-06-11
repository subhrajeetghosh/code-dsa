package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/relative-sort-array
 * 
 * @author subhrajeetghosh
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) { //time complexity - 
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int[] result = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int size = map.get(arr2[i]);
            map.put(arr2[i], 0);
            while (size-- > 0) {
                result[index++] = arr2[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                int size = map.get(key);
                while (size-- > 0) {
                    list.add(key);
                }
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            result[index++] = list.get(i);
        }
        return result;
    }
}

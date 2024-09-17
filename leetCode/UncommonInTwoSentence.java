package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences
 * 
 * @author subhrajeetghosh
 */
public class UncommonInTwoSentence {
    public String[] uncommonFromSentences(String s1, String s2) { //time complexity - O(n)
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        Map<String, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (i < arr1.length || j < arr2.length) {
            if (i < arr1.length) {
                map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
                i++;
            }
            if (j < arr2.length) {
                map.put(arr2[j], map.getOrDefault(arr2[j], 0) + 1);
                j++;
            }
        }
        List<String> resultList = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                resultList.add(key);
            }
        }
        return resultList.toArray(new String[0]);
    }
}

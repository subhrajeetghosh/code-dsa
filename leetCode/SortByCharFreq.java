package leetCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author subhrajeetghosh
 */
public class SortByCharFreq {
    public String frequencySort_2ndMethod(String s) { // time complexity - O(m + n^2) or O(n^2)
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!map.isEmpty()) {
            int currentLen = 0;
            char currentChar = '\u0000';
            for (char key : map.keySet()) {
                if (map.get(key) > currentLen) {
                    currentLen = map.get(key);
                    currentChar = key;
                }
            }
            map.remove(currentChar);
            for (int i = 0; i < currentLen; i++) {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    public String frequencySort(String s) { // time complexity - O(n log (n))
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Integer, StringBuilder> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (char key : map.keySet()) {
            treeMap.computeIfAbsent(map.get(key), k -> new StringBuilder())
                    .append(String.valueOf(key).repeat(map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        for (int key : treeMap.keySet()) {
            sb.append(treeMap.get(key));
        }
        return sb.toString();
    }
}

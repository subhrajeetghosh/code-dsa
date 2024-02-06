package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams
 * 
 * @author subhrajeetghosh
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {  //time complexity - O(n * k log k)
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sortedStr = new String(c);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(strs[i]);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}

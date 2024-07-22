package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-the-people
 * 
 * @author subhrajeetghosh
 */
public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) { //time complexity - O(n log n)
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<names.length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        int index = 0;
        for(int i=names.length-1; i>=0; i--) {
            names[index++] = new String(map.get(heights[i]));
        }
        return names;
    }
}

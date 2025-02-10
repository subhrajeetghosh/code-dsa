package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls
 * 
 * @author subhrajeetghosh
 */

public class FindDistColourAmongBalls {
    public int[] queryResults_2ndMethod(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            map.put(queries[i][0], queries[i][1]);
            Set<Integer> activeColours = new HashSet<>();
            for (int key : map.keySet()) {
                activeColours.add(map.get(key));
            }
            result[i] = activeColours.size();
        }
        return result;
    }

    public int[] queryResults(int limit, int[][] queries) { // time complexity - O(n)
        int[] result = new int[queries.length];
        Map<Integer, Integer> mapBall = new HashMap<>();
        Map<Integer, Integer> mapColour = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int newColour = queries[i][1];
            if (mapBall.containsKey(ball)) {
                int oldColour = mapBall.get(ball);
                mapColour.put(oldColour, mapColour.get(oldColour) - 1);
                if (mapColour.get(oldColour) == 0) {
                    mapColour.remove(oldColour);
                }
                mapBall.put(ball, newColour);
                mapColour.put(newColour, mapColour.getOrDefault(newColour, 0) + 1);
            } else {
                mapBall.put(queries[i][0], newColour);
                mapColour.put(newColour, mapColour.getOrDefault(newColour, 0) + 1);
            }
            result[i] = mapColour.size();
        }
        return result;
    }
}

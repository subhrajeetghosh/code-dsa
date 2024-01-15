package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses
 * 
 * @author subhrajeetghosh
 */
public class PlayerWithZeroOneLose {
    public List<List<Integer>> findWinners(int[][] matches) {  //time complexity - O(n+m)
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();  //where n is no of matches and m is unique key
        for (int[] arr : matches) {
            map.putIfAbsent(arr[0], 0);
            map.putIfAbsent(arr[1], 0);
            map.put(arr[1], map.get(arr[1]) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> winner = new ArrayList<>();
        List<Integer> looser = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == 0) {
                winner.add(key);
            } else if (map.get(key) == 1) {
                looser.add(key);
            }
        }
        result.add(winner);
        result.add(looser);
        return result;
    }
}

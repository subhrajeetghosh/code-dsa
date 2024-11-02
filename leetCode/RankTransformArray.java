package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array/description/
 * 
 * @author subhrajeetghosh
 */
public class RankTransformArray {
    public int[] arrayRankTransform(int[] arr) { //time complexity - O(n log n)
        int[] sortArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortArr);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int currentRank = 1;
        for (int num : sortArr) {
            if (!map.containsKey(num)) {
                map.put(num, currentRank);
                currentRank++;
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }

    //using treeset
    public int[] arrayRankTransform_2ndMethod(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int num : arr) {
            treeSet.add(num);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int currentRank = 1;
        for(int num : treeSet) {
            map.put(num, currentRank++);
        }

        int[] result = new int[arr.length];
        for(int i=0; i<result.length; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }

    
}

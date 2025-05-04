package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs
 * 
 * @author subhrajeetghosh
 */
public class NumOfEqvDominoPair {
    public int numEquivDominoPairs(int[][] dominoes) { // time complexity - O(n)
        Map<String, Integer> dominoesMap = new HashMap<>();
        for (int[] dominoe : dominoes) {
            String key = "";
            if (dominoe[0] <= dominoe[1]) {
                key += dominoe[0] + " " + dominoe[1];
            } else {
                key += dominoe[1] + " " + dominoe[0];
            }
            dominoesMap.put(key, dominoesMap.getOrDefault(key, 0) + 1);
        }
        int result = 0;
        for (String key : dominoesMap.keySet()) {
            if (dominoesMap.get(key) > 1) {
                int currentCount = dominoesMap.get(key);
                result += (currentCount * (currentCount - 1)) / 2;
            }
        }
        return result;
    }

    // more optimize
    public int numEquivDominoPairs_2ndMethod(int[][] dominoes) { // time complexity - O(n)
        Map<String, Integer> dominoesMap = new HashMap<>();
        int result = 0;
        for (int[] dominoe : dominoes) {
            String key = "";
            if (dominoe[0] <= dominoe[1]) {
                key += dominoe[0] + " " + dominoe[1];
            } else {
                key += dominoe[1] + " " + dominoe[0];
            }
            dominoesMap.put(key, dominoesMap.getOrDefault(key, 0) + 1);
            result += dominoesMap.get(key) - 1;
        }
        return result;
    }

    // more optimize
    public int numEquivDominoPairs_3rdMethod(int[][] dominoes) { //time complexity - O(n)
        int[] retVal = new int[100];
        int result = 0;
        for (int[] domino : dominoes) {
            int value = domino[0] <= domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            result += retVal[value];
            retVal[value]++;
        }
        return result;
    }
}

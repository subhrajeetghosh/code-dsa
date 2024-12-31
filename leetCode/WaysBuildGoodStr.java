package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-ways-to-build-good-string
 * 
 * @author subhrajeetghosh
 */
public class WaysBuildGoodStr {
    // Bruteforce
    Set<String> set;
    int mod = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) { // time complexity - O(2^high)
        set = new HashSet<String>();

        String zeroUnit = "";
        for (int i = 0; i < zero; i++) {
            zeroUnit += "0";
        }
        String oneUnit = "";
        for (int i = 0; i < one; i++) {
            oneUnit += "1";
        }
        return backtrack(low, high, "", zeroUnit, oneUnit);
    }

    private int backtrack(int low, int high, String currentComb, String zeroUnit, String oneUnit) {
        if (currentComb.length() > high) {
            return 0;
        }
        if (currentComb.length() >= low && !set.contains(currentComb)) {
            set.add(currentComb);
            return 1 + backtrack(low, high, currentComb + zeroUnit, zeroUnit, oneUnit);
        }
        int count = backtrack(low, high, currentComb + zeroUnit, zeroUnit, oneUnit);
        count += backtrack(low, high, currentComb + oneUnit, zeroUnit, oneUnit);
        return count % mod;
    }

    Map<Integer, Integer> map;

    public int countGoodStrings_2ndMethod(int low, int high, int zero, int one) { // time complexity O(high)
        map = new HashMap<Integer, Integer>();
        return backTrack(low, high, zero, one, 0);
    }

    private int backTrack(int low, int high, int zero, int one, int currentCount) {
        if (map.containsKey(currentCount)) {
            return map.get(currentCount);
        }
        if (currentCount > high) {
            return 0;
        }
        int count = 0;
        if (currentCount >= low) {
            count = 1;
        }
        count += backTrack(low, high, zero, one, currentCount + zero);
        count %= mod;

        count += backTrack(low, high, zero, one, currentCount + one);
        count %= mod;

        map.put(currentCount, count);
        return map.get(currentCount);
    }

}

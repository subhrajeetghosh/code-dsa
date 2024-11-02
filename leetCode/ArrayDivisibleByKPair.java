package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k
 * 
 * @author subhrajeetghosh
 */
public class ArrayDivisibleByKPair {
    public boolean canArrange(int[] arr, int k) { // time complexity - O(n)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            if (remainder == 0) {
                if (map.get(remainder) % 2 == 1)
                    return false;
            } else if (!Objects.equals(map.get(remainder), map.get(k - remainder))) {
                return false;
            }
        }
        return true;
    }
}

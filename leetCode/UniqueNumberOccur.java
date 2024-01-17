package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences
 * 
 * @author subhrajeetghosh
 */
public class UniqueNumberOccur {
    public boolean uniqueOccurrences(int[] arr) { // time complexity - O(n log n)
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<Integer>();
        int currentNum = arr[0];
        int currentCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == currentNum) {
                currentCount++;
            } else {
                if (!set.add(currentCount))
                    return false;
                currentCount = 1;
                currentNum = arr[i];
            }
        }
        if (!set.add(currentCount))
            return false;
        return true;
    }

    // another approch
    public boolean uniqueOccurrences_2ndMthod(int[] arr) { // time complexity - O(n)
        Map<Integer, Integer> occuranceWithKey = new HashMap<>();
        for (int i : arr) {
            occuranceWithKey.put(i, occuranceWithKey.getOrDefault(i, 0) + 1);
        }

        Set<Integer> occuranceValue = new HashSet<>(occuranceWithKey.values());

        return occuranceValue.size() == occuranceWithKey.size();
    }
}

package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-labels
 * 
 * @author subhrajeetghosh
 */
public class PartitionLevels {
    public List<Integer> partitionLabels(String s) { // time complexity - O(n)
        Map<Character, Integer> maxMap = new HashMap<>();
        int index = 0;
        for (char c : s.toCharArray()) {
            maxMap.put(c, index++);
        }
        index = 0;
        List<Integer> result = new ArrayList<>();
        int indexSum = 0;
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            int maxIndex = maxMap.get(currentChar);
            while (index <= maxIndex) {
                maxIndex = Math.max(maxIndex, maxMap.get(s.charAt(index++)));
            }
            if (result.size() == 0) {
                result.add(index);
                indexSum = index;
            } else {
                result.add(index - indexSum);
                indexSum += index - indexSum;
            }
        }
        return result;
    }
}

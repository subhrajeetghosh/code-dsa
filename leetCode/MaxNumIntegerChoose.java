package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i
 * 
 * @author subhrajeetghosh
 */
public class MaxNumIntegerChoose {
    public int maxCount(int[] banned, int n, int maxSum) { // time complexity - (m+n)
        Set<Integer> set = new HashSet<Integer>();
        for (int num : banned) {
            set.add(num);
        }
        long sum = 0;
        int index = 1, resultCount = 0;
        while (index <= n && sum + index <= maxSum) {
            if (!set.contains(index)) {
                sum += index;
                resultCount++;
            }
            index++;
        }
        return resultCount;
    }

    
}

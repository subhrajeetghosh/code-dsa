package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/
 * 
 * @author subhrajeetghosh
 */
public class LengthLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) { //time complexity - O(m log 10 m + n log 10 n)
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            int currentNum = arr1[i];
            while (currentNum > 0) {
                set.add(currentNum);
                currentNum /= 10;
            }
        }
        int result = 0;
        for (int i = 0; i < arr2.length; i++) {
            int currentNum = arr2[i];
            while (currentNum > 0) {
                if (set.contains(currentNum)) {
                    result = Math.max(String.valueOf(currentNum).length(), result);
                }
                currentNum /= 10;
            }

        }
        return result;
    }
}

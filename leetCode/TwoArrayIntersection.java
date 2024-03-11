package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays
 * 
 * @author subhrajeetghosh
 */
public class TwoArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {  //time complexity - O(m+n)
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> setResult = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                setResult.add(nums2[i]);
            }
        }
        int[] result = new int[setResult.size()];
        int i = 0;
        for (Integer num : setResult) {
            result[i++] = num;
        }
        return result;
    }
}

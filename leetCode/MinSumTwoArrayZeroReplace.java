package leetCode;

/**
 * https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros
 * 
 * @author subhrajeetghosh
 */
public class MinSumTwoArrayZeroReplace {
    public long minSum(int[] nums1, int[] nums2) { // time complexity - O(n)
        long nums1Zero = 0, nums1Sum = 0;
        long nums2Zero = 0, nums2Sum = 0;
        ;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                nums1Zero++;
            }
            nums1Sum += nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                nums2Zero++;
            }
            nums2Sum += nums2[i];
        }
        nums1Sum += nums1Zero;
        nums2Sum += nums2Zero;
        if (nums1Sum < nums2Sum && nums1Zero == 0)
            return -1;
        if (nums2Sum < nums1Sum && nums2Zero == 0)
            return -1;
        return Math.max(nums1Sum, nums2Sum);
    }
}

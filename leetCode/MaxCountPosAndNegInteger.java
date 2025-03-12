package leetCode;

/**
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer
 * 
 * @author subhrajeetghosh
 */
public class MaxCountPosAndNegInteger {
    class Solution {
        public int maximumCount(int[] nums) { // time complexity - O(log n)
            int positiveIndex = binarySearch(nums);
            int negIndex = positiveIndex;
            while (positiveIndex < nums.length && nums[positiveIndex] == 0) {
                positiveIndex++;
            }
            return Math.max(negIndex, nums.length - positiveIndex);
        }

        private int binarySearch(int[] nums) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}

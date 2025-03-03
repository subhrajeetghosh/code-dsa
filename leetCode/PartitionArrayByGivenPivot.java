package leetCode;

/**
 * https://leetcode.com/problems/partition-array-according-to-given-pivot
 * 
 * @author subhrajeetghosh
 */
public class PartitionArrayByGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) { //time complexity - O(n)
        int i = 0, j = nums.length - 1, left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        while (i < nums.length) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                result[right--] = nums[j];
            }
            i++;
            j--;
        }
        while (left <= right) {
            result[left++] = pivot;
        }
        return result;
    }
}

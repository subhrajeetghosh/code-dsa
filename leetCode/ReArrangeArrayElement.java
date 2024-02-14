package leetCode;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign
 * 
 * @author subhrajeetghosh
 */
public class ReArrangeArrayElement {
    public int[] rearrangeArray(int[] nums) { // time complexity - O(n)
        int[] arr = new int[nums.length];
        int pInd = 0;
        int nInd = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                arr[pInd] = nums[i];
                pInd += 2;
            } else {
                arr[nInd] = nums[i];
                nInd += 2;
            }
        }
        return arr;
    }

    public int[] rearrangeArray_2ndMethod(int[] nums) { // time complexity - O(n) overall worst case O(2n)
        int[] arr = new int[nums.length];
        int pInd = 0;
        int nInd = 0;
        for (int i = 0; i < nums.length; i += 2) {
            while (nums[pInd] < 0) {
                pInd++;
            }
            arr[i] = nums[pInd];
            pInd++;
            while (nums[nInd] > 0) {
                nInd++;
            }
            arr[i + 1] = nums[nInd];
            nInd++;
        }
        return arr;
    }
}

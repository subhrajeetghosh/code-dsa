package leetCode;

/**
 * https://leetcode.com/problems/minimum-common-value
 * 
 * @author subhrajeetghosh
 */
public class MinCommonValue {
    // Bruteforce approch
    public int getCommon_2ndMethod(int[] nums1, int[] nums2) { // time complexity - O(m+n)
        int i = 0, j = 0;
        int currentNum1 = nums1[0];
        int currentNum2 = nums2[0];
        while (i < nums1.length || j < nums2.length) {
            while (currentNum1 < currentNum2 && i < nums1.length) {
                currentNum1 = nums1[i++];
            }
            while (currentNum2 < currentNum1 && j < nums2.length) {
                currentNum2 = nums2[j++];
            }
            if (currentNum1 == currentNum2)
                return currentNum1;
        }
        return -1;
    }

    // Binary search approch
    public int getCommon(int[] nums1, int[] nums2) { // time complexity - O(m log(n))
        for (int i = 0; i < nums1.length; i++) {
            if (binarySearch(nums2, nums1[i])) {
                return nums1[i];
            }
        }
        return -1;
    }

    private boolean binarySearch(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] == target)
                return true;
            if (target < arr[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }

    public int getCommon_1(int[] nums1, int[] nums2) { // time complexity - O(m+n)
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j])
                return nums1[i];
            if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return -1;
    }
}

package leetCode;

/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array
 * 
 * @author Subhrajeet Ghosh
 */
public class SortedCountElement {
    public int findSpecialInteger(int[] arr) { // time complexity - O(n)
        int currentCount = 1;
        int currentEle = arr[0];
        int currentAns = arr[0];
        int maxCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == currentEle) {
                currentCount++;
            } else {
                currentEle = arr[i];
                currentCount = 1;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                currentAns = currentEle;
            }
        }
        return currentAns;
    }

    // optimized approch
    public int findSpecialInteger_2ndMethod(int[] arr) {
        int size = arr.length / 4;
        for (int i = 0; i < arr.length - size; i++) {
            if (arr[i] == arr[i + size]) {
                return arr[i];
            }
        }
        return -1;
    }
}

package leetCode;

/**
 * https://leetcode.com/problems/maximum-swap
 * 
 * @author subhrajeetghosh
 */
public class MaximumSwap {
    public int maximumSwap(int num) { // time complexity - O(n)
        char[] arr = String.valueOf(num).toCharArray();
        int[] maxIndexArr = new int[arr.length];
        int maxIndex = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
            maxIndexArr[i] = maxIndex;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[maxIndexArr[i]]) {
                char tmp = arr[i];
                arr[i] = arr[maxIndexArr[i]];
                arr[maxIndexArr[i]] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}

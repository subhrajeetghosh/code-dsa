package leetCode;

/**
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds
 * 
 * @author subhrajeetghosh
 */
public class CountArrayFixedBound {
    public long countSubarrays(int[] A, int minK, int maxK) {
        long result = 0, currentMin = -1, currentMax = -1, currentBad = -1;
        for(int i=0; i<A.length; i++) {
            if(A[i] > maxK || A[i] < minK) currentBad = i;
            if(A[i] == minK) currentMin = i;
            if(A[i] == maxK) currentMax = i;
            result += Math.max(0l, Math.min(currentMin, currentMax) - currentBad);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 2, 7, 5 };
        new CountArrayFixedBound().countSubarrays(arr, 1, 5);
    }
}

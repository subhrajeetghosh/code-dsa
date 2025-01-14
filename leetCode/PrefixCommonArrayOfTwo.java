package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays
 * 
 * @author subhrajeetghosh
 */
public class PrefixCommonArrayOfTwo {
    public int[] findThePrefixCommonArray(int[] A, int[] B) { // time complexity - O(n^2)
        Set<Integer> set = new HashSet<Integer>();
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            int count = 0;
            for (int j = 0; j <= i; j++) {
                if (set.contains(B[j])) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    // another approch
    public int[] findThePrefixCommonArray_2ndMethod(int[] A, int[] B) { // time complexity - O(n^2)
        int[] freq = new int[A.length + 1];
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
            freq[B[i]]++;
            int count = 0;
            for (int j = 0; j < freq.length; j++) {
                if (freq[j] == 2) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}

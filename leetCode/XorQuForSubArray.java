package leetCode;

/**
 * https://leetcode.com/problems/xor-queries-of-a-subarray
 * 
 * @author subhrajeetghosh
 */
public class XorQuForSubArray {
    public int[] xorQueries_2ndMethod(int[] arr, int[][] queries) { // time complexity - O(n*m)
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] != queries[i][1]) {
                int left = arr[queries[i][0]];
                for (int j = queries[i][0] + 1; j <= queries[i][1]; j++) {
                    left = left ^ arr[j];
                }
                result[i] = left;
            } else {
                result[i] = arr[queries[i][0]];
            }
        }
        return result;
    }

    // optimize approch
    public int[] xorQueries(int[] arr, int[][] queries) { //time complexity - O(n)
        int[] result = new int[queries.length];
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] ^ prefix[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                result[i] = prefix[queries[i][1]];
            } else {
                result[i] = prefix[queries[i][1]] ^ prefix[queries[i][0] - 1];
            }
        }
        return result;
    }
}

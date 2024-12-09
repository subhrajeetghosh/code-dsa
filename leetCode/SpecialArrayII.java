package leetCode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/special-array-ii
 * 
 * @author subhrajeetghosh
 */
public class SpecialArrayII {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) { // time complexity - O(n log n) + (m log n)
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                treeSet.add(i);
            }
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (treeSet.subSet(queries[i][0], queries[i][1]).isEmpty()) {
                answer[i] = true;
            }
        }
        return answer;
    }
}

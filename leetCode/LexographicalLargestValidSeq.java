package leetCode;

/**
 * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence
 * 
 * @author subhrajeetghosh
 */
public class LexographicalLargestValidSeq {
    public int[] constructDistancedSequence(int n) { // time complexity - O(n!)
        int len = 2 * n - 1;
        int[] result = new int[len];
        boolean[] used = new boolean[n + 1];
        backtrack(0, result, used, n);
        return result;
    }

    private boolean backtrack(int index, int[] result, boolean[] used, int n) {
        if (index == result.length)
            return true;
        if (result[index] != 0)
            return backtrack(index + 1, result, used, n);
        for (int num = n; num > 0; num--) {
            int secondIndex = num == 1 ? index : index + num;
            if (used[num] || (num > 1 && (secondIndex >= result.length || result[secondIndex] != 0))) {
                continue;
            }
            used[num] = true;
            result[secondIndex] = num;
            result[index] = num;

            if (backtrack(index + 1, result, used, n)) {
                return true;
            }

            used[num] = false;
            result[secondIndex] = 0;
            result[index] = 0;
        }
        return false;
    }
}

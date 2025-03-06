package leetCode;

/**
 * https://leetcode.com/problems/find-missing-and-repeated-values
 * 
 * @author subhrajeetghosh
 */
public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) { // time complexity - O(n^2)
        int[] gridChecker = new int[grid.length * grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                gridChecker[grid[i][j] - 1]++;
            }
        }
        int[] result = new int[2];
        int resultCount = 0;
        for (int i = 0; i < gridChecker.length; i++) {
            if (gridChecker[i] == 0) {
                result[1] = i + 1;
                resultCount++;
            } else if (gridChecker[i] == 2) {
                result[0] = i + 1;
                resultCount++;
            }
            if (resultCount == 2) {
                break;
            }
        }
        return result;
    }
}

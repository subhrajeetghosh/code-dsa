package leetCode;

/**
 * https://leetcode.com/problems/grid-game/
 * 
 * @author subhrajeetghosh
 */
public class GridGame {
    public long gridGame(int[][] grid) { // time complexity - O(n)
        long[] topPrefix = new long[grid[0].length];
        long[] bottomPrefix = new long[grid[0].length];
        topPrefix[0] = grid[0][0];
        bottomPrefix[0] = grid[1][0];
        for (int i = 1; i < grid[0].length; i++) {
            topPrefix[i] = grid[0][i] + topPrefix[i - 1];
            bottomPrefix[i] = grid[1][i] + bottomPrefix[i - 1];
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            long top = topPrefix[topPrefix.length - 1] - topPrefix[i];
            long bottom = i == 0 ? 0 : bottomPrefix[i - 1];
            result = Math.min(result, Math.max(top, bottom));
        }
        return result;
    }
}

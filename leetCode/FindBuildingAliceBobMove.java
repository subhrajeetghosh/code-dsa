package leetCode;

/**
 * https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet
 * 
 * @author subhrajeetghosh
 */
public class FindBuildingAliceBobMove {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int alice = heights[query[0]];
            int bob = heights[query[1]];
            int start = Math.max(query[0], query[1]);
            result[index] = -1;
            for (int i = start; i < heights.length; i++) {
                if (heights[i] > alice && heights[i] > bob) {
                    result[index] = i;
                    break;
                }
            }
            index++;
        }
        return result;
    }
}

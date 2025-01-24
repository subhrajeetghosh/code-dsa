package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author subhrajeetghosh
 */
public class MapOfHighestPick {
    public int[][] highestPeak(int[][] isWater) { // time complexity - O(m*n)
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];
        Queue<int[]> qu = new LinkedList<>();
        int[][] result = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    qu.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        while (!qu.isEmpty()) {
            int[] currentIndex = qu.poll();
            int i = currentIndex[0];
            int j = currentIndex[1];
            if (i > 0 && !visited[i - 1][j]) {
                result[i - 1][j] = result[i][j] + 1;
                visited[i - 1][j] = true;
                qu.add(new int[] { i - 1, j });
            }
            if (i < result.length - 1 && !visited[i + 1][j]) {
                result[i + 1][j] = result[i][j] + 1;
                visited[i + 1][j] = true;
                qu.add(new int[] { i + 1, j });
            }
            if (j > 0 && !visited[i][j - 1]) {
                result[i][j - 1] = result[i][j] + 1;
                visited[i][j - 1] = true;
                qu.add(new int[] { i, j - 1 });
            }
            if (j < result[0].length - 1 && !visited[i][j + 1]) {
                result[i][j + 1] = result[i][j] + 1;
                visited[i][j + 1] = true;
                qu.add(new int[] { i, j + 1 });
            }
        }
        return result;
    }
}

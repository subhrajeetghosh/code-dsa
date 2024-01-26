package dynamicprogrammingcourse;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 * 
 * @author subhrajeetghosh
 */
public class OutOfBoundaryPath {
    // bruteforce approch
    // O(4^(maxMove * m * n)). This is because, for each position (row, column) in
    // the grid,
    // the algorithm explores four possible moves (up, left, down, right) for each
    // recursive call,
    // and it repeats this process for maxMove times.
    public int findPaths_2ndMethod(int m, int n, int maxMove, int startRow, int startColumn) {
        return moves2(m, n, maxMove, startRow, startColumn);
    }

    private int moves2(int m, int n, int maxMove, int row, int column) {
        if (m <= row || n <= column || 0 > row || 0 > column) {
            return 1;
        }
        if (maxMove == 0)
            return 0;
        int calc = 0;
        calc += moves2(m, n, maxMove - 1, row - 1, column);
        calc += moves2(m, n, maxMove - 1, row, column - 1);
        calc += moves2(m, n, maxMove - 1, row + 1, column);
        calc += moves2(m, n, maxMove - 1, row, column + 1);
        return calc;
    }

    //momorization
    Map<StringBuilder, Integer> map = new HashMap<>();

    public int findPaths_3rdMethod(int m, int n, int maxMove, int startRow, int startColumn) {
        return moves1(m, n, maxMove, startRow, startColumn);
    }

    private int moves1(int m, int n, int maxMove, int row, int column) {
        StringBuilder key = new StringBuilder().append(row).append("-").append(column)
                .append("-").append(maxMove);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (m <= row || n <= column || 0 > row || 0 > column) {
            return 1;
        }
        if (maxMove == 0)
            return 0;
        int calc = 0;
        calc += moves1(m, n, maxMove - 1, row - 1, column);
        calc += moves1(m, n, maxMove - 1, row, column - 1);
        calc += moves1(m, n, maxMove - 1, row + 1, column);
        calc += moves1(m, n, maxMove - 1, row, column + 1);
        calc = calc % 1000000007;
        map.put(key, calc);
        return calc;
    }

    //memorization with 3D array
    Integer[][][] matrix;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        matrix = new Integer[m+1][n+1][maxMove+1];
        return moves(m, n, maxMove, startRow, startColumn);
    }

    private int moves(int m, int n, int maxMove, int row, int column) {
        if (m <= row || n <= column || 0 > row || 0 > column) {
            return 1;
        }
        if (maxMove == 0)
            return 0;
        if(matrix[row][column][maxMove] != null) return matrix[row][column][maxMove];
    
        long calc = 0;
        calc += moves(m, n, maxMove - 1, row - 1, column) % 1000000007;
        calc += moves(m, n, maxMove - 1, row, column - 1) % 1000000007;
        calc += moves(m, n, maxMove - 1, row + 1, column) % 1000000007;
        calc += moves(m, n, maxMove - 1, row, column + 1) % 1000000007;
        calc = calc % 1000000007;
        matrix[row][column][maxMove] = (int)calc;
        return (int)calc;
    }
}

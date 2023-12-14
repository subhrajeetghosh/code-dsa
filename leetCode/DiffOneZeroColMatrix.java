package leetCode;

/**
 * https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
 * 
 * @author Subhrajeet Ghosh
 */
public class DiffOneZeroColMatrix {
    public int[][] onesMinusZeros(int[][] grid) { // time complexity - O(mn) space - O(m+n)
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] rowData = new int[rowLength];
        int[] colData = new int[colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    rowData[i]++;
                    colData[j]++;
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                grid[i][j] = rowData[i] + colData[j] - (rowLength - rowData[i]) - (colLength - colData[j]);
            }
        }
        return grid;
    }

    //Same Approch just different calculation
    public int[][] onesMinusZeros_2ndMethod(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] rowData = new int[rowLength];
        int[] colData = new int[colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    rowData[i]++;
                    colData[j]++;
                } else {
                    rowData[i]--;
                    colData[j]--;
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                grid[i][j] = rowData[i] + colData[j];
            }
        }
        return grid;
    }
}

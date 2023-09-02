package dynamicprogrammingcourse;

public class UniqueGridPath {
    public int gridTraveler(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
    public static void main(String[] args) {
        System.out.println(new UniqueGridPath().gridTraveler(3, 3));
    }
}

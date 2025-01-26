import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countServers(int[][] grid) {
        Map<Integer, Integer> rowCounts = new HashMap<>();
        Map<Integer, Integer> colCounts = new HashMap<>();
        
        // First pass: Count the number of servers in each row and column
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    rowCounts.put(i, rowCounts.getOrDefault(i, 0) + 1);
                    colCounts.put(j, colCounts.getOrDefault(j, 0) + 1);
                }
            }
        }
        
        // Second pass: Count servers that can communicate
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && (rowCounts.get(i) > 1 || colCounts.get(j) > 1)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
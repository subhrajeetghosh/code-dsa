package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountServerThatCommunicate {
    public int countServers(int[][] grid) { // time complexity - O(m * n)
        Set<String> resultSet = new HashSet<String>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    String rowStr = "row" + i;
                    String colStr = "col" + j;
                    if (map.containsKey(rowStr)) {
                        if (map.get(rowStr) != null) {
                            resultSet.add(map.get(rowStr));
                        }
                        resultSet.add(i + " " + j);
                        map.put(rowStr, null);
                    } else {
                        map.put(rowStr, i + " " + j);
                    }
                    if (map.containsKey(colStr)) {
                        if (map.get(colStr) != null) {
                            resultSet.add(map.get(colStr));
                        }
                        resultSet.add(i + " " + j);
                        map.put(colStr, null);
                    } else {
                        map.put(colStr, i + " " + j);
                    }
                }
            }
        }
        return resultSet.size();
    }

    public int countServers_2ndMethod(int[][] grid) { // time complexity - 2*(m*n)
        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    result++;
                }
            }
        }
        return result;
    }
}

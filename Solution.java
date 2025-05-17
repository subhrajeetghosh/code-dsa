import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int countServers(int[][] grid) {
        Map<Integer, Integer> rowCounts = new HashMap<>();
        Map<Integer, Integer> colCounts = new HashMap<>();

        // First pass: Count the number of servers in each row and column
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rowCounts.put(i, rowCounts.getOrDefault(i, 0) + 1);
                    colCounts.put(j, colCounts.getOrDefault(j, 0) + 1);
                }
            }
        }

        // Second pass: Count servers that can communicate
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (rowCounts.get(i) > 1 || colCounts.get(j) > 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        Map<Integer, List<Integer>> wordMapping = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMapping.put(i, new ArrayList<>());
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (groups[i] != groups[j] && hammerString(words[i], words[j])) {
                    wordMapping.get(i).add(j);
                }
            }
        }
        List<String> result = new ArrayList<>();

        return result;
    }

    private boolean hammerString(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }
}
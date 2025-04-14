package miscellaneous;
import java.util.*;

public class MaxIncreasingPairs {
    
    public static int maxIncreasingPairs(int[] ratings) {
        // Create a map to store memoized results
        Map<String, Integer> memo = new HashMap<>();
        boolean[] visited = new boolean[ratings.length];
        return backtrack(ratings, visited, new ArrayList<>(), memo);
    }
    
    private static int backtrack(int[] ratings, boolean[] visited, List<Integer> current, Map<String, Integer> memo) {
        // Base case: all elements are used
        if (current.size() == ratings.length) {
            int count = 0;
            for (int i = 0; i < current.size() - 1; i++) {
                if (current.get(i) < current.get(i + 1)) {
                    count++;
                }
            }
            return count;
        }
        
        // Create a state key for memoization
        String stateKey = current.toString();
        
        // Check if we've already computed this state
        if (memo.containsKey(stateKey)) {
            return memo.get(stateKey);
        }
        
        int maxCount = 0;
        Set<Integer> used = new HashSet<>(); // To avoid generating duplicate permutations
        
        for (int i = 0; i < ratings.length; i++) {
            if (!visited[i] && !used.contains(ratings[i])) {
                used.add(ratings[i]);
                visited[i] = true;
                current.add(ratings[i]);
                
                int result = backtrack(ratings, visited, current, memo);
                maxCount = Math.max(maxCount, result);
                
                // Backtrack
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
        
        // Memoize and return
        memo.put(stateKey, maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] ratings1 = {2, 1, 1, 2};    // Expected: 2
        int[] ratings2 = {1, 2, 3, 4, 5}; // Expected: 4

        System.out.println("Test 1: " + maxIncreasingPairs(ratings1));
        System.out.println("Test 2: " + maxIncreasingPairs(ratings2));
    }
}
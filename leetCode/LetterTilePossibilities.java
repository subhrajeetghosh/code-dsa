package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/letter-tile-possibilities
 * 
 * @author subhrajeetghosh
 */
public class LetterTilePossibilities {
    Set<String> set;

    public int numTilePossibilities(String tiles) { // time complexity - O(n * n!)
        set = new HashSet<String>();
        backTrack(tiles, "", new boolean[tiles.length()]);
        return set.size() - 1;
    }

    private void backTrack(String tiles, String current, boolean[] used) {
        set.add(current);
        for (int i = 0; i < tiles.length(); i++) {
            if (used[i])
                continue;
            String newCurrent = current + tiles.charAt(i);
            used[i] = true;
            backTrack(tiles, newCurrent, used);
            used[i] = false;
        }
    }

    public int numTilePossibilities_2ndMethod(String tiles) { // time complexity - O(26^n)
        Map<Character, Integer> tilesCounter = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            tilesCounter.put(c, tilesCounter.getOrDefault(c, 0) + 1);
        }
        return dfs(tilesCounter);
    }

    private int dfs(Map<Character, Integer> tilesCounter) {
        int total = 0;
        for (char key : tilesCounter.keySet()) {
            if (tilesCounter.get(key) > 0) {
                tilesCounter.put(key, tilesCounter.get(key) - 1);
                total += 1 + dfs(tilesCounter);
                tilesCounter.put(key, tilesCounter.get(key) + 1);
            }
        }
        return total;
    }
}

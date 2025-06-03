package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes
 * 
 * @author subhrajeetghosh
 */
public class MaxCandiesFromBox {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        boolean[] visited = new boolean[candies.length];
        Set<Integer> eligibleBox = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < initialBoxes.length; i++) {
            eligibleBox.add(initialBoxes[i]);
            if (status[initialBoxes[i]] == 1) {
                queue.add(initialBoxes[i]);
            }
        }
        while (!queue.isEmpty()) {
            int currentBox = queue.poll();
            if (visited[currentBox])
                continue;
            visited[currentBox] = true;
            result += candies[currentBox];
            for (int key : keys[currentBox]) {
                status[key] = 1;
                if (eligibleBox.contains(key) && !visited[key]) {
                    queue.add(key);
                }
            }
            for (int insBox : containedBoxes[currentBox]) {
                eligibleBox.add(insBox);
                if (status[insBox] == 1 && !visited[insBox]) {
                    queue.add(insBox);
                }
            }
        }
        return result;
    }
    // time complexity - O(n + m + sum_k + sum_c)
}

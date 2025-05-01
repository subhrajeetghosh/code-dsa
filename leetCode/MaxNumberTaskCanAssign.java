package leetCode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign
 * 
 * @author subhrajeetghosh
 */
public class MaxNumberTaskCanAssign {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) { // time complexity - O(n log^2 n)
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0, right = Math.min(tasks.length, workers.length);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canComplete(tasks, workers, mid, strength, pills)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canComplete(int[] tasks, int[] workers, int k, int strength, int pills) {
        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }
        for (int i = k - 1; i >= 0; i--) {
            int strongestWorker = workerMap.lastKey();
            if (tasks[i] <= strongestWorker) {
                removeWorker(workerMap, strongestWorker);
            } else if (pills > 0) {
                Integer weakerWorker = workerMap.ceilingKey(tasks[i] - strength);
                if (weakerWorker == null) {
                    return false;
                } else {
                    removeWorker(workerMap, weakerWorker);
                    pills--;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private void removeWorker(TreeMap<Integer, Integer> workerMap, int key) {
        workerMap.put(key, workerMap.get(key) - 1);
        if (workerMap.get(key) == 0) {
            workerMap.remove(key);
        }
    }
}

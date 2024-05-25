package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/the-number-of-beautiful-subsets
 * 
 * @author subhrajeetghosh
 */
public class BeautifulSubset {
    // Iterative Bruteforce Approch
    public int beautifulSubsets_2ndMethod(int[] nums, int k) {
        int resultCount = 0;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                if (!li.contains(nums[i] - k) && !li.contains(nums[i] + k)) {
                    resultCount++;
                    result.add(li);
                }
            }
        }
        return resultCount;
    }

    int target;

    public int beautifulSubsets(int[] nums, int k) {
        target = k;
        return dfs(nums, new HashMap<>(), 0) - 1;
    }

    private int dfs(int[] nums, Map<Integer, Integer> map, int index) {
        if (index >= nums.length)
            return 1;
        int res = dfs(nums, map, index + 1);
        if (!map.containsKey(nums[index] - target) && !map.containsKey(nums[index] + target)) {
            map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
            res += dfs(nums, map, index + 1);
            map.put(nums[index], map.get(nums[index]) - 1);
            if (map.get(nums[index]) == 0) {
                map.remove(nums[index]);
            }
        }
        return res;
    }
}

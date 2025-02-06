package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/tuple-with-same-product
 * 
 * @author subhrajeetghosh
 */
public class TupleWithSameProduct {
    public int tupleSameProduct(int[] nums) { // time complexity - O(n^4)
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < nums.length; k++) {
                    if (k == i || k == j)
                        continue;
                    for (int l = 0; l < nums.length; l++) {
                        if (l == i || l == j || l == k)
                            continue;
                        if (nums[i] * nums[j] == nums[k] * nums[l]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int tupleSameProduct_2ndMethod(int[] nums) { //time complexity - O(n^2)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        int result = 0;
        for(int key : map.keySet()) {
            if(map.get(key) > 1) {
                result += (map.get(key) * 2) * (map.get(key) * 2 - 2);
            }
        }
        return result;
    }
}

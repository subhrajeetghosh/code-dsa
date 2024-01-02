package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions
 * 
 * @author subhrajeetghosh
 */
public class ArrayTo2DArray {
    //Bruteforce approch
    public List<List<Integer>> findMatrix(int[] nums) { // time complexity - O(n + m * k) n is the length of the nums array,
        int[] numsCount = new int[nums.length + 1];     // m is the number of unique elements in nums, and k is the 
        for (int i = 0; i < nums.length; i++) {         // maximum frequency of any element in nums.
            numsCount[nums[i]]++;
        }
        boolean isAvail = true;
        List<List<Integer>> result = new ArrayList<>();
        while (isAvail) {
            isAvail = false;
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < numsCount.length; i++) {
                if (numsCount[i] > 0) {
                    isAvail = true;
                    list.add(i);
                    numsCount[i]--;
                }
            }
            if (!list.isEmpty()) {
                result.add(list);
            }
        }
        return result;
    }

    //optmized approch
    public List<List<Integer>> findMatrix_2ndMethod(int[] nums) {  // time complexity - O(n)
        int[] countArr = new int[nums.length + 1];
        List<List<Integer>> resultList = new ArrayList<>();
        for (int num : nums) {
            if (resultList.size() < ++countArr[num]) {
                resultList.add(new ArrayList<>());
            }
            resultList.get(countArr[num] - 1).add(num);
        }
        return resultList;
    }
}

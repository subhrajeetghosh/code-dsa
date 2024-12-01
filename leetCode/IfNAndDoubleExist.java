package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist
 * 
 * @author subhrajeetghosh
 */
public class IfNAndDoubleExist {
    public boolean checkIfExist(int[] arr) { // time complexity - O(n)
        Set<Integer> set = new HashSet<Integer>();
        set.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if ((set.contains(arr[i] * 2) || (arr[i] != 0 && arr[i] % 2 == 0 && set.contains(arr[i] / 2)))) {
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }
}

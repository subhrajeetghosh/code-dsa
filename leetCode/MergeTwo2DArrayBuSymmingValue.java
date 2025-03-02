package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values
 * 
 * @author subhrajeetghosh
 */
public class MergeTwo2DArrayBuSymmingValue {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) { // time complexity - O(n)
        int len1 = nums1.length, len2 = nums2.length, i = 0, j = 0;
        List<int[]> listArr = new ArrayList<>();
        while (i < len1 || j < len2) {
            if (i < len1 && j < len2) {
                if (nums1[i][0] == nums2[j][0]) {
                    listArr.add(new int[] { nums1[i][0], nums1[i++][1] + nums2[j++][1] });
                } else if (nums1[i][0] < nums2[j][0]) {
                    listArr.add(new int[] { nums1[i][0], nums1[i++][1] });
                } else {
                    listArr.add(new int[] { nums2[j][0], nums2[j++][1] });
                }
            } else if (i < len1) {
                listArr.add(new int[] { nums1[i][0], nums1[i++][1] });
            } else {
                listArr.add(new int[] { nums2[j][0], nums2[j++][1] });
            }
        }
        int[][] result = new int[listArr.size()][2];
        for (i = 0; i < listArr.size(); i++) {
            result[i][0] = listArr.get(i)[0];
            result[i][1] = listArr.get(i)[1];
        }
        return result;
    }
}

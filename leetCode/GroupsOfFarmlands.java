package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-groups-of-farmland
 * 
 * @author subhrajeetghosh
 */
public class GroupsOfFarmlands {
    public int[][] findFarmland(int[][] land) {
        List<int[]> groupList = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1
                        && (i == 0 || land[i - 1][j] == 0)
                        && (j == 0 || land[i][j - 1] == 0)) {
                    int i2 = i;
                    int j2 = j;
                    while (i2 < land.length && land[i2][j] == 1)
                        i2++;
                    while (j2 < land[0].length && land[i][j2] == 1)
                        j2++;
                    groupList.add(new int[] { i, j, i2 - 1, j2 - 1 });
                }
            }
        }
        return groupList.toArray(new int[0][]);
    }
}

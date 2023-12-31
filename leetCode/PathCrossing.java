package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/path-crossing/
 * 
 * @author subhrajeetghosh
 */
public class PathCrossing {
    public boolean isPathCrossing(String path) {  //time complexity - O(n)
        Set<String> set = new HashSet<String>();
        int xPoint = 0;
        int yPoint = 0;
        set.add(xPoint + "_" + yPoint);
        for (char c : path.toCharArray()) {
            if (c == 'N')
                yPoint++;
            else if (c == 'S')
                yPoint--;
            else if (c == 'E')
                xPoint++;
            else if (c == 'W')
                xPoint--;
            if (!set.add(xPoint + "_" + yPoint))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PathCrossing().isPathCrossing("NES"));
    }
}
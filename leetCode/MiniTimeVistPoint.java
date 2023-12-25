package leetCode;

/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points
 * 
 * @author Subhrajeet Ghosh
 */
public class MiniTimeVistPoint {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            int diffX = Math.abs(points[i][0] - points[i - 1][0]);
            int diffY = Math.abs(points[i][1] - points[i - 1][1]);
            ans += Math.max(diffX, diffY);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 1 }, { 3, 4 }, { -1, 0 } };
        System.out.println(new MiniTimeVistPoint().minTimeToVisitAllPoints(arr));
    }
}

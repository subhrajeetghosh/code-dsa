package leetCode;

/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points
 * 
 * @author Subhrajeet Ghosh
 */
public class MiniTimeVistPoint {
    public int minTimeToVisitAllPoints(int[][] points) {
        int currentX = points[0][0];
        int currentY = points[0][1];
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            int diffX = points[i][0] - currentX;
            int diffY = points[i][1] - currentY;
            if (diffX == 0 && diffY == 0) {
                continue;
            } else if (diffX == 0) {
                ans += Math.abs(points[i][1] - currentY);
                currentY = points[i][1];
            } else if (diffY == 0) {
                ans += Math.abs(points[i][0] - currentX);
                currentX = points[i][0];
            } else {
                if (diffX > diffY) {
                    ans += Math.abs(points[i][1] - currentY);
                    currentX += points[i][1] - currentY;
                    currentY = points[i][1];
                } else {
                    ans += Math.abs(points[i][0] - currentX);
                    currentY += points[i][0] - currentX;
                    currentX = points[i][0];
                }
                --i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1},{3,4},{-1,0}};
        new MiniTimeVistPoint().minTimeToVisitAllPoints(arr);
    }
}

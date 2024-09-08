package leetCode;

public class CountNumberOfTeams {
    public int numTeams(int[] rating) { //time complexity - O(n^2)
        int n = rating.length;
        int result = 0;
        for (int i = 1; i < n; i++) {
            int left = i - 1, right = i + 1, current = rating[i];
            int leftLessCount = 0, leftMoreCount = 0, rightLessCount = 0, rightMoreCount = 0;

            while (left >= 0) {
                if (rating[left] < current) {
                    leftLessCount++;
                } else if (rating[left] > current) {
                    leftMoreCount++;
                }
                left--;
            }
            while (right < n) {
                if (rating[right] > current) {
                    rightMoreCount++;
                } else if (rating[right] < current) {
                    rightLessCount++;
                }
                right++;
            }

            result += (leftLessCount * rightMoreCount) + (leftMoreCount * rightLessCount);
        }
        return result;
    }
}

package leetCode;

/**
 * https://leetcode.com/problems/image-smoother
 * 
 * @author Subhrajeet Ghosh
 */
public class ImageSmoother {
    //BruteForce Approch
    public int[][] imageSmoother(int[][] img) {  // time complexity - O(m*n)
        int[][] average = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int count = 1;
                int sum = img[i][j];
                if (isValid(i - 1, j - 1, img)) {
                    sum += img[i - 1][j - 1];
                    count++;
                }
                if (isValid(i - 1, j, img)) {
                    sum += img[i - 1][j];
                    count++;
                }
                if (isValid(i - 1, j + 1, img)) {
                    sum += img[i - 1][j + 1];
                    count++;
                }
                if (isValid(i, j - 1, img)) {
                    sum += img[i][j - 1];
                    count++;
                }
                if (isValid(i, j + 1, img)) {
                    sum += img[i][j + 1];
                    count++;
                }
                if (isValid(i + 1, j - 1, img)) {
                    sum += img[i + 1][j - 1];
                    count++;
                }
                if (isValid(i + 1, j, img)) {
                    sum += img[i + 1][j];
                    count++;
                }
                if (isValid(i + 1, j + 1, img)) {
                    sum += img[i + 1][j + 1];
                    count++;
                }
                average[i][j] = (int) Math.floor(sum / count);
            }
        }
        return average;
    }

    private boolean isValid(int i, int j, int[][] img) {
        return i >= 0 && j >= 0 && i < img.length && j < img[0].length;
    }
}

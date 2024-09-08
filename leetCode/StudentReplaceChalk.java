package leetCode;

/**
 * https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk
 * 
 * @author subhrajeetghosh
 */
public class StudentReplaceChalk {
    public int chalkReplacer_2ndMethod(int[] chalk, int k) { // time complexity - O(n*m) (chalk.length * loop.count)
        int index = 0;
        while (k >= chalk[index]) {
            k -= chalk[index++];
            if (index == chalk.length)
                index = 0;
        }
        return index;
    }

    public int chalkReplacer(int[] chalk, int k) { // time complexity - O(n)
        int index = 0;
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        int rem = (int) ((long) k % sum);
        while (rem >= chalk[index]) {
            rem -= chalk[index++];
            if (index == chalk.length)
                index = 0;
        }
        return index;
    }
}

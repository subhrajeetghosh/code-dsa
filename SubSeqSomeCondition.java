import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * {@link} https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 * 
 * @author Subhrajeet Ghosh
 */
public class SubSeqSomeCondition {

    // Brute Force
    public int numSubseq(int[] nums, int target) {
        int count = 0;
        int modulo = 1000000007;
        List<TreeSet<Integer>> list = new ArrayList<>();
        list.add(new TreeSet<>());
        for (int i = 0; i < nums.length; i++) {
            int len = list.size();
            for (int j = 0; j < len; j++) {
                TreeSet<Integer> ls = new TreeSet<>(list.get(j));
                ls.add(nums[i]);
                list.add(ls);
                if (ls.first() + ls.last() <= target) {
                    count++;
                }
            }
            count %= modulo;
        }
        return count;
    }

    // Optimized approched
    public int numSubseq_2ndMethod(int[] nums, int target) {
        int count = 0;
        int modulo = 1_000_000_007;
        int len = nums.length;
        Arrays.sort(nums);
        int[] pow = new int[len];
        pow[0] = 1;
        for (int i = 1; i < len; i++) {
            pow[i] = (pow[i - 1] * 2) % modulo;
        }
        for (int i = 0; i < len; i++) {
            int j = len - 1;
            while (i <= j) {
                if (nums[i] + nums[j] <= target) {
                    count += pow[j - i];
                    break;
                } else {
                    j--;
                }
            }
            count %= modulo;
        }
        return count;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new SubSeqSomeCondition().numSubseq(new int[] { 3, 5, 6, 7 }, 9));
    }
}

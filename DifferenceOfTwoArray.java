import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceOfTwoArray {
    // Brute Force
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> li1 = new HashSet<>();
        Set<Integer> li2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            set2.add(nums2[j]);
            if (!set1.contains(nums2[j])) {
                li2.add(nums2[j]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if (!set2.contains(nums1[i])) {
                li1.add(nums1[i]);
            }
        }
        List<List<Integer>> listOfReturn = new ArrayList<>();
        listOfReturn.add(List.copyOf(li1));
        listOfReturn.add(List.copyOf(li2));
        return listOfReturn;
    }

    public List<List<Integer>> findDifference_2ndMethod(int[] nums1, int[] nums2) {
        return Arrays.asList(getUniqueList(nums1, nums2), getUniqueList(nums2, nums1));
    }

    public List<Integer> getUniqueList(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> onlyInNums1 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (!set.contains(nums1[i])) {
                onlyInNums1.add(nums1[i]);
            }
        }
        return new ArrayList<>(onlyInNums1);
    }
}

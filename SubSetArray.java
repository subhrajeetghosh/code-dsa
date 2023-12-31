import java.util.ArrayList;
import java.util.List;

/**
 * @link - https://leetcode.com/problems/subsets
 * 
 * @author subhrajeetghosh
 */

public class SubSetArray {
    // Brute Force Approch
    public List<List<Integer>> subSetList(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int j = 0; j < arr.length; j++) {
            int len = list.size();
            for (int k = 0; k < len; k++) {
                List<Integer> newList = new ArrayList<>(list.get(k));
                newList.add(arr[j]);
                list.add(newList);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> subSet = new SubSetArray().subSetList(new int[] { 2, 3, 5 });
        for (List<Integer> listOfInterger : subSet) {
            for (int number : listOfInterger) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}

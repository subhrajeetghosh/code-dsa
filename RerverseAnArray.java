/**
 * Given a list, sort it using this method: reverse(lst, i, j), which reverses
 * lst from i to j.
 * {@link https://www.dailycodingproblem.com}
 * 
 * @author Subhrajeet Ghosh
 */
public class RerverseAnArray {
    public int[] reverse(int[] arr, int i, int j) {
        i--;
        j--;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}

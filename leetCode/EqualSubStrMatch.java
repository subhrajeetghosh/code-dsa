package leetCode;

/**
 * 
 * @author subhrajeetghosh
 */
public class EqualSubStrMatch {
    // using array
    public int equalSubstring_2ndMethod(String s, String t, int maxCost) { // time complexity - O(n)
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int i = 0, j = 0;
        int currentSum = 0;
        int result = 0;
        while (j < s.length()) {
            if (currentSum <= maxCost) {
                currentSum += arr[j];
                j++;
            } else if (currentSum > maxCost && j > i) {
                currentSum -= arr[i];
                i++;
            } else {
                break;
            }
            result = currentSum <= maxCost ? Math.max(result, j - i) : result;
        }
        return result;
    }

    // without using extra space
    public int equalSubstring(String s, String t, int maxCost) { // time complexity - O(n)
        int i = 0, j = 0, currentSum = 0, result = 0;
        while (j < t.length()) {
            currentSum += Math.abs(s.charAt(j) - t.charAt(j));
            while (currentSum > maxCost) {
                currentSum -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            j++;
            result = Math.max(result, j - i);
        }
        return result;
    }
}

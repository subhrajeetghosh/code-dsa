package leetCode;
import java.util.Arrays;

public class DecodeWays {

    // Bruteforce way with recursion
    int count = 0;

    public int decodeStringWays(String s) {
        // recForCount(s, 0);
        int[] arr = new int[s.length()];
        Arrays.fill(arr, -1);
        memorizationOnRecursionForCount(s, 0, arr);
        return arr[0];
    }

    public void recForCount(String s, int start) {
        if (start == s.length()) {
            count++;
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i - start <= 1) {
                String subString = s.substring(start, i + 1);
                if (Integer.parseInt(subString) >= 1 && Integer.parseInt(subString) < 27
                        && subString.charAt(0) != '0') {
                    recForCount(s, i + 1);
                }
            }
        }
    }

    // Second recursive method

    public void recForCountSecondMethod(String s, int start) {
        if (s.length() <= start) {
            count++;
            return;
        }
        int num = s.charAt(start) - '0';
        if (num == 0) {
            return;
        }
        if (start <= s.length() - 2) {
            int secondNum = Integer.parseInt(s.substring(start, start + 2));
            if (secondNum < 27 && secondNum >= 10) {
                recForCountSecondMethod(s, start + 2);
            }
        }
        recForCountSecondMethod(s, start + 1);
    }

    // Memorization Solution

    public int memorizationOnRecursionForCount(String s, int start, int[] arr) {
        if (s.length() == start) {
            return 1;
        }
        if (s.length() < start) {
            return 0;
        }
        if (arr[start] != -1) {
            return arr[start];
        }
        if (s.charAt(start) == '0') {
            return arr[start] = 0;
        }
        boolean isSecondNumValid = false;
        if (start <= s.length() - 2) {
            int secondNum = Integer.parseInt(s.substring(start, start + 2));
            if (secondNum < 27 && secondNum >= 10) {
                isSecondNumValid = true;
                arr[start] = memorizationOnRecursionForCount(s, start + 1, arr)
                        + memorizationOnRecursionForCount(s, start + 2, arr);
            }
        }
        if (!isSecondNumValid) {
            arr[start] = memorizationOnRecursionForCount(s, start + 1, arr);
        }
        return arr[start];
    }

    public static void main(String[] args) {
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.decodeStringWays("121"));
    }
}

/*
 * Dynamic Problem
 * https://leetcode.com/problems/decode-ways/
 * 
 * @author subhrajeetghosh
 */
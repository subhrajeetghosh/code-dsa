public class DecodeWays {

    // Bruteforce way with recursion
    int count = 0;

    public int decodeStringWays(String s) {
        // recForCount(s, 0);
        recForCountSecondMethod(s, 0);
        return count;
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
        boolean isSecondNumValid = false;
        if (start <= s.length() - 2) {
            int secondNum = Integer.parseInt(s.substring(start, start + 2));
            if (secondNum < 27 && secondNum >= 10) {
                isSecondNumValid = true;
                recForCountSecondMethod(s, start + 1);
                recForCountSecondMethod(s, start + 2);
            }
        }
        if (!isSecondNumValid) {
            recForCountSecondMethod(s, start + 1);
        }
    }

    // Memorization

    public int memorizationOnRecursionForCount(String s, int start, int[] arr) {
        if (s.length() >= start) {
            return 0;
        }
        if (arr[start] != -1)
            return arr[start];
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
 */
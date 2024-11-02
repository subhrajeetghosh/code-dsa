package leetCode;

import java.util.Stack;

public class MinStrRemoverSubStr {
    public int minLength_2ndMethod(String s) { // time complexity - O(n^2)
        while (true) {
            if (s.indexOf("AB") != 0) {
                s = s.replace("AB", "");
            } else if (s.indexOf("CD") != 0) {
                s = s.replace("CD", "");
            } else {
                break;
            }
        }
        return s.length();
    }

    public int minLength_3rdMethod(String s) { // time complexity - O(n)
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == 'B' && stack.peek() == 'A' || c == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public int minLength(String s) { // time complexity - O(n)
        char[] charArr = s.toCharArray();
        int writePtr = 0, frontPtr = 0;
        for (int i = 0; i < s.length(); i++) {
            charArr[writePtr] = charArr[frontPtr];
            if (writePtr > 0 && ((charArr[writePtr - 1] == 'A' || charArr[writePtr - 1] == 'C') &&
                    charArr[writePtr] == charArr[writePtr - 1] + 1)) {
                writePtr--;
            } else {
                writePtr++;
            }
            frontPtr++;
        }
        return writePtr;
    }
}

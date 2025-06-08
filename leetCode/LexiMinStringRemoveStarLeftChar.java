package leetCode;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars
 * 
 * @author subhrajeetghosh
 */
public class LexiMinStringRemoveStarLeftChar {
    class Status {
        char ch;
        int index;

        public Status(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    public String clearStars(String s) { // time complexity - O(n log n)
        PriorityQueue<Status> pq = new PriorityQueue<>((a, b) -> {
            if (a.ch != b.ch) {
                return a.ch - b.ch;
            } else {
                return b.index - a.index;
            }
        });
        char[] chArr = s.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == '*') {
                if (!pq.isEmpty()) {
                    Status pollStatus = pq.poll();
                    chArr[pollStatus.index] = '0';
                }
                chArr[i] = '0';
            } else {
                pq.add(new Status(chArr[i], i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : chArr) {
            if (ch != '0') {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public String clearStars_2ndMethod(String s) { // time complexity - O(n * k)
        Stack<Integer>[] count = new Stack[26];
        for (int i = 0; i < 26; i++) {
            count[i] = new Stack<>();
        }
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (array[i] == '*') {
                for (int j = 0; j < 26; j++) {
                    if (!count[j].isEmpty()) {
                        array[count[j].pop()] = '*';
                        break;
                    }
                }
            } else {
                count[array[i] - 'a'].push(i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : array) {
            if (ch != '*') {
                result.append(ch);
            }
        }
        return result.toString();
    }
}

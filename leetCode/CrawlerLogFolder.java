package leetCode;

/**
 * https://leetcode.com/problems/crawler-log-folder
 * 
 * @author subhrajeetghosh
 */
public class CrawlerLogFolder {
    public int minOperations(String[] logs) { // time complexity - O(n)
        int count = 0;
        for (String str : logs) {
            if (str.equals("../")) {
                if (count > 0)
                    count--;
            } else if (!str.equals("./")) {
                count++;
            }
        }
        return count;
    }
}

/**
 * https://leetcode.com/problems/add-digits/
 * 
 * @author Subhrajeet Ghosh
 */
public class AddDigit {
    public int addDigits(int num) {
        while(num/10 != 0) {
            int dummyNum = 0;
            while(num > 0) {
                dummyNum += num%10;
                num /= 10;
            }
            num = dummyNum;
        }
        return num;
    }
}

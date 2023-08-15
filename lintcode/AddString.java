package lintcode;

public class AddString {
    public String addStrings(String num1, String num2) {
        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;
        StringBuilder sum = new StringBuilder();
        int keep = 0;
        while (num1Length >= 0 && num2Length >= 0) {
            int currentNum = ((num1.charAt(num1Length) - '0') + (num2.charAt(num2Length) - '0')) + keep;
            keep = 0;
            if (currentNum > 9) {
                keep = currentNum / 10; // just can make keep as 1
            }
            sum.append(currentNum % 10);
            num1Length--;
            num2Length--;
        }
        if (num1Length >= 0) {
            sum = getSumOfString(num1Length, num1, sum, keep);
        } else if (num2Length >= 0) {
            sum = getSumOfString(num2Length, num2, sum, keep);
        } else if (keep > 0) {
            sum.append(keep);
        }
        return sum.reverse().toString();
    }

    private StringBuilder getSumOfString(int index, String num, StringBuilder sum, int keep) {
        while (index >= 0) {
            if (keep > 0) {
                int currentNum = ((num.charAt(index) - '0') + keep);
                if (currentNum > 9) {
                    keep = currentNum / 10;
                    currentNum %= 10; // just can make keep as 1
                } else {
                    keep = 0;
                }
                sum.append(currentNum);
            } else {
                sum.append(num.charAt(index) - '0');
            }
            index--;
        }
        if (keep != 0) {
            sum.append(keep);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new AddString().addStrings("9999999999981", "19"));
    }
}

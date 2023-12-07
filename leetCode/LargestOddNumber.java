package leetCode;

public class LargestOddNumber {
    public String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder(num);
        while (!sb.isEmpty()) {
            if (sb.charAt(sb.length() - 1) % 2 != 0) {
                break;
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    // 2nd method with time optimization
    public String largestOddNumber_2ndMethod(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new LargestOddNumber().largestOddNumber("23456"));
    }
}

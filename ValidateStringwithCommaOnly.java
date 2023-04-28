import java.util.Arrays;
import java.util.List;

public class ValidateStringwithCommaOnly {
    public static boolean isValid(String str) {
        String regex = "^\\d+(\\s*,\\s*\\d+)*$";

        return str.matches(regex);
    }

    public static void returnListOfStringFromString(String str) {
        List<String> ls = Arrays.asList(str.split("\\s*,\\s*"));
        
        for (String string : ls) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        returnListOfStringFromString("24,  324, 2335 , 123,214");
        System.out.println(isValid("24,  324, 2335 , 123,214"));
    }
}

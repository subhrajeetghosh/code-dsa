package miscellaneous;
import java.util.regex.Pattern;

/**
 * Helper class to verify and fetch a certain type of string which will have
 * only number seperated by comma condition on it
 * 
 * @author subhrajeetghosh
 */
public class ValidateStringwithCommaOnly {
    public static boolean isValid(String str) {
        String regex = "^\\s*[a-zA-Z0-9]+(?:\\s*,\\s*[a-zA-Z0-9]+)*\\s*$";

        return str.matches(regex);
    }

    public static void returnListOfStringFromString(String str) {
        String[] ls = Pattern.compile("\\s*,\\s*")
                .splitAsStream(str)
                .map(String::trim)
                .toArray(String[]::new);

        System.out.println(ls.length);

        for (String string : ls) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        returnListOfStringFromString("2342");
        System.out.println(isValid("kjnfs4342, SFSD54353, 53453"));
    }
}

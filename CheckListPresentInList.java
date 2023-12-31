import java.util.Arrays;
import java.util.List;

/**
 * test list fetures in java
 * 
 * @author subhrajeetghosh
 */
public class CheckListPresentInList {
    public static void main(String[] args) {
        List<String> aList = Arrays.asList("abc", "bcd");
        List<String> bList = Arrays.asList("5325", "abc");

        System.out.println(
                aList.stream().anyMatch(elementA -> bList.stream()
                        .anyMatch(elementB -> elementA.contains(elementB))));
    }
}

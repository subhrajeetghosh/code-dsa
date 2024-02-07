import java.util.Map;
import java.util.TreeMap;

public class TestClass {

    public void testTreeMap() {
        Map<Integer, StringBuilder> map = new TreeMap<>();
        map.computeIfAbsent(5, k -> new StringBuilder()).append(String.valueOf(9).repeat(8));
        map.computeIfAbsent(5, k -> new StringBuilder()).append(String.valueOf(10).repeat(8));
        System.out.println(map.get(5));
    }

    public static void main(String args[]) throws Exception {
        new TestClass().testTreeMap();
    }
}

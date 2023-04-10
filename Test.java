import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> li = new ArrayList<>();
        li.add("123");
        System.out.println(li.contains("1"));
        /*var timeStamp = "${__time(yyyy-MM-dd'T'HH:mm:ss'Z')}";
        System.out.println("\n{\n"+" \"userDisplayName\": \"Retry After[time in Hrs]\",\n \"paramValueChar\": \"\"\n},\n"+
        "{\n"+" \"userDisplayName\": \"Error Message Like\",\n \"paramValueChar\": \"\"\n},\n");*/
    }
}
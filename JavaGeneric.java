
import java.util.*;

public class JavaGeneric {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<Object> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add("Hello");
        arr.add("World");
        arr.stream().forEach(System.out::println);
    }
}

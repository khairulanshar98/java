
import java.util.*;
import java.util.regex.*;

public class JavaTagPattern {

    private static final String reg = "<([^<>]+)>([^<>]+)</\\1>";
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try (in) {
            int testCases = Integer.parseInt(in.nextLine());
            Pattern pattern = Pattern.compile(reg);
            while (testCases-- > 0) {
                String line = in.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (!matcher.find()) {
                    System.out.println("None");
                } else {
                    System.out.println(matcher.group(2));
                    while (matcher.find()) {
                        System.out.println(matcher.group(2));
                    }
                }
            }
        } finally {
            in.close();
        }
    }
}

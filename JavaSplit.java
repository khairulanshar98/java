
import java.util.*;

public class JavaSplit {

    private final static String delimeter = "[\\s!,?._'@]+";
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            String s = scan.nextLine();
            // Write your code here.
            if (s.trim().length() == 0) {
                System.out.println(0);
            } else {
                String[] arrs = s.trim().split(delimeter);
                System.out.println(arrs.length);
                for (String a : arrs) {
                    System.out.println(a);
                }
            }
        } finally {
            scan.close();
        }
    }
}

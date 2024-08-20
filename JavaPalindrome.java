
import java.util.*;

public class JavaPalindrome {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try (sc) {
            String A = sc.next();
            /* Enter your code here. Print output to STDOUT. */
            String isPali = "Yes";
            int length = A.length();
            int middle = (int) (length / 2);

            for (int i = 0; i <= middle; i++) {
                String front = A.substring(i, i + 1);
                int l = length - 1 - i;
                String end = A.substring(l, l + 1);
                if (!front.equalsIgnoreCase(end)) {
                    isPali = "No";
                    break;
                }
            }
            System.out.println(isPali);
        } finally {
            sc.close();
        }
    }
}


import java.util.*;

public class JavaSubstring {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try (in) {
            String S = in.next();
            int start = in.nextInt();
            int end = in.nextInt();
            System.out.println(S.substring(start, end));
        } finally {
            in.close();
        }
    }
}

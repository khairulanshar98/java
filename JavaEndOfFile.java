
import java.util.*;

public class JavaEndOfFile {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try (sc) {
            int count = 0;
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                count++;
                System.out.println(count + " " + str);
            }
        } finally {
            sc.close();
        }
    }
}

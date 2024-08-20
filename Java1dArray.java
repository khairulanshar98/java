
import java.util.*;

public class Java1dArray {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            int n = scan.nextInt();
            int[] a = new int[n];
            int j = 0;
            while (scan.hasNextInt()) {
                a[j] = scan.nextInt();
                j++;
            }
            // Prints each sequential element in array a
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        } finally {
            scan.close();
        }
    }
}

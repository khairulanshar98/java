
import java.math.*;
import java.util.*;

public class JavaBigInteger {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            BigInteger a = scan.nextBigInteger();
            BigInteger b = scan.nextBigInteger();
            System.out.println("" + a.add(b));
            System.out.println("" + a.multiply(b));
        } finally {
            scan.close();
        }
    }
}


import java.math.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

public class JavaPrimeChecker {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            List<String> arr = new ArrayList<>();
            IntStream.range(0, 5).forEach(i -> {
                BigInteger x = scan.nextBigInteger();
                if (x.isProbablePrime(10)) {
                    arr.add(x.toString());
                }
                if (i != 3) {
                    System.out.println(arr.stream().collect(joining(" ")));
                }
            });
        } finally {
            scan.close();
        }
    }
}

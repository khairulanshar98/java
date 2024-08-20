
import java.io.*;
import java.math.*;
import java.util.*;

public class JavaIsPrime {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (scan) {
            BigInteger bi = scan.nextBigInteger();
            System.out.println(bi.isProbablePrime(10) ? "prime" : "not prime");
        } finally {
            scan.close();
        }
    }
}

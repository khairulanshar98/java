import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class JavaIsPrime {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BigInteger bi = scan.nextBigInteger();
        System.out.println(bi.isProbablePrime(10) ? "prime" : "not prime");
        scan.close();
    }
}

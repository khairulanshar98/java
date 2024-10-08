
import java.io.*;
import java.util.*;

interface PerformOperation {

    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public static PerformOperation isPalindrome() {
        return (int a) -> {
            String str = Integer.toString(a);
            String reverseStr = new StringBuilder(str).reverse().toString();
            return str.equals(reverseStr);
        };
    }

    public static PerformOperation isPrime() {
        return (int a) -> {
            java.math.BigInteger aa = new java.math.BigInteger(a + "");
            return aa.isProbablePrime(10);
        };
    }

    public static PerformOperation isOdd() {
        return (int a) -> {
            return a % 2 > 0;
        };
    }
}
// Write your code here

public class JavaLambda {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

import java.io.*;
import java.util.*;

public class JavaBitSet {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int N = scan.nextInt();
        int M = scan.nextInt();
        BitSet[] B = new BitSet[] {new BitSet(N), new BitSet(N)};
        while (M-- >0) {
            scan.nextLine(); // skip to next line
            String op = scan.next();
            int m = scan.nextInt();
            int n = scan.nextInt();
            // System.out.println(op+" "+m+" "+n);
            int x = 0;
            int y = 1;
            if (m == 2) {
                x = 1;
                y = 0;
            }
            switch(op) {
                case "AND": 
                    B[x].and(B[y]);
                    break;
                case "OR": 
                    B[x].or(B[y]);
                    break;
                case "XOR": 
                    B[x].xor(B[y]);
                    break;
                case "FLIP": 
                    B[x].flip(n);
                    break;
                case "SET": 
                    B[x].set(n);
                    break;
            }
            System.out.printf("%d %d\n",B[0].cardinality(), B[1].cardinality());
        }
        scan.close();
    }
}
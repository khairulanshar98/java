import java.io.*;
import java.util.*;
import java.util.stream.*;

public class JavaArraylist {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = scan.nextInt();
        List<List<Integer>> arrList = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            int d = scan.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0;j<d;j++){
                arr.add(scan.nextInt());
            }
            arrList.add(arr);
        }
        n = scan.nextInt();
        for(int i=0;i<n;i++){
            int x = scan.nextInt()-1;
            int y = scan.nextInt()-1;
            try {
                System.out.println(arrList.get(x).get(y));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
        scan.close();
    }
}
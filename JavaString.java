import java.io.*;
import java.util.*;

public class JavaString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(""+(A.length()+B.length()));
        String valid = "No";
        if (A.compareTo(B)>0) {
            valid="Yes";
        }
        System.out.println(valid);
        String A_cap = A.substring(0,1).toUpperCase() + A.substring(1);
        String B_cap = B.substring(0,1).toUpperCase() + B.substring(1);
        System.out.println(A_cap.concat(" ").concat(B_cap));
    }
}

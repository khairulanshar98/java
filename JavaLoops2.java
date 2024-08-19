import java.util.*;
import java.io.*;

class JavaLoops2{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            String result = "";
            for (int l=0;l<n;l++){
                int power = (int) Math.pow(2,l);
                a += power * b;
                result = result.concat(a+" ");
            }
            System.out.println(result.trim());
        }
        in.close();
    }
}
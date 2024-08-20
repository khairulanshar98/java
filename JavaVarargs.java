
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import static java.util.stream.Collectors.joining;
//Write your code here

class Add {

    public Add() {
    }

    public void add(int... args) {
        int sum = Arrays.stream(args).sum();
        String result = Arrays.stream(args).mapToObj(i -> i + "").collect(joining("+")).concat("=").concat("" + sum);
        System.out.println(result);
    }
}

public class JavaVarargs {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());
            Add ob = new Add();
            ob.add(n1, n2);
            ob.add(n1, n2, n3);
            ob.add(n1, n2, n3, n4, n5);
            ob.add(n1, n2, n3, n4, n5, n6);
            Method[] methods = Add.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (Method method : methods) {
                if (set.contains(method.getName())) {
                    overload = true;
                    break;
                }
                set.add(method.getName());
            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
        }
    }

}

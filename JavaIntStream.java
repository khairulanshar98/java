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

public class JavaIntStream {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /*List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, 6).forEach(i -> {
            String child = scan.nextLine().replaceAll("\\s+$", "");
            arr.add(
                    Stream.of(child.split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
        });*/
        List<List<Integer>> arr = IntStream.range(0, 6).mapToObj(i -> {
            String child = scan.nextLine().replaceAll("\\s+$", "");
            return Stream.of(child.split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
        }).collect(toList());
        int maxSum = IntStream.range(0, 4).map(row -> {
            return IntStream.range(0, 4).map(column -> {
                return arr.get(row).get(column)+
                          arr.get(row).get(column+1)+
                          arr.get(row).get(column+2)+
                          arr.get(row+1).get(column+1)+
                          arr.get(row+2).get(column)+
                          arr.get(row+2).get(column+1)+
                          arr.get(row+2).get(column+2);
            })
            .max()
            .orElse(0);
        })
        .max()
        .orElse(0);
        System.out.println(maxSum);
        scan.close();
    }
}

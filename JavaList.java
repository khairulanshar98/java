
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class JavaList {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            int N = scan.nextInt();
            scan.nextLine();
            String s = scan.nextLine().replaceAll("\\s+$", "");
            List<Integer> arr = Stream.of(s.split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
            int Q = scan.nextInt();
            IntStream.range(0, Q).forEach(i -> {
                scan.nextLine();
                String command = scan.nextLine();
                int index = scan.nextInt();
                if (command.equalsIgnoreCase("Insert")) {
                    int value = scan.nextInt();
                    arr.add(index, value);
                } else {
                    arr.remove(index);
                }
            });
            String result = arr.stream().map(i -> "" + i).collect(joining(" "));
            System.out.println(result);
        } finally {
            scan.close();
        }
    }
}

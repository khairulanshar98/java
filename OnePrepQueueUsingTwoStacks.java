
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class OnePrepQueueUsingTwoStacks {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try (scan) {
            int n = scan.nextInt();
            scan.nextLine();
            Deque deque = new ArrayDeque<>();
            while (scan.hasNext()) {
                String line = scan.nextLine().replaceAll("\\s+$", "");
                List<Integer> arr = Stream.of(line.split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                //System.err.println(arr);
                int command = arr.get(0);
                switch (command) {
                    case 1 ->
                        deque.addLast(arr.get(1));
                    case 2 ->
                        deque.removeFirst();
                    case 3 ->
                        System.out.println(deque.getFirst());
                }
            }
        } finally {
            scan.close();
        }
    }
}

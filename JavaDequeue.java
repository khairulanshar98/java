
import java.util.*;

public class JavaDequeue {

    private static final Scanner scan = new Scanner(System.in);

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (scan) {
            @SuppressWarnings("rawtypes")
            Deque deque = new ArrayDeque<>();
            HashSet<Integer> set = new HashSet<>();
            int n = scan.nextInt();
            int m = scan.nextInt();
            int max = 0;

            for (int i = 0; i < n; i++) {
                int num = scan.nextInt();
                deque.addLast(num);
                set.add(num);
                if (deque.size() == m) {
                    if (set.size() > max) {
                        max = set.size();
                    }
                    int first = (int) deque.removeFirst();
                    if (!deque.contains(first)) {
                        set.remove(first);
                    }
                }
            }
            System.out.println(max);
        } finally {
            scan.close();
        }
    }
}

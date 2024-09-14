
import java.util.*;

public class OnePrepTextEditor {

    private static final Scanner scan = new Scanner(System.in);

    static String append(String s, String ss) {
        return s.concat(ss);
    }

    static String delete(String s, int index) {
        return s.substring(0, s.length() - index);
    }

    static void print(String s, int index) {
        System.out.println(s.charAt(index - 1));
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try (scan) {
            String result = "";
            //Stack<String> order = new Stack<>(); 
            Deque<String> order = new ArrayDeque<>();
            int n = scan.nextInt();
            while (scan.hasNext()) {
                int ops = scan.nextInt();
                if (ops < 3) {
                    //order.push(result);
                    order.addLast(result);
                }
                switch (ops) {
                    case 1 ->
                        result = append(result, scan.next());
                    case 2 ->
                        result = delete(result, scan.nextInt());
                    case 3 ->
                        print(result, scan.nextInt());
                    case 4 -> {
                        //result = order.pop();
                        result = order.removeLast();
                    }
                }
            }
        } finally {
            scan.close();
        }
    }
}

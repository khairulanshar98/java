
import java.util.*;

class JavaStack {

    private static Map<Character, Character> braketsMap = new HashMap<>();
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] argh) {
        braketsMap.put('{', '}');
        braketsMap.put('(', ')');
        braketsMap.put('[', ']');
        try (sc) {
            while (sc.hasNext()) {
                String input = sc.next();
                //Complete the code
                System.out.println(isBalanced(input));
            }
        } finally {
            sc.close();
        }
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (braketsMap.containsKey(ch)) {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (ch != braketsMap.get(last)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

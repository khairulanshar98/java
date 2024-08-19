import java.util.*;
class Solution{
	private static Map<Character, Character> braketsMap = new HashMap<>();
       
	public static void main(String []argh)
	{
        braketsMap.put('{', '}');
        braketsMap.put('(', ')');
        braketsMap.put('[', ']');
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            System.out.println(isBalanced(input));
		}
		
	}
    public static boolean isBalanced(String s) {        
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
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

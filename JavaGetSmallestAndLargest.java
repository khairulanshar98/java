import java.util.Scanner;

public class JavaGetSmallestAndLargest {
    public static String getSmallestAndLargest(String s, int k) {
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        java.util.ArrayList<String> a = new java.util.ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+k; j<=s.length(); j+=s.length()) {
                String curr = s.substring(i,j);
                System.out.println(curr);
                a.add(curr);
            }
        }
        java.util.Collections.sort(a);
        String smallest = a.get(0);
        String largest = a.get(a.size() - 1);
        return smallest + "\n" + largest;
    }

    public static String getSmallestAndLargest2(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for (int i=0;i<s.length();i++){
            if (i+k<=s.length()) {
                String curr = s.substring(i,i+k);
                if (i==0) {
                    smallest = curr;
                    largest = curr;
                } else {
                    if (smallest.compareTo(curr)>0) {
                        smallest = curr;
                    }
                    if (curr.compareTo(largest)>0) {
                        largest = curr;
                    }
                }
            }
        }
        
        return smallest + "\n" + largest;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
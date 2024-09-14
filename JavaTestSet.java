
import java.util.*;

public class JavaTestSet {

    public static boolean isPali(String s) {
        String reverseStr = new StringBuilder(s).reverse().toString();
        return s.equals(reverseStr);
    }

    public static int palindromeIndex(String s) {
        // if (s.length() <= 2) {
        //     return -1;
        // }
        for (int x = 0; x < s.length() / 2; x++) {
            if (s.charAt(x) != s.charAt(s.length() - 1 - x)) {
                if (s.charAt(x + 1) == s.charAt(s.length() - 1 - x) && s.charAt(x + 2) == s.charAt(s.length() - 2 - x)) {
                    return x;
                }
                if (s.charAt(x) == s.charAt(s.length() - 2 - x)) {
                    return s.length() - x - 1;
                }
            }
        }
        return -1;
        // Complete this function
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println("s.length" + s.length());
        // String s = "sa";
        // if (isPali(s)) {
        //     s = "";
        // }
        // int ii = -1;
        // for (int i = 0; i < s.length(); i++) {
        //     StringBuilder sb = new StringBuilder(s);
        //     sb.deleteCharAt(i);
        //     String resultString = sb.toString();
        //     if (isPali(resultString)) {
        //         System.out.println(resultString);
        //         ii = i;
        //         break;
        //     }
        // }
        // System.out.println(ii);
        // System.out.println(palindromeIndex(s));

        Set<Integer> a = new HashSet<Integer>();
        // Adding all elements to List 
        a.addAll(Arrays.asList(
                new Integer[]{1}));
        System.out.println(a);
        // System.out.println(a);
        // List<Double> arr1 = IntStream.range(0, 3).mapToObj(i -> Double.parseDouble("" + (i))).collect(toList());
        // System.err.println(arr1);
        // arr1.sort((Double aa, Double bb) -> bb.compareTo(aa));
        // System.err.println(arr1);
        // String assss = "aaaadd";
        // boolean isExists = assss.contains("AM");
        // assss = assss.replace("AM", "");
        // List<List<Integer>> matrix = new ArrayList();
        List<Integer> row = new ArrayList();
        row.add(112);
        row.add(42);
        row.add(83);
        row.add(119);
        int iix = (int) row.get(1);
        // matrix.add(row);
        // row = new ArrayList();
        // row.add(56);
        // row.add(125);
        // row.add(56);
        // row.add(49);
        // matrix.add(row);
        // row = new ArrayList();
        // row.add(15);
        // row.add(78);
        // row.add(101);
        // row.add(43);
        // matrix.add(row);
        // row = new ArrayList();
        // row.add(62);
        // row.add(98);
        // row.add(114);
        // row.add(108);
        // matrix.add(row);
        // System.out.println(matrix);
        // int n = matrix.size(), i = 1, j = 1, jj = 4 - 1 - j, ii = 4 - 1 - i;
        // int a = matrix.get(i).get(j),
        //         b = matrix.get(i).get(jj),
        //         c = matrix.get(ii).get(j),
        //         d = matrix.get(ii).get(jj),
        //         e = Math.max(matrix.get(i).get(j),
        //                 Math.max(matrix.get(i).get(n - 1 - j),
        //                         Math.max(matrix.get(n - 1 - i).get(j), matrix.get(n - 1 - i).get(n - 1 - j))));
        // System.out.println("a:" + a);
        // System.out.println("b:" + b);
        // System.out.println("c:" + c);
        // System.out.println("d:" + d);
        // System.out.println("max:" + e);
    }
}

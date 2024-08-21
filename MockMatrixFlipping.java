
import java.util.*;
import java.util.stream.*;

public class MockMatrixFlipping {

    public int flippingMatrix(List<List<Integer>> matrix) {
        int sum = 0;
        int n = matrix.size();

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                sum += Math.max(matrix.get(i).get(j),
                        Math.max(matrix.get(i).get(n - 1 - j),
                                Math.max(matrix.get(n - 1 - i).get(j), matrix.get(n - 1 - i).get(n - 1 - j))));
            }
        }
        return sum;
    }

    public static int flippingMatrix2(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size();
        int l = (n / 2);
        List<Integer> result = new ArrayList<>();
        IntStream.range(0, l).forEach(i -> {
            int ii = n - 1 - i;
            IntStream.range(0, l).forEach(j -> {
                int jj = n - 1 - j;
                Integer a = matrix.get(i).get(j);
                Integer b = matrix.get(i).get(jj);
                Integer c = matrix.get(ii).get(j);
                Integer d = matrix.get(ii).get(jj);
                Integer max = Math.max(c, d);
                max = Math.max(max, b);
                max = Math.max(max, a);
                result.add(max);
            });
        });
        return result.stream().reduce(0, Integer::sum);
    }

}
/*
i<-0
j<-0
jj<- n - 1 - j = 4 - 1 - 0 = 3
ii<- n - 1 - i = 4 - 1 - 0 = 3

a = matrix.get(0).get(0),
b = matrix.get(0).get(3),
c = matrix.get(3).get(0),
d = matrix.get(3).get(3),

a:112
b:119
c:62
d:108
max:119

 */

 /*
 i<-0
 j<-1
 jj<- n - 1 - j = 4 - 1 - 1 = 2
 ii<- n - 1 - i = 4 - 1 - 0 = 3
 
a = matrix.get(0).get(1),
b = matrix.get(0).get(2),
c = matrix.get(3).get(1),
d = matrix.get(3).get(2),

a:42
b:83
c:98
d:114
max:114

 */

 /*
 i<-1
 j<-0
 jj<- n - 1 - j = 4 - 1 - 0 = 3
 ii<- n - 1 - i = 4 - 1 - 1 = 2
 
 a = matrix.get(1).get(0),
b = matrix.get(1).get(3),
c = matrix.get(2).get(0),
d = matrix.get(2).get(3),

a:56
b:49
c:15
d:43
max:56
 
 */

 /*
 i<-1
 j<-1
 jj<- n - 1 - j = 4 - 1 - 1 = 2
 ii<- n - 1 - i = 4 - 1 - 1 = 2
 
 a = matrix.get(1).get(1),
b = matrix.get(1).get(2),
c = matrix.get(2).get(1),
d = matrix.get(2).get(2),

a:125
b:56
c:78
d:101
max:125
 
 */

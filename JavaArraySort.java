import java.math.BigDecimal;
import java.util.*;
class JavaArraySort{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, 0, n, new Comparator<Object>(){
            public int compare(Object o1, Object o2){
                BigDecimal b1 = new BigDecimal((String)o1);
                BigDecimal b2 = new BigDecimal((String)o2);
                return b2.compareTo(b1);
            }
        });
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
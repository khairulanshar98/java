import java.util.Scanner;
class MyCalculator {
    /*
    * Create the method long power(int, int) here.
    */
    public int power(int i, int j) throws Exception {
        if (i==0 && j==0) {
            throw new Exception("n and p should not be zero.");
        } else if (i<0 || j<0) {
            throw new Exception("n or p should not be negative.");
        }
        return (int) Math.pow(Double.parseDouble(i+""), Double.parseDouble(j+""));
    }
    
}

public class JavaException2 {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
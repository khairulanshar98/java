
import java.util.*;

interface AdvancedArithmetic {

    int divisor_sum(int n);
}
//Write your code here

class MyCalculator implements AdvancedArithmetic {

    @Override
    public int divisor_sum(int n) {
        return java.util.stream.IntStream.range(1, n + 1).map(i -> {
            if (n % i == 0) {
                return i;
            } else {
                return 0;
            }
        }).sum();
    }
}

public class JavaInterface {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            MyCalculator my_calculator = new MyCalculator();
            System.out.print("I implemented: ");
            ImplementedInterfaceNames(my_calculator);
            int n = scan.nextInt();
            System.out.print(my_calculator.divisor_sum(n) + "\n");
        } finally {
            scan.close();
        }
    }

    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o) {
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++) {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

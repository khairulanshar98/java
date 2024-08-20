
import java.util.*;

abstract class Book {

    String title;

    abstract void setTitle(String s);

    String getTitle() {
        return title;
    }

}
//Write MyBook class here

class MyBook extends Book {

    @Override
    void setTitle(String t) {
        this.title = t;
    }
}

public class JavaMyBook {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (sc) {
            String title = sc.nextLine();
            MyBook new_novel = new MyBook();
            new_novel.setTitle(title);
            System.out.println("The title is: " + new_novel.getTitle());
        } finally {
            sc.close();
        }
    }
}

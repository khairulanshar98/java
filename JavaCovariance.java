
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Complete the classes below
class Flower {

    private String name = "I have many names and types.";

    public Flower() {
    }

    public Flower(String s) {
        this.name = s;
    }

    public String whatsYourName() {
        return this.name;
    }

}

class Jasmine extends Flower {

    public Jasmine() {
        super("Jasmine");
    }
}

class Lily extends Flower {

    public Lily() {
        super("Lily");
    }
}

class Region {

    private final Flower flower;

    public Region() {
        this.flower = new Flower();
    }

    public Region(Flower flower) {
        this.flower = flower;
    }

    public Flower yourNationalFlower() {
        return this.flower;
    }
}

class WestBengal extends Region {

    public WestBengal() {
        super(new Jasmine());
    }
}

class AndhraPradesh extends Region {

    public AndhraPradesh() {
        super(new Lily());
    }
}

public class JavaCovariance {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}

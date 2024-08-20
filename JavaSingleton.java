
class JavaSingleton {

    public String str;
    private static final JavaSingleton s = new JavaSingleton();

    private JavaSingleton() {

    }

    public static JavaSingleton getSingleInstance() {
        return s;
    }
}

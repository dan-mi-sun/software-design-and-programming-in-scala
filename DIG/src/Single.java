public class Single {
    private static Single single;

    static {
        single = new Single();
    }

    private Single(){}

    public static Single getInstance(){
        return single;
    }
}

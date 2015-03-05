public class Singleton {
    private static Singleton singleton;

    static {
        singleton = new Singleton();
    }

    private Singleton(){

    }

//    public Singleton getInstance(){
//        if (singleton == null)
//            singleton = new Singleton();
//        return singleton;
//    }

    public Singleton getInstance(){
        return singleton;
    }
}

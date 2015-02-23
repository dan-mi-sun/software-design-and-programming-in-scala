package example02;

public interface C extends A {
    public default String eats(){
        return "I eat regularly";
    }
}

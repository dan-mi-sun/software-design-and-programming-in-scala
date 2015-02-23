package example02;

public interface B extends A{
    public default String eats(){
        return "Sometimes I eat";
    }
}

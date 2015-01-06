package Cloning;

public class SimpleClass implements Cloneable {
    private int mVal;

    public SimpleClass(int x) {
        mVal = x;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

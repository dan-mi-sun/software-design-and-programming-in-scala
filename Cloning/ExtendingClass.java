package Cloning;

public class ExtendingClass extends ReferencingClass implements Cloneable {

    public ExtendingClass() {
        super(5);
    }

    public void setPrim(int x) {
        super.mPrim = x;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

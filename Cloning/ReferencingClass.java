package Cloning;

public class ReferencingClass implements Cloneable {
    protected SimpleClass mRef;
    protected int mPrim;

    public ReferencingClass(int val) {
        mRef = new SimpleClass(val);
        mPrim = val;
    }


    public Object clone() throws CloneNotSupportedException {
        ReferencingClass r = (ReferencingClass) super.clone();
        r.mRef = (SimpleClass) mRef.clone();
        return r;
    }
}

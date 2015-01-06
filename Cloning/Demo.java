package Cloning;

public class Demo {
    public static void main(String[] args) {
        try {

            SimpleClass sc = new SimpleClass(6);
            SimpleClass sc_clone = (SimpleClass) sc.clone();


            ReferencingClass rc = new ReferencingClass(6);
            ReferencingClass rc_clone = (ReferencingClass) rc.clone();


            ExtendingClass ec = new ExtendingClass();
            ec.setPrim(9);
            ExtendingClass ec_clone = (ExtendingClass) ec.clone();

            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

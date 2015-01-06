package Puzzlers;

public class ClassyConundrum {

    public String mString = "CS is fun";

    public void ClassyConundrum() {
        mString = "CS is dull";
    }

    public static void main(String[] args) {
        ClassyConundrum ii = new ClassyConundrum();
        System.out.println(ii.mString);
    }

}

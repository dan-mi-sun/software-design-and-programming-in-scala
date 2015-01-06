package OOP;

public class Check1 {

    public static void myfunction(int x, int[] a) {
        x = x + 1;
        a[0] = a[0] + 1;
    }

    public static void myfunction2(int x, int[] a) {
        x = 1;
        x = x + 1;
        a = new int[]{1};
        a[0] = a[0] + 1;
    }

    public static void main(String[] arguments) {
        int num = 1;
        int numarray[] = {1};

        myfunction(num, numarray);
        //myfunction2(num, numarray);
        System.out.println(num + " " + numarray[0]);

    }
}
package OOP;

public class Check2 {

    public static void swap(int[] a, int b[]) {
        int[] tmp = a;
        a = b;
        b = tmp;
    }


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        int b[] = {5, 6, 7, 8};

        int[] tmp = a;
        a = b;
        b = tmp;

        System.out.println(a[0]);

    }

}

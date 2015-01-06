package GarbageCollection;

public class DemoGarbage {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int x[] = new int[10000];
        while (true) {
            x = new int[10000];
            System.gc();
            System.out.println(Runtime.getRuntime().totalMemory() -
                    Runtime.getRuntime().freeMemory());
        }

    }

}

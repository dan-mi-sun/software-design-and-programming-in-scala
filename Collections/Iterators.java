package Collections;

import java.util.Vector;

public class Iterators {

    public static Vector<Integer> mList = new Vector<Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Iterators.mList.add(i);
        }

        int j = mList.size();
        for (int i = 0; i < j; i++) {
            System.out.println(Iterators.mList.get(i) + " ");
            if (i == 3) Iterators.mList.remove(i);
        }

    }
}

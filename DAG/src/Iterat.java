import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Iterat {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("a","b","c");

        for (Iterator<String> il = ls.iterator(); il.hasNext();){
            String s = il.next();
            if (s.equals("b"))
                ls.remove(s);
            System.out.println(s);
        }
        System.out.println(ls);


//        for(String s: ls){
//            if (s.equals("b"))
//                ls.remove(s);
//            System.out.println(s);
//        }
//        System.out.println(ls);

    }
}

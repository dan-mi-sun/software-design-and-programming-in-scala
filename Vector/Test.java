package Vector;

public class Test {

    public static void main(String[] args) {
        Vector2D v = new Vector2D(1.0, 2.0);
        Vector2D v2 = new Vector2D(1.0, 2.0);
        Vector2D v3 = new Vector2D(1.0, 2.0);

        Vector2D v4 = v.add(v2).add(v3);
    }

}

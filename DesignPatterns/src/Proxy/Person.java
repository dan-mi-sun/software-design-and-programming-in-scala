package Proxy;

public class Person implements PersonInterface {

    private String mName;
    private float mWeight;

    public Person(String name, float weight) {
        mName = name;
        mWeight = weight;
    }

    public float getWeight() {
        // Assume we weigh ourselves here
        return mWeight;
    }

    public String getName() {
        return mName;
    }

}

package DesignPatterns.Observer;

import java.util.LinkedList;

public class Person implements PersonInterface {

    private String mName;
    private float mWeight;

    private LinkedList<PersonProxy> mProxies = new LinkedList<PersonProxy>();

    public Person(String name, float weight) {
        mName = name;
        mWeight = weight;
    }

    public float getWeight() {
        // Assume we compute the latest age estimate here
        return mWeight;
    }

    public String getName() {
        return mName;
    }

    public void registerProxy(PersonProxy p) {
        // Register this object as wanting callbacks if the
        // weight changes
        mProxies.add(p);
    }

    public void setWeight(float w) {
        // Change the weight
        mWeight = w;
        // Update anything that registered with us
        for (PersonProxy pp : mProxies) pp.updateWeight(w);
    }

}

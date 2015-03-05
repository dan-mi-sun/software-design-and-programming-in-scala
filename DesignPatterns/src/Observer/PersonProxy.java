package Observer;

public class PersonProxy implements PersonInterface {

    private Person mPerson;
    private String mCachedName;
    private float mCachedWeight;

    public PersonProxy(Person p) {
        mPerson = p;

        // Set up the initial values
        mCachedName = mPerson.getName();
        mCachedWeight = mPerson.getWeight();

        // Register to receive updates
        mPerson.registerProxy(this);
    }

    public String getName() {
        return mCachedName;
    }

    public float getWeight() {
        // Use our cache, which is updated automatically
        return mCachedWeight;
    }

    // This function provides the ability to have the cached
    // value updated. By registering the PersonProxy with the
    // true Person, the Person Object can update it by calling
    // this method. Those with more Java experience may realise
    // that many of these methods should be synchronized, but that's
    // not covered in the OOP course so I haven't done so.
    public void updateWeight(float w) {
        mCachedWeight = w;
    }

}

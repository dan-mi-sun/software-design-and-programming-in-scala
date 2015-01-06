package Comparing;

public class Person implements Comparable<Person> {

    private String mForename;
    private String mSurname;
    private int mAge;

    public Person(String forename, String surname, int age) {
        mForename = forename;
        mSurname = surname;
        mAge = age;
    }

    public String getForename() {
        return mForename;
    }

    public int getAge() {
        return mAge;
    }

    public void print() {
        System.out.println(getForename() + " " + mSurname + " (" + getAge() + ")");
    }

    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            if (
                    mSurname.equals(p.mSurname) &&
                            mForename.equals(p.mForename) &&
                            mAge == p.mAge
                    ) return true;
            else return false;
        } else return false;
    }

    @Override
    public int compareTo(Person o) {
        return mSurname.compareTo(o.mSurname);
    }


}

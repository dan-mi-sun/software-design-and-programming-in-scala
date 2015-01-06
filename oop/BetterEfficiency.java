package OOP;

public class BetterEfficiency {
    public int IAgrade;
    public int IBgrade;
    public int IIgrade;

    private short mGrade = 0;

    public void setGrade(int grade, int year) {
        mGrade = (short) (mGrade | (grade << year * 3));
    }

    public int getGrade(int year) {
        int mask = 7;
        mask = mask << year * 3;
        return ((mGrade & mask) >> year * 3);
    }

    public static void main(String[] args) {
        BetterEfficiency b = new BetterEfficiency();
        b.setGrade(1, 0);
        b.setGrade(2, 1);
        b.setGrade(3, 2);
        System.out.println(b.getGrade(0) + " " + b.getGrade(1) + " " + b.getGrade(2));
    }


}

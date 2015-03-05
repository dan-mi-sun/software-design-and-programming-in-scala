package composite;

public class DVD extends Product {
    private String mTitle;

    public DVD(String title, float price) {
        super(price);
        mTitle = title;
    }
}

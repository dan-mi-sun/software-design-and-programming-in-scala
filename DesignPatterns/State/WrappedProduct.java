package DesignPatterns.State;

public class WrappedProduct extends Product {

    private Product mContents;
    private GiftType mGiftType;

    public WrappedProduct(Product p, GiftType g) {
        super(p.getPrice());
        mContents = p;
    }

    public void setGiftType(GiftType g) {
        mGiftType = g;
    }

    public float getPrice() {
        return mContents.getPrice() + mGiftType.getWrapPrice();
    }
}

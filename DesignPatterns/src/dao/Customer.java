package dao;

public class Customer {
    private String id;
    private String contactName;
    private String phone;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setContactName(String cn) {
        this.contactName = cn;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }
}
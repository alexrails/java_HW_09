package academy.belhard;

public class Address {
    private String city;
    private String street;
    private int homeNumber;

    public Address(String city, String street, int homeNumber) {
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city: " + city + ',' +
                " street: " + street + ',' +
                " homeNumber: " + homeNumber +
                '}';
    }
}

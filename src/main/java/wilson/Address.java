package wilson;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("What is your street address?")
    private String street;

    @SerializedName("What city do you live in?")
    private String city;

    @SerializedName("What state do you live in?")
    private String state;

    public Address() {
        street = null;
        city = null;
        state = null;
    }

    public Address (String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        if(this.city == null) {
            return "";
        }
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        if(this.state == null) {
            return "";
        }
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        if(this.street == null) {
            return "";
        }
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

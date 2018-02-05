package wilson;

import com.google.gson.annotations.SerializedName;

public class Profile {

    private Address address;

    @SerializedName("First Name")
    private String firstName;

    @SerializedName("Preferred Name")
    private String preferredName;

    @SerializedName("Last Name")
    private String lastName;

    @SerializedName("What is your preferred method of contact?")
    private String contactMethod;

    @SerializedName("What phone number should we use to contact you?")
    private String phoneNumber;

    @SerializedName("Email Address")
    private String email;

    public Profile() {
        address = null;
        firstName = null;
        contactMethod = null;
        phoneNumber = null;
        email = null;
    }

    public Profile (String name, String preferredName, String lastName,
                    String phoneNumber, String email, Address address,
                    String contactMethod) {

        this.firstName = name;

        if(preferredName == null) {
            this.preferredName = firstName;
        } else {
            this.preferredName = preferredName;
        }
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.contactMethod = contactMethod;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setName(String firstName, String preferredName, String lastName) {
        this.firstName = firstName;
        this.preferredName = preferredName;
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }
}

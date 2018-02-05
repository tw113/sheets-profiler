package wilson;

import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("First Name")
    private String firstName;

    @SerializedName("Preferred First Name")
    private String preferredNamed;

    @SerializedName("Last Name")
    private String lastName;

    public Name() {
        firstName = null;
        preferredNamed = null;
        lastName = null;
    }

    public Name(String firstName, String preferredNamed, String lastName) {
        this.firstName = firstName;
        this.preferredNamed = preferredNamed;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPreferredNamed() {
        return preferredNamed;
    }

    public void setPreferredNamed(String preferredNamed) {
        this.preferredNamed = preferredNamed;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

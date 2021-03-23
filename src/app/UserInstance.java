package app;

public class UserInstance {
    private int id;
    private String firstName;
    private String lastName;
    private String zipCode;

    public UserInstance(String firstName, String lastName, String zipCode, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void printUser() {
        System.out.format(
            "ID: %d, FirstName: %s, LastName:%s, ZipCode: %s\n",
           id, firstName, lastName, zipCode
        );
    }

    public String getLastName() {
        return firstName;
    }

    public int getId() { return this.id; }

    public String getZipCode() {
        return zipCode;
    }

    public boolean match(UserInstance node) {
        return (
            firstName.equals(node.getFirstName()) &&
            lastName.equals(node.getLastName()) &&
            zipCode.equals(node.getZipCode())
        );
    }
}

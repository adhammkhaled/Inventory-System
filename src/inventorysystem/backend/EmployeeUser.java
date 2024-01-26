package inventorysystem.backend;

public class EmployeeUser implements RecordInterface{

    private String employeeId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    

    public String lineRepresentation() {
        return getEmployeeId() + "," + getName() + "," + getEmail() + "," + getAddress() + "," + getPhoneNumber();
    }

    public String getSearchKey() {
        return getEmployeeId();
    }

}
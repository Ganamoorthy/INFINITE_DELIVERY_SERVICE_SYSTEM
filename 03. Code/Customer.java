class Customer extends User {
    private String name;
    private String address;
    private String mobileNumber;

    public Customer(String username, String password, String name, String address, String mobileNumber) {
        super(username, password);
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
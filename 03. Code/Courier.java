class Courier {
    private String name;
    private int id;
    private String contactNumber;

    public Courier(String name, int id, String contactNumber) {
        this.name = name;
        this.id = id;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}

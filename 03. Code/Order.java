class Order {
    private String orderNumber;
    private String itemName;
    private String itemDetails;
    private int quantity;
    private String deliveryPersonName;
    private String deliveryAddress;
    private String deliveryPersonContact;

    public Order(String orderNumber, String itemName, String itemDetails, int quantity,
            String deliveryPersonName, String deliveryAddress, String deliveryPersonContact) {
        this.orderNumber = orderNumber;
        this.itemName = itemName;
        this.itemDetails = itemDetails;
        this.quantity = quantity;
        this.deliveryPersonName = deliveryPersonName;
        this.deliveryAddress = deliveryAddress;
        this.deliveryPersonContact = deliveryPersonContact;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDeliveryPersonName() {
        return deliveryPersonName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryPersonContact() {
        return deliveryPersonContact;
    }
}
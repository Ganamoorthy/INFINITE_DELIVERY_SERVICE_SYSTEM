import java.util.Scanner;

public class Main {
    private static final String[] usernames = { "Prinshi", "Chanku", "Mathy", "Sibo", "Moorthy" };
    private static final String[] passwords = { "2803", "0306", "2309", "1204", "2109" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueAccess = true;

        System.out.println("Welcome to the Online Ordering System!");

        while (continueAccess) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Customer Ordering Process");
            System.out.println("2. Order Placement Process");
            System.out.println("3. Courier Selection Process");
            System.out.println("4. Calculate Charge");
            System.out.println("5. Payment Process");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nCustomer Ordering Process:");
                    handleCustomerOrdering(scanner);
                    break;
                case 2:
                    System.out.println("\nOrder Placement Process:");
                    handleOrderPlacement(scanner);
                    break;
                case 3:
                    System.out.println("\nCourier Selection Process:");
                    handleCourierSelection(scanner);
                    break;
                case 4:
                    System.out.println("\nCalculate Charge:");
                    handleChargeCalculation(scanner);
                    break;
                case 5:
                    System.out.println("\nPayment Process:");
                    handlePaymentProcess(scanner);
                    break;
                case 6:
                    continueAccess = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
        System.out.println("\nThank you for using our system!");
    }

    private static void handleCustomerOrdering(Scanner scanner) {
        // Get user credentials
        String username, password;
        boolean loggedIn = false;
        boolean found = false;

        do {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            // Check if entered username and password match any of the predefined ones
            for (int i = 0; i < usernames.length; i++) {
                if (usernames[i].equals(username) && passwords[i].equals(password)) {
                    loggedIn = true;
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Incorrect username or password. Try again.");
            }

        } while (!loggedIn);

        // Display real-time access (dummy implementation)
        displayRealTimeAccess();

        // Get user information (dummy implementation)
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your contact address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your contact mobile number: ");
        String mobileNumber = scanner.nextLine();

        // Dummy order creation (for demonstration)
        String orderNumber = generateOrderNumber();
        System.out.println("\nOrder details:");
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Name: " + name);
        System.out.println("Contact Address: " + address);
        System.out.println("Contact Mobile Number: " + mobileNumber);
    }

    private static void handleOrderPlacement(Scanner scanner) {
        // Dummy order details input (for demonstration)
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item details: ");
        String itemDetails = scanner.nextLine();
        System.out.print("Enter quantity of delivery item: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter delivery person name: ");
        String deliveryPersonName = scanner.nextLine();
        System.out.print("Enter delivery address: ");
        String deliveryAddress = scanner.nextLine();
        System.out.print("Enter delivery person contact number: ");
        String deliveryPersonContact = scanner.nextLine();

        // Dummy order creation (for demonstration)
        String orderNumber = generateOrderNumber();
        Order order = new Order(orderNumber, itemName, itemDetails, quantity,
                deliveryPersonName, deliveryAddress, deliveryPersonContact);

        // Dummy order display (for demonstration)
        System.out.println("\nOrder details:");
        System.out.println("Order Number: " + order.getOrderNumber());
        System.out.println("Item Name: " + order.getItemName());
        System.out.println("Item Details: " + order.getItemDetails());
        System.out.println("Quantity: " + order.getQuantity());
        System.out.println("Delivery Person: " + order.getDeliveryPersonName());
        System.out.println("Delivery Address: " + order.getDeliveryAddress());
        System.out.println("Delivery Person Contact: " + order.getDeliveryPersonContact());
    }

    private static void handleCourierSelection(Scanner scanner) {
        // Dummy courier selection (for demonstration)
        System.out.println("Courier Persons and IDs:");
        System.out.println("1. Hashmithan - 20001");
        System.out.println("2. Riththikkan - 20002");
        System.out.println("3. Jenif - 20003");
        System.out.println("4. Pojayanan - 20004");
        System.out.println("5. Niruban - 20005");
        System.out.print("Enter the ID of the selected courier person: ");
        int selectedCourierID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Dummy courier display (for demonstration)
        displayCourierDetails(selectedCourierID);
    }

    private static void handleChargeCalculation(Scanner scanner) {
        Charge chargeCalculator = new Charge();

        // Get user input for net weight and town selection
        System.out.print("Enter the net weight (in kg) of the item: ");
        double netWeight = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.println("List of towns:");
        System.out.println("1. Colpetty\n2. Wellawata\n3. Bambalapitiya\n4. Borella\n5. Narahepita");

        System.out.print("Select the town (1-5): ");
        int selectedTown = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Calculate charges
        double baseCharge = Charge.BASE_CHARGE;
        double minimumWeightCharge = Charge.MINIMUM_WEIGHT_CHARGE;
        double weightChargePerKg = Charge.WEIGHT_CHARGE_PER_KG;
        double baseDistanceCharge = Charge.BASE_DISTANCE_CHARGE;
        double extraDistanceChargePerKm = Charge.EXTRA_DISTANCE_CHARGE_PER_KM;

        // Calculate and display the charges
        double weightCharge = (netWeight < 1) ? minimumWeightCharge
                : minimumWeightCharge + ((netWeight - 1) * weightChargePerKg);
        double distanceToColpetty = chargeCalculator.getDistances()[selectedTown - 1];
        double extraDistanceCharge = (distanceToColpetty > 5) ? ((distanceToColpetty - 5) * extraDistanceChargePerKm)
                : 0;
        double totalCharge = baseCharge + weightCharge + baseDistanceCharge + extraDistanceCharge;

        System.out.println("\nBase Charge: Rs " + baseCharge);
        System.out.println("Minimum Weight Charge: Rs " + minimumWeightCharge);
        System.out.println("Weight Charge per kg: Rs " + weightChargePerKg);
        System.out.println("Base Distance Charge: Rs " + baseDistanceCharge);
        System.out.println("Extra Distance Charge per km: Rs " + extraDistanceChargePerKm);
        System.out.println("Weight Charge: Rs " + weightCharge);
        System.out.println("Extra Distance Charge: Rs " + extraDistanceCharge);
        System.out.println("\nTotal Charge: Rs " + totalCharge);
    }

    private static void handlePaymentProcess(Scanner scanner) {
        // Create payment methods
        PaymentMethod cashOnDelivery = new PaymentMethod("Cash on Delivery");
        PaymentMethod onlinePayment = new PaymentMethod("Online Payment");

        // Get payment method from the user
        System.out.println("Select payment method:");
        System.out.println("1. " + cashOnDelivery.getMethod());
        System.out.println("2. " + onlinePayment.getMethod());
        System.out.print("Enter the payment method number: ");
        int paymentMethod = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Display amount and payment details
        // double amount = 100.0; // Replace with the actual amount calculated
        // System.out.println("\nAmount to pay: Rs " + amount);

        if (paymentMethod == 1) {
            System.out.println("Please settle the amount while receiving your order. Thank You.");
        } else if (paymentMethod == 2) {
            System.out.println("Bank Details:");
            System.out.println("Bank: Bank Of Ceylon");
            System.out.println("Branch: Pettah, Colombo");
            System.out.println("Account Number: 8052211");
            System.out.println("Account Name: Infinite Delivery Service");
            System.out.println("Kindly transfer the amount to our account. Thank You.");
        }

        // Display final message
        System.out.println("\nTHANK YOU FOR CONNECTING WITH INFINITE DELIVERY SERVICE");
        System.out.println("You'll Receive Your Order Soon!");
        System.out.println("Our Courier Person Will Contact You Now.");
        System.out.println("THANK-YOU...!!!");
    }

    private static void displayRealTimeAccess() {
        // Dummy implementation for displaying real-time access
        System.out.println("Logged in at: " + java.time.LocalDateTime.now());
    }

    private static String generateOrderNumber() {
        // Dummy implementation for generating order number
        return "Order123";
    }

    private static void displayCourierDetails(int courierID) {
        // Dummy courier details display (for demonstration)
        switch (courierID) {
            case 1:
                System.out.println("Selected Courier: Hashmithan");
                System.out.println("ID: 20001");
                System.out.println("Contact Number: 0776543456");
                break;
            case 2:
                System.out.println("Selected Courier: Riththikkan");
                System.out.println("ID: 20002");
                System.out.println("Contact Number: 0765434567");
                break;
            case 3:
                System.out.println("Selected Courier: Jenif");
                System.out.println("ID: 20003");
                System.out.println("Contact Number: 0726543234");
                break;
            case 4:
                System.out.println("Selected Courier: Pojayanan");
                System.out.println("ID: 20004");
                System.out.println("Contact Number: 0749834567");
                break;
            case 5:
                System.out.println("Selected Courier: Niruban");
                System.out.println("ID: 20005");
                System.out.println("Contact Number: 0771190979");
                break;
            default:
                System.out.println("Invalid courier ID.");
        }
    }
}


class CinemaBooking {
    String movieName;
    double ticketPrice;
    int numberOfTickets;
    String customerName;

    // Constructor 1: No arguments
    CinemaBooking() {
        movieName = "Unknown";
        ticketPrice = 200.0;
        numberOfTickets = 0;
        customerName = "Unknown";
    }

    // Constructor 2
    CinemaBooking(String customerName, String movieName) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketPrice = 200.0;
        this.numberOfTickets = 0;
    }

    // Constructor 3: Initialize all details
    CinemaBooking(String customerName, String movieName,
                  double ticketPrice, int numberOfTickets) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    // Method overloading: Book using ticket count
    void bookTickets(int tickets) {
        numberOfTickets = tickets;
    }

    // Method overloading: Book using ticket count and price
    void bookTickets(int tickets, double price) {
        numberOfTickets = tickets;
        ticketPrice = price;
    }

    // Calculate total amount
    double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    // Calculate discount
    double calculateDiscount() {
        if (numberOfTickets >= 5) {
            return calculateTotal() * 0.10;
        }
        return 0.0;
    }

    // Compare customer names
    boolean compareCustomer(String name) {
        return customerName.equalsIgnoreCase(name);
    }

    // Display booking summary
    void displayBooking() {
        System.out.println("\nCustomer Name   : "
                + customerName.toUpperCase());
        System.out.println("Movie Name      : "
                + movieName.toUpperCase());

        System.out.printf("Ticket Price    : Rs. %.2f%n",
                ticketPrice);
        System.out.println("Number of Tickets: "
                + numberOfTickets);

        if (numberOfTickets <= 0) {
            System.out.println("Booking Status  : Invalid Booking");
            return;
        }

        double total = calculateTotal();
        double discount = calculateDiscount();
        double finalAmount = total - discount;

        System.out.println("Booking Status  : Booking Successful");
        System.out.printf("Total Amount    : Rs. %.2f%n", total);
        System.out.printf("Discount        : Rs. %.2f%n", discount);
        System.out.printf("Final Amount    : Rs. %.2f%n",
                finalAmount);
    }

    public static void main(String[] args) {
        System.out.println(
                "========== CINEMA TICKET BOOKING ==========");

        // First booking using constructor 3
        CinemaBooking b1 = new CinemaBooking(
                "Sneha", "Avatar", 200.0, 5);

        b1.displayBooking();

        // Second booking using constructor 2
        CinemaBooking b2 = new CinemaBooking(
                "Arjun", "Avatar");

        b2.bookTickets(2);
        b2.displayBooking();

        // Compare customer names
        System.out.println("\nCustomer name matches: "
                + b1.compareCustomer("Sneha"));
    }
}

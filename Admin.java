public class Admin extends User {

    private String staffId;

    public Admin(String id, String name, String email, String password, String staffId) {
        super(id, name, email, password);
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void generateMenu(Menu menu, Item[] items, double studentPrice, double staffPrice) {
        menu.addItems(items);
        menu.studentPrice = studentPrice;
        menu.staffPrice = staffPrice;
    }

    public void showCustomers(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null)
                continue;
            System.out.println("-" + (i + 1) + " " + customers[i].getName());
        }
    }

    public void editCustomerBalance(Customer customer, double amount) {
        if (customer == null || amount <= 0)
            return;
        customer.chargeCard(amount);
    }

    public void showItemRatings(Menu menu) {
        if (menu == null || menu.items == null)
            return;
        for (Item item : menu.items) {
            if (item == null)
                continue;
            double avg = Review.getAverageRating(menu.getReviews(), item);
            if (avg == 0.0) {
                System.out.println("- " + item.getName() + ": No ratings yet");
            } else {
                System.out.printf("- %s: %.2f / 5%n", item.getName(), avg);
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private double digitalBalance;
    private boolean isStudent;
    private List<Item> purchasedItems = new ArrayList<>();

    public Customer(String id, String name, String email, String password, boolean isStudent, double digitalBalance) {

        super(id, name, email, password);
        this.isStudent = isStudent;
        this.digitalBalance = digitalBalance;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public double getDigitalBalance() {
        return digitalBalance;
    }

    public void chargeCard(double amount) 
    {
        digitalBalance += amount;
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + digitalBalance);
    }

    public boolean purchaseItem(Menu menu, Item item) {
        if (menu == null || !menu.containsItem(item)) {
            System.out.println("Item is not on the menu.");
            return false;
        }
        double price = isStudent ? menu.studentPrice : menu.staffPrice;
        if (digitalBalance < price) {
            System.out.println("Insufficient balance to purchase " + item.getName() + ".");
            return false;
        }
        digitalBalance -= price;
        purchasedItems.add(item);
        return true;
    }

    public boolean hasPurchased(Item item) {
        if (item == null) {
            return false;
        }
        for (Item purchased : purchasedItems) {
            if (purchased != null && purchased.getId() == item.getId()) {
                return true;
            }
        }
        return false;
    }

    public List<Item> getPurchasedItems() {
        return purchasedItems;
    }
}

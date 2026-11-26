import java.util.ArrayList;
import java.util.List;

public class Menu {

    public Item[] items = new Item[20];
    public double studentPrice;
    public double staffPrice;
    private List<Review> reviews = new ArrayList<>();

    public List<Review> getReviews() {
        return reviews;
    }

    public boolean addReview(Customer customer, Item item, int rating) {
        return Review.addReview(this, customer, item, rating);
    }

    public boolean containsItem(Item item) {
        if (item == null || items == null) return false;
        for (Item existing : items) {
            if (existing != null && existing.getId() == item.getId()) {
                return true;
            }
        }
        return false;
    }

    public void addItems(Item[] newItems) 
    {
        if (newItems == null) return;
        for (Item newItem : newItems) {
            if (newItem == null) continue;
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    items[i] = newItem;
                    break;
                }
            }
        }
    }

    public void removeItem(Item item) 
    {
        if (item == null || items == null) return;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == item.getId())
            {
                items[i] = null;
                return;
            }
        }
    }
}


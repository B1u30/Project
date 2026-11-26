import java.util.List;

public class Review {

    private Item item;
    private int rating;
    

    public int getRating() {
        return rating;
    }

    public Item getItem() {
        return item;
    }

    public Review(Item item, int rating) {
        this.item = item;
        this.rating = rating;
    }

    public static boolean addReview(Menu menu, Customer customer, Item item, int rating) 
    {
        try {
            if (menu == null || customer == null || item == null) {
                throw new IllegalArgumentException("Menu, customer, and item must not be null.");
            }
            if (!customer.hasPurchased(item)) {
                throw new IllegalStateException(customer.getName() + " has not purchased " + item.getName() + ".");
            }
            if (rating < 1 || rating > 5) {
                throw new IllegalArgumentException("Rating must be between 1 and 5.");
            }

            menu.getReviews().add(new Review(item, rating));
            return true;
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Review rejected: " + e.getMessage());
            return false;
        }
    }

    public void showReviews() 
    {
        System.out.println(item.getName() + " " + rating);
    }

    public static double getAverageRating(Review[] reviews, Item item) 
    {
        int sum = 0;
        int count = 0;
        for (Review r : reviews) {
            if (r != null && r.getItem().getId() == item.getId()) {
                sum += r.getRating();
                count++;
            }
        }
        return count == 0 ? 0.0 : (double) sum / count;
    }

    public static double getAverageRating(List<Review> reviews, Item item) 
    {
        if (reviews == null || item == null) return 0.0;
        int sum = 0;
        int count = 0;
        for (Review r : reviews) {
            if (r != null && r.getItem().getId() == item.getId()) {
                sum += r.getRating();
                count++;
            }
        }
        return count == 0 ? 0.0 : (double) sum / count;
    }
}

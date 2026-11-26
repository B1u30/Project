public class Item {

    private int id;
    private String name;
    private int calories;
    private ItemType type;

    public Item(int id, String name, int calories, ItemType type) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name + " (" + type + ", " + calories + " cal)";
    }
}

enum ItemType {
    FOOD,
    DESSERT,
    DRINKS
}


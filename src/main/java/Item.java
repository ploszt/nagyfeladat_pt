public class Item extends Products {
    private int amount;

    public Item(String name, double price, DiscountType discount, int amount) {
        super(name, price, discount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getDiscountName() {
        return getDiscount().getDiscountName();
    }
}
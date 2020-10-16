public abstract class Products {
    private final String name;
    private final double price;
    private final DiscountType discount;

    public Products(String name, double price, DiscountType discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public DiscountType getDiscount() {
        return discount;
    }
}

public enum DiscountType {
    KETTOTF3ATKAP("Kettõt fizet hármat kap"),
    MEGAPACK6000("Megapack 6000"),
    AKARMI("Ez a harmadik kedvezmény");

    private final String discountName;

    DiscountType(String name) {
        this.discountName = name;
    }

    public String getDiscountName() {
        return discountName;
    }
}

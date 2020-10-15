public enum DiscountType {
    KETTOTF3ATKAP("Kettőt fizet hármat kap"),
    MEGAPACK6000("Megapack 6000"),
    AKARMI("Ez a harmadik kedvezmény");

    private final String discountName;

    private DiscountType(String name) {
        this.discountName = name;
    }

    public String getDiscountName() {
        return discountName;
    }
}

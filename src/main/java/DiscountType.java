public enum DiscountType {
    KETTOTF3ATKAP("Kett�t fizet h�rmat kap"),
    MEGAPACK6000("Megapack 6000"),
    AKARMI("Ez a harmadik kedvezm�ny");

    private final String discountName;

    DiscountType(String name) {
        this.discountName = name;
    }

    public String getDiscountName() {
        return discountName;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> products = new ArrayList<>();

    public void addProduct(Item product) {
        products.add(product);
    }

    public List<Item> getProducts() {
        return new ArrayList<>(products);
    }

}

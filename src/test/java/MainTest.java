import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class MainTest {
    @Test
    public void testCreateAndAdd() {
        // Given
        Basket b = new Basket();
        b.addProduct(new Item("Téliszalámi", 2000d, DiscountType.KETTOTF3ATKAP, 2));
        // When
        Item name = b.getProducts().get(0);
        // Then
        Assert.assertThat (name.getName().equals("Téliszalámi"), is(true));
        Assert.assertThat (name.getPrice() == 2000d, is(true));
        Assert.assertThat (name.getDiscount() == DiscountType.KETTOTF3ATKAP, is(true));
        Assert.assertThat (name.getDiscountName().equals("Megapack 6000"), is(false));
        Assert.assertThat (name.getAmount() != 2 , is(false));
    }

        @Test
        public void testTotal() {
            // Given
            Basket b = new Basket();
            b.addProduct(new Item("Téliszalámi", 2000d, DiscountType.KETTOTF3ATKAP, 2));
            // When
            String totalText = Main.getTotal(b);
            // Then
            Assert.assertThat (totalText.equals("Eredeti ár: 4000.0 / Nincs kedvezmény!"), is(true));
        }

    }

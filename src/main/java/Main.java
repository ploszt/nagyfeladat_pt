import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Basket b = new Basket();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Mennyi téliszalámit kíván vásárolni? ");
            Integer piecesOfTeliszalami = sc.nextInt();
            if (piecesOfTeliszalami >= 0) {
                b.addProduct(new Item("Téliszalámi", 2000d, DiscountType.KETTOTF3ATKAP, piecesOfTeliszalami));
            } else {
                throw new InputMismatchException();
            }

            System.out.println("Mennyi gumikacsát kíván vásárolni? ");
            Integer piecesOfGumikacsa = sc.nextInt();
            if (piecesOfGumikacsa >= 0) {
                b.addProduct(new Item("Gumikacsa", 3000d, DiscountType.KETTOTF3ATKAP, piecesOfGumikacsa));
            } else {
                throw new InputMismatchException();
            }
            System.out.println("Mennyi uborkát kíván vásárolni? ");
            Integer piecesOfUborka = sc.nextInt();
            if (piecesOfUborka >= 0) {
                b.addProduct(new Item("Uborka", 2800d, DiscountType.MEGAPACK6000, piecesOfUborka));
            } else {
                throw new InputMismatchException();
            }
            System.out.println("Mennyi gesztenyét kíván vásárolni? ");
            Integer piecesOfGesztenye = sc.nextInt();
            if (piecesOfGesztenye >= 0) {
                b.addProduct(new Item("Gesztenye", 1000d, DiscountType.MEGAPACK6000, piecesOfGesztenye));
            } else {
                throw new InputMismatchException();
            }

            for (Item element : b.getProducts()) {
                System.out.println("Áru: " + element.getName() + " - Darabszám: " + element.getAmount());
            }
            System.out.println(getTotal(b));

        } catch (InputMismatchException ex) {
            System.out.println("Nem jól adta meg a bekért adatot!");
        }

    }

    public static String getTotal(Basket bs) {
        double totalPrice = 0;
        String whichDiscountName = null;
        int discountAmount = 0;
        double discountPrice = 0;
        double discountPrice0 = 0;
        double discountPrice1 = 0;

        for (Item element : bs.getProducts()) {
//            System.out.println("Áru: " + element.getName() + " Ára: " + element.getPrice() + " Kedvezmény: " + element.getDiscountName() + " Darabszám: " + element.getAmount());
            totalPrice += element.getPrice() * element.getAmount();
            switch (element.getDiscount()) {
                case KETTOTF3ATKAP:
                    discountAmount = element.getAmount() / 3;
                    discountPrice0 += discountAmount * element.getPrice();
                    break;

                case MEGAPACK6000:
                    discountAmount = element.getAmount() / 12;
                    discountPrice1 += discountAmount * 6000;
                    break;
            }
            whichDiscountName = discountPrice0 > discountPrice1 ? DiscountType.KETTOTF3ATKAP.getDiscountName() : DiscountType.MEGAPACK6000.getDiscountName();
            discountPrice = discountPrice0 > discountPrice1 ? totalPrice - discountPrice0 : totalPrice - discountPrice1;
        }
        return totalPrice == discountPrice ? "Kosár - Eredeti ár: " + totalPrice + " / Nincs kedvezmény!" : "Kosár - Eredeti ár: " + totalPrice + " / Kedvezményes ár: " + discountPrice + " / Kedvezmény típusa: " + whichDiscountName;
    }
}
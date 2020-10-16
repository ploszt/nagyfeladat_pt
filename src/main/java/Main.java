import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Basket b = new Basket();
        Scanner sc = new Scanner(System.in);

        System.out.println("�dv, a butikban!");
        System.out.println(" ");

        try {
            System.out.println("Mennyi t�liszal�mit k�v�n v�s�rolni? ");
            int piecesOfTeliszalami = sc.nextInt();
            if (piecesOfTeliszalami >= 0) {
                b.addProduct(new Item("T�liszal�mi", 2000d, DiscountType.KETTOTF3ATKAP, piecesOfTeliszalami));
            } else {
                throw new InputMismatchException();
            }
            System.out.println("Mennyi gumikacs�t k�v�n v�s�rolni? ");
            int piecesOfGumikacsa = sc.nextInt();
            if (piecesOfGumikacsa >= 0) {
                b.addProduct(new Item("Gumikacsa", 3000d, DiscountType.KETTOTF3ATKAP, piecesOfGumikacsa));
            } else {
                throw new InputMismatchException();
            }
            System.out.println("Mennyi ubork�t k�v�n v�s�rolni? ");
            int piecesOfUborka = sc.nextInt();
            if (piecesOfUborka >= 0) {
                b.addProduct(new Item("Uborka", 2800d, DiscountType.MEGAPACK6000, piecesOfUborka));
            } else {
                throw new InputMismatchException();
            }
            System.out.println("Mennyi geszteny�t k�v�n v�s�rolni? ");
            int piecesOfGesztenye = sc.nextInt();
            if (piecesOfGesztenye >= 0) {
                b.addProduct(new Item("Gesztenye", 1000d, DiscountType.MEGAPACK6000, piecesOfGesztenye));
            } else {
                throw new InputMismatchException();
            }

            System.out.println(" ");
            System.out.println("A kos�r tartalma:");
            System.out.println("-----------------");
            for (Item element : b.getProducts()) {
                System.out.println(element.getName() + " - Darabsz�m: " + element.getAmount());
            }

            System.out.println("");
            System.out.println(getTotal(b));

        } catch (InputMismatchException ex) {
            System.out.println(" ");
            System.out.println("Nem j�l adta meg a bek�rt adatot!");
        }

        System.out.println(" ");
        System.out.println("Viszl�t!");
    }

    public static String getTotal(Basket bs) {
        double totalPrice = 0;
        String whichDiscountName = null;
        int discountAmount;
        double discountPrice = 0;
        double discountPrice0 = 0;
        double discountPrice1 = 0;

        for (Item element : bs.getProducts()) {
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
        return totalPrice == discountPrice ? "Eredeti �r: " + totalPrice + " / Nincs kedvezm�ny!" : "Eredeti �r: " + totalPrice + " / Kedvezm�nyes �r: " + discountPrice + " / Kedvezm�ny t�pusa: " + whichDiscountName;
    }
}
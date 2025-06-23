import java.util.Scanner;

public class Restaurant {

    static int idliQty = 5;
    static int dosaQty = 5;
    static int pohaQty = 5;

    static int total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char more;

        System.out.println("Welcome to My Restaurant!");

        do {
            showMenu();
            System.out.print("Enter item number: ");
            int item = sc.nextInt();

            if (!isAvailable(item)) {
                System.out.println("Item out of stock. Please refill.");
                refillStockForItem(item, sc);
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            orderItem(item, qty, sc);

            System.out.print("Do you want to order more? (y/n): ");
            more = sc.next().charAt(0);

        } while (more == 'y' || more == 'Y');

        System.out.println("\nTotal Bill = Rs." + total);
        System.out.println("Remaining Stock:");
        System.out.println("Idli: " + idliQty);
        System.out.println("Dosa: " + dosaQty);
        System.out.println("Poha: " + pohaQty);
        System.out.println("Thank you! Visit again.");
    }

    static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Idli - Rs.30 (Available: " + idliQty + ")");
        System.out.println("2. Dosa - Rs.50 (Available: " + dosaQty + ")");
        System.out.println("3. Poha - Rs.25 (Available: " + pohaQty + ")");
    }

    static boolean isAvailable(int item) {
        if (item == 1 && idliQty == 0) return false;
        if (item == 2 && dosaQty == 0) return false;
        if (item == 3 && pohaQty == 0) return false;
        return true;
    }

    static void orderItem(int item, int qty, Scanner sc) {
        if (item == 1) {
            if (qty <= idliQty) {
                idliQty -= qty;
                total += qty * 30;
                System.out.println(qty + " Idli added.");
            } else {
                System.out.println("Only " + idliQty + " Idli left.");
            }
        } else if (item == 2) {
            if (qty <= dosaQty) {
                dosaQty -= qty;
                total += qty * 50;
                System.out.println(qty + " Dosa added.");
            } else {
                System.out.println("Only " + dosaQty + " Dosa left.");
            }
        } else if (item == 3) {
            if (qty <= pohaQty) {
                pohaQty -= qty;
                total += qty * 25;
                System.out.println(qty + " Poha added.");
            } else {
                System.out.println("Only " + pohaQty + " Poha left.");
            }
        } else {
            System.out.println("Invalid item number.");
        }
    }

    static void refillStockForItem(int item, Scanner sc) {
        if (item == 1) {
            System.out.print("Enter quantity to refill Idli: ");
            idliQty += sc.nextInt();
        } else if (item == 2) {
            System.out.print("Enter quantity to refill Dosa: ");
            dosaQty += sc.nextInt();
        } else if (item == 3) {
            System.out.print("Enter quantity to refill Poha: ");
            pohaQty += sc.nextInt();
        }
    }
}

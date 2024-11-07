import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Vui long nhap lai: ");
            }
        }
    }

    private static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Vui long nhap lai: ");
            }
        }
    }

    public static void main(String[] args) {
        Store s = new Store();
        int choice;
        int soSanPham;
        int orderId;
        int productId;
        String name;
        double price;
        int quantity;
        int cusId;
        String cusName;
        String cusEmail;
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        while (true) {
            System.out.println("1. Tao moi don hang");
            System.out.println("2. In danh sach don hang");
            System.out.println("3. Thoat");
            System.out.print("Lua chon cua ban: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("So san pham khach hang mua: ");
                    soSanPham = checkInputInt();
                    for (int i = 0; i < soSanPham; i++) {
                        System.out.println("Vui long nhap thong tin san pham");
                        System.out.print("Nhap id san pham: ");
                        productId = checkInputInt();
                        System.out.print("Nhap ten san pham: ");
                        name = sc.nextLine();
                        System.out.print("Nhap gia san pham: ");
                        price = checkInputDouble();
                        System.out.print("Nhap so luong san pham: ");
                        quantity = checkInputInt();
                        Product p = new Product(productId, name, price, quantity);
                        products.add(p);
                        System.out.println("");
                    }

                    System.out.println("Vui long dien thong tin khach hang");
                    System.out.print("ID khach hang: ");
                    cusId = checkInputInt();
                    System.out.print("Ten khach hang: ");
                    cusName = sc.nextLine();
                    System.out.print("Email khach hang: ");
                    cusEmail = sc.nextLine();
                    System.out.print("Nhap id don hang: ");
                    orderId = checkInputInt();
                    Customer c = new Customer(cusId, cusName, cusEmail);

                    Order o = new Order(orderId, c);
                    orders.add(o);
                    break;
                case 2:
                    System.out.println("Danh sach don hang:");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    System.out.println("");
                    break;
                default:
                    System.exit(0);

            }
        }
    }
}
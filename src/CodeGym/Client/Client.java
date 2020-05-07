package CodeGym.Client;

import CodeGym.Controller.ProductManager;
import CodeGym.Model.Product;
import CodeGym.ProductList.ProductList;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    private  ProductList<Product> products;
    private  ProductManager productManager;
    Scanner scanner = new Scanner(System.in);
    public final String NAME ="Admin";
    public Client() throws IOException {

        this.products = new ProductList<Product>();
        this.productManager = new ProductManager(products);
        productManager.read();
    }

    public void account() throws IOException {
        System.out.println("1. Admin .");
        System.out.println("2. Customer");
        int pick = scanner.nextInt();
        switch (pick){
            case 1:
                System.out.println("Enter a name : ");
                scanner.nextLine();
                String name = scanner.nextLine();
                if (name.equals(NAME)){
                    displayAdmin();
                }else {
                    System.out.println("Error .");
                    account();
                }
                break;
            case 2:
                System.out.println("Enter a name :");
                String nameCustomer = scanner.nextLine();
                displayCustomer();
                break;
            default:
                System.out.println("Enter 1 or 2 :");
                account();
        }
    }
    public void displayAdmin() throws IOException {
        System.out.println("Enter a :");
        System.out.println("1 . edit Name by ID .");
        System.out.println("2 . edit Price by ID .");
        System.out.println("3 . edit brand by ID .");
        System.out.println("4 . edit status by ID .");
        System.out.println("5 . edit description by ID .");
        System.out.println("0 . Exit .");
        int pickAdmin = scanner.nextInt();
        switch (pickAdmin){
            case 1:
                System.out.println("Enter a ID :");
                int idInput = scanner.nextInt();
                System.out.println("Enter a new Name :");
                scanner.nextLine();
                String nameInput = scanner.nextLine();
                productManager.editNameByID(idInput,nameInput);
                System.out.println("Done!");
                displayAdmin();
                break;
            case 2:
                System.out.println("Enter a ID :");
                int idByPrice = scanner.nextInt();
                System.out.println("Enter a new price :");
                scanner.nextLine();
                double newPrice = scanner.nextDouble();
                productManager.editPriceByID(idByPrice,newPrice);
                displayAdmin();
                break;
            case 3:
                System.out.println("Enter a ID :");
                int idByBrand = scanner.nextInt();
                System.out.println("Enter a new brand :");
                scanner.nextLine();
                String newBrand = scanner.nextLine();
                productManager.editBrandByID(idByBrand,newBrand);
                displayAdmin();
                break;
            case 4:
                System.out.println("Enter a ID :");
                int idByStatus = scanner.nextInt();
                System.out.println("Enter a new Status :");
                scanner.nextLine();
                String newStatus = scanner.nextLine();
                productManager.editStatusByID(idByStatus,newStatus);
                displayAdmin();
                break;

            case 5:
                System.out.println("Enter a ID :");
                int idByDescription = scanner.nextInt();
                System.out.println("Enter a new description :");
                scanner.nextLine();
                String newDescription = scanner.nextLine();
                productManager.editDescriptionByID(idByDescription,newDescription);
                displayAdmin();
                break;
            case 0:
                productManager.save();
                System.exit(0);
            default:
                System.out.println("Enter 0 to 5 :");
                displayAdmin();
        }
    }
    public  void displayCustomer() throws IOException {
        System.out.println("Enter a :");
        System.out.println("1. Add a new Product .");
        System.out.println("2. Display all Product .");
        System.out.println("0. Exit .");
        int pickCustomer = scanner.nextInt();
        switch (pickCustomer){
            case 1:
              displayAddProduct();

              displayCustomer();
              break;
            case 2:
                productManager.displayAll(products);
                displayCustomer();
                break;
            case 0:
                productManager.save();
                System.exit(0);

            default:
                System.out.println("Enter 0 to 2:");
                displayCustomer();
        }

    }
    public void displayAddProduct() throws IOException {
        System.out.println("Enter a ID :");
        int id = scanner.nextInt();
        if (productManager.checkID(id)==false) {
            System.out.println("already exist !");
            displayAddProduct();
        } else {
            System.out.println("Enter a name :");
            scanner.nextLine();
            String nameProduct = scanner.nextLine();
            System.out.println("Enter a brand :");
            String brandProduct = scanner.next();
            System.out.println("Enter a price :");
            double priceProduct = scanner.nextDouble();
            System.out.println("Enter a status :");
            scanner.nextLine();
            String statusProduct = scanner.nextLine();
            System.out.println("Enter a description :");
            String descriptionProduct = scanner.nextLine();
            productManager.creat(id, nameProduct, brandProduct, priceProduct, statusProduct, descriptionProduct);
            productManager.save();
            System.out.println("Done!");
        }
    }
}

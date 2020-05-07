package CodeGym.Model;

public class Product implements GeneralProduct {

    private int id;
    private String name;
    private String brand;
    private double price;
    private String status;
    private String description;

    public Product(){}

    public Product(int id,String name,String brand, double price, String status, String description){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Product setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Product setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "ID : "+getId()+" ,name : "+getName()+" ,brand : "+getBrand()+" ,price : "+getPrice()+" ,status : "+getStatus()+" ,description : "+getDescription();
    }
}

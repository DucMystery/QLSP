package CodeGym.Controller;

import CodeGym.Model.Product;
import CodeGym.ProductList.ProductList;

public interface Function {
    ProductList<Product> sortByPriceUp();
    ProductList<Product> sortByPriceDown();
    void editNameByID(int id, String newName);
    void editPriceByID(int id,double newPrice);
    void editBrandByID(int id, String newBrand);
    void editStatusByID(int id, String newStatus);
    void editDescriptionByID(int id, String newDescription);
    void deleteProductByID(int id);
    void displayAll(ProductList<Product> products);

}

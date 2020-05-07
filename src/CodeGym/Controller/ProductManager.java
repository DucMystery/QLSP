package CodeGym.Controller;

import CodeGym.Model.Product;
import CodeGym.ProductList.ProductList;

import java.io.*;

public class ProductManager implements Function {
    public final ProductList<Product> products;

    public ProductManager(ProductList<Product> products) {
        this.products = products;
    }
    public void creat(int id,String name,String brand, double price,String status, String description){
        Product product = new Product(id,name,brand,price,status,description);
        products.add(product);
    }

    public boolean checkID(int id){
        for (Product product : products){
            if (product.getId() == id)
                return false;
        }
        return true;
    }


    public void save() throws IOException{
        try {
            FileOutputStream fout = new FileOutputStream("productList.txt");
            for (Product product : products){
                byte[] bytes = product.toString().getBytes();
                byte[]downLine = "\n".getBytes();
                fout.write(bytes);
                fout.write(downLine);
            }
            fout.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void read() throws IOException {
        FileReader reader = new FileReader("productList.txt");
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line =br.readLine())!= null){
            String [] content = line.split(" ,");
            int id = Integer.parseInt(content[0].substring(4));
            String name = content[1].substring(6);
            String brand = content[2].substring(7);
            double price = Double.parseDouble(content[3].substring(7));
            String status = content[4].substring(8);
            String description = content[5].substring(13);
            creat(id,name,brand,price,status,description);
        }
        br.close();
    }

    @Override
    public ProductList<Product> sortByPriceUp() {
        for (int i = 0; i<products.size();i++){
            Product currentMin = products.get(i);
            int currentMinIndex = i;

            for (int j =i+1;j<products.size();j++){
                if (currentMin.getPrice()>products.get(j).getPrice()){
                    currentMin =products.get(j);
                    currentMinIndex =j;
                }
            }

            if (currentMinIndex !=i){
                products.set(currentMinIndex,products.get(i));
               products.set(i,currentMin);
            }
        }
        return products;
    }

    @Override
    public ProductList<Product> sortByPriceDown() {
        boolean status = true;
        for (int k = 1; k < products.size() && status; k++) {
            status = false;
            for (int i = 0; i < products.size() - k; i++) {
                if (products.get(i).getPrice() < products.get(i + 1).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(i + 1));
                    products.set(i + 1, temp);

                    status = true;
                }
            }
        }
        return products;
    }

    @Override
    public void editNameByID(int id, String newName) {
        for (Product product : products){
            if (product.getId() ==id){
                product.setName(newName);
                break;
            }
        }
    }

    @Override
    public void editPriceByID(int id, double newPrice) {
        for (Product product :products){
            if (product.getId() == id){
                product.setPrice(newPrice);
            }
        }
    }

    @Override
    public void editBrandByID(int id, String newBrand) {
        products.removeIf(n->(n.getId()==id));

    }

    @Override
    public void editStatusByID(int id, String newStatus) {
        for (Product product : products){
            if (product.getId()==id){
                product.setStatus(newStatus);
                break;
            }
        }
    }

    @Override
    public void editDescriptionByID(int id, String newDescription) {
        for (Product product : products){
            if (product.getId() ==id){
                product.setDescription(newDescription);
                break;
            }
        }

    }

    @Override
    public void deleteProductByID(int id) {
        for (Product product : products){
            if (product.getId() == id){
                products.remove(product.getId());
                break;
            }
        }
    }

    @Override
    public void displayAll(ProductList<Product> products) {
        for (Product product : products){
            System.out.println(product.toString());
        }
    }
}

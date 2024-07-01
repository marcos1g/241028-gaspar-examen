package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cart {
    private int id;
    private String state;
    private HashMap<Integer,Product> products;
    public Cart(String state, List<Product> products) {
        this.products = new HashMap<Integer,Product>();
        for (Product product : products) {
            this.products.put(product.getId(), product);
        }

        this.state = state;
    }

    public Cart(){}

    //Getters
    public int getId() {
        return this.id;
    }
    public String getState() {
        return this.state;
    }
    public HashMap<Integer,Product> getProducts() {
        return this.products;
    }
    public double getTotal(){
        double count = 0;
        for(Product product : products.values()){
            count += product.getPrice();
        }
        return count;
    }
    public Product getProduct(Product product){
        return products.get(product.getId());
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void addProduct(Product product){
        this.products.put(product.getId(), product);
    }

    public void addProducts(HashMap<Integer,Product> productss){

        List<Integer> Integer= new ArrayList<>();
        List<Product> Product= new ArrayList<>();
        Integer.addAll(productss.keySet());
        Product.addAll(productss.values());
        for(int i = 0; i < productss.size(); i++){
            this.products.put(Integer.get(i), Product.get(i));
        }
    }
}



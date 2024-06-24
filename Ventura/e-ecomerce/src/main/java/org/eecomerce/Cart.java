package org.eecomerce;

import java.util.ArrayList;
import java.util.List;
public class Cart {
    private int id;
    private String name;
    private String state;
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public Cart(int id, String name, String state) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", products=" + products +
                '}';
    }
}

package org.sql;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Buyer {
    private int id;
    private String name;
    private HashMap<Integer,Cart> carts;

    public Buyer(){

    }
    public Buyer(String name, List<Cart> carts) {
        this.name = name;
        this.carts = new HashMap<Integer,Cart>();
        for (Cart cart : carts) {
            this.carts.put(cart.getId(), cart);
        }


    }
    //Getters
    public String getName() {
        return this.name;
    }


    public HashMap<Integer,Cart> getCarts() {
        return this.carts;
    }
    public void addCarts(HashMap<Integer,Cart> cartss){

        List<Integer> Integer= new ArrayList<>();
        List<Cart> Cart= new ArrayList<>();
        Integer.addAll(cartss.keySet());
        Cart.addAll(cartss.values());
        for(int i = 0; i < cartss.size(); i++){
            this.carts.put(Integer.get(i), Cart.get(i));
        }
    }
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void addCart(Cart cart){
        this.carts.put(cart.getId(), cart);
    }
    public Cart getCart(int cartid){
        for(int i = 0; i < carts.size(); i++){
            if(i==cartid){
                return carts.get(i);
            }
        }
        return null;
    }



}
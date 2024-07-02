package org.sql;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Buyer {
    private int id;
    private String name;

    public Buyer(){

    }
    public Buyer(int id, String name) {
        this.name = name;
        this.id = id;

    }
    //Getters
    public String getName() {
        return this.name;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
package net.will.ebook.product.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = -2822760883078212752L;
    private int id;
    private String name;
    
    public Product() {}
    
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return String.format("Product[id=%s, name=%s]", id, name);
    }
}

package com.saishaddai;

public class Item {

    private String name;
    private Double price;

    public Item(String name, Double price) {
        this.setName(name);
        this.setPrice(price);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

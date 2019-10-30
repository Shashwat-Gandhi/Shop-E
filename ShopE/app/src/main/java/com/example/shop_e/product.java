package com.example.shop_e;

import android.graphics.Color;

public class Product {
    public String name;
    public String color;

    public  void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setType(TypeOfProduct type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getSrc() {
        return src;
    }

    public Product(String name, String color, int price, int src, int size, TypeOfProduct type,int index) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.src = src;
        this.size = size;
        this.type = type;
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public TypeOfProduct getType() {
        return type;
    }

    private int price;
    private int src;
    private int size;
    private TypeOfProduct type;
    private int index;
    int getIndex() {
        return index;
    }
    char getCharIndex() {
        return (char)index;
    }
    void setIndex(int index) {
        this.index = index;
    }
}

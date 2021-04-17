package com.streamliners.models;


public class Product {


    public String name, imageURL;

    public Product() {
    }

    public Product(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }


}

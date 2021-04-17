package com.streamliners.models;


import java.util.List;

public class VariantBasedProduct extends Product{
    List<Variant> variants;


    public VariantBasedProduct(List<Variant> variants) {
        this.variants = variants;
    }

    public VariantBasedProduct(String name, String imageURL, List<Variant> variants) {
        super(name, imageURL);
        this.variants = variants;
    }


    @Override
    public String toString() {
        return "VariantBasedProduct{" +
                "name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", variants=" + variants +
                '}';
    }
}

package com.streamliners.models;

import java.awt.*;

public class Product {


    String image, name;


     //   For variant based product
    public List variants;


    //    For quantity based product

    float minQty, pricePerKg;


    public int type;



    public Product(String image, String name, List variants) {
        type = ProductType.TYPE_VP;
        this.image = image;
        this.name = name;
        this.setVariants(variants);
    }




    public Product(String image, String name, float minQty, float pricePerKg) {
        type = ProductType.TYPE_WB;
        this.image = image;
        this.name = name;
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    public Product(String name, String imageURL) {
    }

    public Product() {

    }


    public List getVariants() {
        return variants;
    }

    public void setVariants(List variants) {
        this.variants = variants;
    }

    public void variants() {
    }
}

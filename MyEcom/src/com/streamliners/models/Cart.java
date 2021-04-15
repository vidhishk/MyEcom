package com.streamliners.models;

import java.util.HashMap;

public class Cart {
    HashMap<String, CartItem> cartItems = new HashMap<>();
    float total, noOfItems;



       // For weight based product
    public void add(Product product, float qty){

        //If the product already exist
        if(cartItems.containsKey(product.name)){
            total-= cartItems.get(product.name).cost();
        }

        //If the product is getting added for the first time
        else{
            CartItem cartItem = new CartItem(product.name,product.pricePerKg,qty);
            cartItems.put(product.name,cartItem);
            noOfItems++;
        }
        total+= product.pricePerKg * qty;
    }


       // For variant based product

    public void add(Product product, Variant variant, float qty){

        String key = product.name + " " + variant.name;

        //Checking whether that the product is already present in the cart or not.
        if(cartItems.containsKey(key)){
            cartItems.get(key).qty++;
        }

        //If the product is not present.
        else{
            CartItem cartItem = new CartItem(product.name, variant.price, qty);
            cartItems.put(key,cartItem);
        }
        noOfItems++;
        total+=variant.price * qty;
    }


     //   To remove all the products of a particular type

    public void removeAll(Product product){
        if(product.type == ProductType.TYPE_WB){
            removeAllWeightBasedProduce(product);
        }else {
            removeAllVariantsBasedProduct(product);
        }

    }


     //   To remove weight based product

    private void removeAllWeightBasedProduce(Product product) {
        total -= cartItems.get(product.name).cost();
        noOfItems--;
        cartItems.remove(product.name);
    }


    // To remove variant based product

    public void removeAllVariantsBasedProduct(Product product){

        //Using for loop because we want to delete all the variants of that particular product.

        for (Variant variant : product.variants()) {
            String key = product.name + " " + variant.name;
            if(cartItems.containsKey(key)){
                total -= cartItems.get(key).cost();
                noOfItems--;
                cartItems.remove(key);
            }
        }


    }

    //  to decrease the quantity of a particular variant

    public void decrement(Product product, Variant variant){
        String key = product.name + " " + variant.name;
        cartItems.get(key).qty--;
        total -= variant.price;
        if(cartItems.get(key).qty == 0){
            cartItems.remove(key);
            noOfItems--;
        }

    }

    @Override
    public String toString() {
        return "Cart\n" +
                cartItems +
                ",\n total=" + total +
                ",\n noOfItems=" + noOfItems +
                '}';
    }
}

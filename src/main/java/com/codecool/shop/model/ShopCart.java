package com.codecool.shop.model;

import java.util.*;

public class ShopCart {
    private static HashMap<Product, Integer> shoppingCart = new HashMap<>();

    ShopCart(){}

    public static void addToCart(Product product){
        if (getShoppingCart().keySet().contains(product)){
            getShoppingCart().put(product, numOfOrder(product) + 1);
        } else {
            getShoppingCart().put(product, 1);
        }
    }

    public static HashMap<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public static int numOfCartItems() {
        int num = 0;
        for (Integer product : shoppingCart.values()){
            num += product;
        }
        return num;
    }

    public static int quantity() {
        int counter = 0;

        for (Map.Entry<Product, Integer> entry : getShoppingCart().entrySet()) {
            counter += entry.getValue();
        }

        return counter;
    }

    public static float sumOfProductPrice() {
        float price = 0;

        for (Map.Entry<Product, Integer> entry : getShoppingCart().entrySet()) {
            price += entry.getValue() * entry.getKey().getDefaultPrice();
        }

        return price ;
    }

    public static Integer numOfOrder(Product product){
        return getShoppingCart().get(product);
    }

    public void removeFromCart(Product product){
        getShoppingCart().remove(product);
    }

}

package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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


    public static Integer numOfOrder(Product product){
        return getShoppingCart().get(product);
    }

    public void removeFromCart(Product product){
        getShoppingCart().remove(product);
    }

}

package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);
        Supplier apple = new Supplier("Apple", "Phones, computers, tablets");
        supplierDataStore.add(apple);
        Supplier acer = new Supplier("Acer", "Computers");
        supplierDataStore.add(acer);


        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);
        ProductCategory laptop = new ProductCategory("Laptop", "Hardware", "A portable personal computer powered by a battery, or an AC cord plugged into an electrical outlet, which is also used to charge the battery. Laptops have an attached keyboard and a touchpad, trackball, or isometric joystick used for navigation.");
        productCategoryDataStore.add(laptop);
        ProductCategory phone = new ProductCategory("Phone", "Hardware", "A portable telephone that can make and receive calls over a radio frequency link while the user is moving within a telephone service area.");
        productCategoryDataStore.add(phone);


        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
        productDataStore.add(new Product("Acer Predator Helios 300", 1299, "USD", "Designed for those with a need to speed, the Predator Helios 300 gaming notebook combines powerful 8th Gen Intel Core i7 processor with high-performance NVIDIA GeForce GTX 1060 graphics.", laptop, acer));
        productDataStore.add(new Product("Apple 13'' MacBook Air", 999, "USD", "The new thinner and lighter MacBook Air features a Retina display, Touch ID, and the latest-generation butterfly keyboard with Force Touch trackpad.", laptop, apple));
        productDataStore.add(new Product("Apple iPhone 6S", 269, "USD", "The iPhone 6S and iPhone 6S Plus are smartphones that were designed, developed, and marketed by Apple Inc. It is the ninth generation of the iPhone.", phone, apple));
    }
}

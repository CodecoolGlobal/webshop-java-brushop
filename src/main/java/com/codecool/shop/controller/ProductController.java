package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.ShopCart;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();

        String IDToCart = req.getParameter("orderID");
        if (IDToCart != null){
            int productId = parseInt(IDToCart);
            ShopCart.addToCart(ProductDaoMem.getInstance().find(productId));
        }

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("categories", productCategoryDataStore.getAll());
        context.setVariable("products", productDataStore.getAll());
        context.setVariable("suppliers", supplierDataStore.getAll());
        context.setVariable("numOfOrder", ShopCart.numOfCartItems());


        if (req.getParameter("supplierID") != null) {
            context.setVariable("products", productDataStore.getBy(supplierDataStore.find(parseInt(req.getParameter("supplierID")))));
        }

        if (req.getParameter("categoryID") != null) {
            context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(parseInt(req.getParameter("categoryID")))));
        }


        engine.process("product/index.html", context, resp.getWriter());
//        String supplier = req.getParameter("supplier");
//        if (supplier != null) {
//            System.out.println(supplier);
//        }
    }

}


//          context.setVariable("category", productCategoryDataStore.find(1));
//          context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(1)));
package com.codecool.shop.dao.dbimplementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.List;
import java.sql.*;


public class ProductDaoDb implements ProductDao {
    private static ProductDaoDb instance = null;
    Connection connection = null;

    public ProductDaoDb() {
    }

    public static ProductDaoDb getInstance() {
        if (instance == null) {
            instance = new ProductDaoDb();
        }
        return instance;
    }

    @Override
    public void add(Product product) {
        final String addNewProduct = "INSERT INTO products (name, category_id, supplier_id, price)" +
                "VALUES(?, ?, ?, ?)";

        String name = product.getName();
        int categoryId = product.getProductCategory().getId();
        int supplierId = product.getSupplier().getId();
        String price = product.getPrice();

        try {
            PreparedStatement preparedAddStatement = connection.prepareStatement(addNewProduct);
            preparedAddStatement.setString(1, name);
            preparedAddStatement.setInt(2, categoryId);
            preparedAddStatement.setInt(3, supplierId);
            preparedAddStatement.setString(4,price);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                System.out.println("Could not close connection");

            }
        }

    }

    private void setCategory(String categoryName){

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}

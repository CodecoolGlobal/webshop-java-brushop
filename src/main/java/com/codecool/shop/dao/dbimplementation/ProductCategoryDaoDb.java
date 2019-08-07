package com.codecool.shop.dao.dbimplementation;

import com.codecool.shop.dao.Dbconnection;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProductCategoryDaoDb implements ProductCategoryDao {
    private static ProductCategoryDaoDb instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private ProductCategoryDaoDb() {
    }

    public static ProductCategoryDaoDb getInstance() {
        if (instance == null) {
            instance = new ProductCategoryDaoDb();
        }
        return instance;
    }


    Dbconnection dbconnection = new Dbconnection();

    @Override
    public void add(ProductCategory category) {

    }

    @Override
    public ProductCategory find(int id) {

        try {
            Connection connection = dbconnection.connect();
            Statement statement = connection.createStatement();
            String select;

            select = "SELECT * FROM product_categories WHERE id=%{id}s";
            ResultSet selectResult = statement.executeQuery(select);

            if (selectResult.next()) {
                String resultName = selectResult.getString("name");
                int resultId = selectResult.getInt("id");
                String resultDescription = selectResult.getString("description");
                String resultDepartment = selectResult.getString("department");

                ProductCategory returnCateg = new ProductCategory(resultName, resultDepartment, resultDescription);
                returnCateg.setId(resultId);

                statement.close();
                connection.close();
                selectResult.close();

                return returnCateg;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }

    public static void main(String[] args) {
        ProductCategoryDaoDb astfgl = new ProductCategoryDaoDb();
        ProductCategory myCat = new ProductCategory("a", "b", "c");
        astfgl.add(myCat);
    }
}

package com.codecool.shop.dao.dbimplementation;

import com.codecool.shop.dao.Dbconnection;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.*;
import java.util.List;

public class ProductCategoryDaoDb implements ProductCategoryDao {
    private static ProductCategoryDaoDb instance = null;
    Connection connection = null;

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
        final String addStatement = "INSERT INTO product_categories (name, department, description)" +
                "VALUES(?, ?, ?)";


        String categoryDepartment = category.getDepartment();
        String categoryDescription = category.getDescription();
        String categoryName = category.getName();


        try {
            connection = dbconnection.connect();

            PreparedStatement preparedAddStatement = connection.prepareStatement(addStatement);
            //preparedAddStatement.setInt(1, 4);
            preparedAddStatement.setString(1, categoryName);
            preparedAddStatement.setString(2, categoryDepartment);
            preparedAddStatement.setString(3, categoryDescription);

            preparedAddStatement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                System.out.println("Could not close connection");
            }
        }
    }


    @Override
    public ProductCategory find(int id) {
        final String selectQuery = "SELECT * FROM product_categories WHERE id=?";

        try {

            Connection connection = dbconnection.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String resultName = resultSet.getString("name");
                int resultId = resultSet.getInt("id");
                String resultDescription = resultSet.getString("description");
                String resultDepartment = resultSet.getString("department");

                ProductCategory returnCateg = new ProductCategory(resultName, resultDepartment, resultDescription);
                returnCateg.setId(resultId);

                preparedStatement.close();
                resultSet.close();

                System.out.println(returnCateg);
                return returnCateg;
            }

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
        return null;
    }



    @Override
    public void remove(int id) {
        final String removeQuery = "DELETE FROM product_categories WHERE id = ?";

        try{
            Connection connection = dbconnection.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(removeQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

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

    // returns 0 if no category was found
    public int getCategoryId(String categoryName){
        final String findCategoryQuery = "SELECT id FROM product_categories WHERE name = ?";
        int resultId;

        try {
            Connection connection = dbconnection.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(findCategoryQuery);
            preparedStatement.setString(1, categoryName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                resultId = resultSet.getInt("id");
                return resultId;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } return 0;
    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }

}

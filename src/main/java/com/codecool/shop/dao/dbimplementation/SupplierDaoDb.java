package com.codecool.shop.dao.dbimplementation;

import com.codecool.shop.dao.Dbconnection;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoDb implements SupplierDao {
    private static SupplierDaoDb instance = null;
    private Dbconnection dbconnection = new Dbconnection();
    private List<Supplier> data = new ArrayList<>();

    /* A private Constructor prevents any other class from instantiating.
     */
    private SupplierDaoDb() {
    }

    public static SupplierDaoDb getInstance() {
        if (instance == null) {
            instance = new SupplierDaoDb();
        }
        return instance;
    }


    @Override
    public void add(Supplier supplier) {

    }

    @Override
    public Supplier find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Supplier> getAll() {
        final String selectQuery = "SELECT * FROM suppliers";
        int rowCount = 0;
        int columnCount = 0;

        try {
            Connection connection = dbconnection.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Supplier supplier = new Supplier(name, description);
                supplier.setId(id);
                supplier.setDescription(description);
                data.add(supplier);

            }
            System.out.println(data);
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SupplierDaoDb abc = new SupplierDaoDb();
        abc.getAll();
    }


}

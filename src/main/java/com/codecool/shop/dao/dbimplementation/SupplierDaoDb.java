package com.codecool.shop.dao.dbimplementation;

import com.codecool.shop.dao.Dbconnection;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

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
        return null;
    }
}

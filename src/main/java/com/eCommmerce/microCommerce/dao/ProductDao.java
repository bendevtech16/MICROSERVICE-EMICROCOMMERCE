package com.eCommmerce.microCommerce.dao;

import com.eCommmerce.microCommerce.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();
    public  Product findById(int id);
    public Product save(Product product);
}

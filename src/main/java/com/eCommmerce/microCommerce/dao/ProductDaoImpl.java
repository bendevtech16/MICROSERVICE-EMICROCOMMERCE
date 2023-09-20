package com.eCommmerce.microCommerce.dao;

import com.eCommmerce.microCommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    public  static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(3,new String("ordinateur"),"les ordinateurs lourd",4300,2000));
        products.add(new Product(5,new String("montre"),"les montres connectes",400,100));
        products.add(new Product(2,new String("mouse"),"la souris sans fils",5000,3000));
        products.add(new Product(1,new String("Cahiers"),"les cahiers de la gloire ",450,200));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product P: products) {
            if(P.getId() == id){
                return  P;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}

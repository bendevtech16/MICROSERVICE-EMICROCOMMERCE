package com.eCommmerce.microCommerce.controller;

import com.eCommmerce.microCommerce.dao.ProductDao;
import com.eCommmerce.microCommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;
    //produits

    @GetMapping(value = "produits")
    public List<Product> listProducts(){
        return productDao.findAll();
    }
    //Produits/{id} ie donc aller chercher un produit par son id.

    @GetMapping(value = "produits/{id}")
    public Product afficheUnProduit(@PathVariable int id){
    return productDao.findById(10);
    }
    @PostMapping(value ="/produit")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product){
    Product product1 = productDao.save(product);
    if (product==null){
        return ResponseEntity.noContent().build();
    }
    //on recupere l'uri du produit en cas d'ajout de produit.
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}") //on passe l  'id du produit ajouter
                .buildAndExpand(product1.getId())// on remplace cet id pas son contenu
                .toUri(); // transforme le tout en URI
        return  ResponseEntity.created(location).build();//on appel build pour construire cette reponse.
    }
}

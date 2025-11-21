package com.ilyass.service_catalogue.service;

import com.ilyass.service_catalogue.domaine.entity.Product;

import java.util.List;

public interface IServiceProduct {
    Product createProduct(Product product);

    Product getProductById(Long id);

    Product getProductByName(String name);

    Product updateProduct(Product product);

    List<Product> getAllProducts();

    void deleteProduct(Product product);
}

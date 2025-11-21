package com.ilyass.service_catalogue.service.impl;

import com.ilyass.service_catalogue.domaine.entity.Product;
import com.ilyass.service_catalogue.repository.ProductRepository;
import com.ilyass.service_catalogue.service.IServiceProduct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceProductImpl implements IServiceProduct {
    private final ProductRepository productRepository;

    @Autowired
    public ServiceProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new
                EntityNotFoundException("Product not found" + id));
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElseThrow(()
                -> new EntityNotFoundException("Product not found" + name));
    }

    @Override
    public Product updateProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            Product oldProduct = productRepository.findById(product.getId()).get();
            oldProduct.setName(product.getName());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setCategory(product.getCategory());
            oldProduct.setStatus(product.getStatus());
            oldProduct.setCategory(product.getCategory());
            oldProduct.setStock(product.getStock());
            return productRepository.save(oldProduct);
        } else throw new EntityNotFoundException("Product not found" + product.getId());
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            productRepository.deleteById(product.getId());
        } else throw new EntityNotFoundException("Product not found" + product.getId());
    }
}

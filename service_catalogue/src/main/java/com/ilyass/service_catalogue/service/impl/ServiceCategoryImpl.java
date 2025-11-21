package com.ilyass.service_catalogue.service.impl;

import com.ilyass.service_catalogue.domaine.entity.Category;
import com.ilyass.service_catalogue.repository.CategoryRepository;
import com.ilyass.service_catalogue.service.IServiceCategory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceCategoryImpl implements IServiceCategory {
    private final CategoryRepository categoryRepository;

    @Autowired
    public ServiceCategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new
                EntityNotFoundException("Role not found" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            Category oldCategory = categoryRepository.findById(category.getId()).get();
            oldCategory.setName(category.getName());
            if (category.getProducts() != null) {
                oldCategory.setProducts(category.getProducts());
            }
            return categoryRepository.save(oldCategory);
        } else throw new EntityNotFoundException("Category not found" + category.getId());
    }

    @Override
    public void deleteCategory(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            categoryRepository.deleteById(category.getId());
        } else throw new EntityNotFoundException("Category not found" + category.getId());
    }
}

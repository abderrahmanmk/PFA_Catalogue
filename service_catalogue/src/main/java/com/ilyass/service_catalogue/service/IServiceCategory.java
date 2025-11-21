package com.ilyass.service_catalogue.service;

import com.ilyass.service_catalogue.domaine.entity.Category;

import java.util.List;

public interface IServiceCategory {
    Category createCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);
}

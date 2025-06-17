package com.ecommerce.Project.Service;

import com.ecommerce.Project.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    void CreateCategory(Category category);

    String deleteCategory(long categoryId);

    Category UpdateCategory(Category category, Long categoryId);
}

package com.ecommerce.Project.Service;

import com.ecommerce.Project.controller.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    List<Category> categoryList = new ArrayList<>();
    private long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categoryList;
    }

    @Override
    public void CreateCategory(Category category) {
        category.setId(nextId++);
        categoryList.add(category);
    }

    @Override
    public String deleteCategory(long categoryId) {
        Category category = categoryList.stream()
                .filter(c -> c.getId().equals(categoryId))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Category with id " + categoryId + " not found"
                        )
                );
        categoryList.remove(category);
        return "Category with id " + categoryId + " deleted successfully";

    }

    @Override
    public Category UpdateCategory(Category category, Long categoryId) {
        Optional OptionalCategory = categoryList.stream()
                .filter(c -> c.getId().equals(categoryId))
                .findFirst();

        if(OptionalCategory.isPresent()){
            Category existingCategory = (Category) OptionalCategory.get();
            existingCategory.setName(category.getName());
            return existingCategory;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Category with id " + categoryId + " not found");
        }
    }
}

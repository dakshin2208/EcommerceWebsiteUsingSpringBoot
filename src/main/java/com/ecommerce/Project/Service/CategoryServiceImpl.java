package com.ecommerce.Project.Service;

import com.ecommerce.Project.model.Category;
import com.ecommerce.Project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {
//    List<Category> categoryList = new ArrayList<>();
    private long nextId = 1L;


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void CreateCategory(Category category) {
//        category.setId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(long categoryId) {
//        List<Category> categoryList = categoryRepository.findAll();
//        Category category = categoryList.stream()
//                .filter(c -> c.getId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(() ->
//                        new ResponseStatusException(
//                                HttpStatus.NOT_FOUND,
//                                "Category with id " + categoryId + " not found"
//                        )
//                );
//        categoryRepository.delete(category);
//        return "Category with id " + categoryId + " deleted successfully";

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        categoryRepository.delete(category);
        return "Category with id :" + categoryId + " has been deleted Successfully";

    }

    @Override
    public Category UpdateCategory(Category category, Long categoryId) {
//        List<Category> categoryList = categoryRepository.findAll();
//        Optional OptionalCategory = categoryList.stream()
//                .filter(c -> c.getId().equals(categoryId))
//                .findFirst();
//
//        if(OptionalCategory.isPresent()){
//            Category existingCategory = (Category) OptionalCategory.get();
//            existingCategory.setName(category.getName());
//            Category savedCategory = categoryRepository.save(existingCategory);
//            return savedCategory;
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                    "Category with id " + categoryId + " not found");

        Category updatedCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        updatedCategory.setName(category.getName());
        return categoryRepository.save(updatedCategory);
        }

    }


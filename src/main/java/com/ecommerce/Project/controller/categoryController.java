package com.ecommerce.Project.controller;
import com.ecommerce.Project.Service.CategoryService;
import com.ecommerce.Project.controller.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class categoryController {

    private CategoryService categoryService;

    public categoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/category")
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories,HttpStatus.OK);
    }

    @PostMapping("/api/public/category")
     public ResponseEntity<String> addCategory(@RequestBody Category category) {
        categoryService.CreateCategory(category);
        return new ResponseEntity<>("Category created Successfully", HttpStatus.CREATED);

     }

     @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> DeleteCategory(@PathVariable long categoryId){
         try {
             String status = categoryService.deleteCategory(categoryId);
             return new ResponseEntity<>(status ,HttpStatus.OK);

         }catch (ResponseStatusException e){
             return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
         }
     }

     @PutMapping("/api/admin/categories/{categoryId}")
     public ResponseEntity<String> UpdateCategory(@RequestBody Category category,
                                                  @PathVariable Long categoryId) {

        try{
            Category updateCategory = categoryService.UpdateCategory(category,categoryId);
            return new ResponseEntity<>("category with id  : "+categoryId , HttpStatus.OK);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

     }
}

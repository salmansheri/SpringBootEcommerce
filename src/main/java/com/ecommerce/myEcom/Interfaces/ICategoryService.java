package com.ecommerce.myEcom.Interfaces;

import java.util.List;

import com.ecommerce.myEcom.Models.Category;

public interface ICategoryService {
    List<Category> getAllCategories(); 

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Long categoryId, Category updatedCategory); 
    
    
}

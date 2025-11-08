package com.ecommerce.myEcom.Services;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.myEcom.Interfaces.ICategoryService;
import com.ecommerce.myEcom.Models.Category;
import com.ecommerce.myEcom.Repositories.ICategoryRepository;



@Service
public class CategoryService implements ICategoryService {

    // private List<Category> categories = new ArrayList<>();
   

    @Autowired
    private ICategoryRepository categoryRepo;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();

    }

    @Override
    public void createCategory(Category category) {
        // category.setId(nextId++);

        if (category == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category cannot be null"); 
        }

        categoryRepo.save(category);
    }

    @Override
    public String deleteCategory(long categoryId) {
      
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category to Delete was not found")); 

        
         categoryRepo.delete(category); 

        return "Category Deleted successfully";

    }

    @Override
    public Category updateCategory(long categoryId, Category updatedCategory) {

        if (updatedCategory == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category Cannot be null"); 
        }

        Optional<Category> savedCategoryOptional = categoryRepo.findById(categoryId);

        Category savedCategory = savedCategoryOptional.orElseThrow(() -> new 
        ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found")); 
       
        updatedCategory.setId(categoryId); 

        savedCategory = categoryRepo.save(updatedCategory); 

        return savedCategory; 

      

    }

}

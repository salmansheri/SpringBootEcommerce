package com.ecommerce.myEcom.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.myEcom.Interfaces.ICategoryService;
import com.ecommerce.myEcom.Models.Category;

@Service
public class CategoryService implements ICategoryService {

    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;

    }

    @Override
    public void createCategory(Category category) {
        category.setId(nextId++);

        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
                .filter(c -> c.getId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not found!"));

        categories.remove(category);

        return "Category Deleted Successfully";

    }

    @Override
    public Category updateCategory(Long categoryId, Category updatedCategory) {
        Optional<Category> category = categories.stream()
                .filter(c -> c.getId().equals(categoryId))
                .findFirst();

        if (category.isPresent()) {
            Category existingCategory = category.get();
            existingCategory.setName(updatedCategory.getName());
            return existingCategory;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }

    }

}

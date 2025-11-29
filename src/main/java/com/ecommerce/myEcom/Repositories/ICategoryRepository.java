package com.ecommerce.myEcom.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.myEcom.Models.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name); 

}

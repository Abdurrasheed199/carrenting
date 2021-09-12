package com.rent.carrenting.repository;

import com.rent.carrenting.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByName(String name);
}

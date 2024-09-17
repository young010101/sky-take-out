package com.sky.service;

import com.sky.dto.CategoryDTO;

public interface CategoryService {
    /**
     * Add a new category.
     * @param categoryDTO The category to add.
     */
    void addCategory(CategoryDTO categoryDTO);
}

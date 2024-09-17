package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

public interface CategoryService {
    /**
     * Add a new category.
     * @param categoryDTO The category to add.
     */
    void addCategory(CategoryDTO categoryDTO);

    /**
     * Query category list.
     * @param categoryPageQueryDTO The query conditions.
     * @return The category list.
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * Enable or disable category.
     * @param status The status to set.
     * @param id The category id.
     */
    void enableOrDisable(int status, long id);
}

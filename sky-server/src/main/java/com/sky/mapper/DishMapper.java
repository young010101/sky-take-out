package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {
    /**
     * Count the number of dishes in the category.
     * @param categoryId The category id.
     * @return The number of dishes.
     */
    @Select("SELECT COUNT(id) FROM dish WHERE category_id = #{categoryId}")
    int countByCategoryId(long categoryId);
}

package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {
    /**
     * Count the number of set meals in the category.
     * @param categoryId The category id.
     * @return The number of set meals.
     */
    @Select("SELECT COUNT(id) FROM setmeal WHERE category_id = #{categoryId}")
    int countByCategoryId(long categoryId);
}

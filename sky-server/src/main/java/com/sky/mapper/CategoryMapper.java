package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * Add a new category.
     * @param category The category to add.
     */
    @Insert("INSERT INTO category (type, name, sort, status, create_time, update_time, create_user, update_user) " +
            "VALUES (#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void addCategory(Category category);

    /**
     * Query category list.
     * @param categoryPageQueryDTO The query conditions.
     * @return The category list.
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);


    /**
     * update category by id
     * @param category The category to update.
     */
    void update(Category category);

    /**
     * Query category list by type.
     * @param type The category type.
     * @return The category list.
     */
//    @Select("SELECT * FROM category WHERE type = #{type}")
    List<Category> listByType(int type);

    /**
     * Delete category by id.
     * @param id The category id.
     */
    @Delete("DELETE FROM category WHERE id = #{id}")
    void deleteById(long id);
}

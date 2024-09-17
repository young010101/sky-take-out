package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.CategoryMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final DishMapper dishMapper;
    private final SetmealMapper setmealMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper, DishMapper dishMapper, SetmealMapper setmealMapper) {
        this.categoryMapper = categoryMapper;
        this.dishMapper = dishMapper;
        this.setmealMapper = setmealMapper;
    }

    /**
     * Add a new category.
     * @param categoryDTO The category to add.
     */
    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();

        BeanUtils.copyProperties(categoryDTO, category);
        category.setStatus(StatusConstant.DISABLE);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());

        categoryMapper.addCategory(category);
    }

    /**
     * Query category list.
     *
     * @param categoryPageQueryDTO The query conditions.
     * @return The category list.
     */
    @Override
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(), categoryPageQueryDTO.getPageSize());

        Page<Category> categoryPage = categoryMapper.pageQuery(categoryPageQueryDTO);
        long total = categoryPage.getTotal();
        return new PageResult(total, categoryPage.getResult());
    }

    /**
     * Enable or disable category.
     *
     * @param status The status to set.
     * @param id     The category id.
     */
    @Override
    public void enableOrDisable(int status, long id) {
        Category category = Category.builder()
                .status(status)
                .id(id)
                .build();
        categoryMapper.update(category);
    }

    /**
     * Update category.
     *
     * @param categoryDTO The category to update.
     */
    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.update(category);
    }

    /**
     * Query category list by type.
     *
     * @param type The category type.
     * @return The category list.
     */
    @Override
    public List<Category> listByType(int type) {
        return categoryMapper.listByType(type);
    }

    /**
     * Delete category by id.
     *
     * @param id The category id.
     */
    @Override
    public void deleteById(long id) {
        if (dishMapper.countByCategoryId(id) > 0) {
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_DISH);
        }

        if (setmealMapper.countByCategoryId(id) > 0) {
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_SETMEAL);
        }

       categoryMapper.deleteById(id);
    }
}

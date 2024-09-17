package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类管理")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Add a new category.
     * @param categoryDTO The category to add.
     */
    @PostMapping
    @ApiOperation("添加分类")
    public Result<?> addCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("添加分类：{}", categoryDTO);
        categoryService.addCategory(categoryDTO);
        return Result.success();
    }

    /**
     * Query category list.
     * @return The category list.
     */
    @GetMapping("/page")
    @ApiOperation("分页查询分类")
    public Result<PageResult> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分页查询分类：{}", categoryPageQueryDTO);
        return Result.success(categoryService.pageQuery(categoryPageQueryDTO));
    }

    /**
     * Enable or disable category.
     * @return The result.
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用或禁用分类")
    public Result<?> enableOrDisable(@PathVariable int status, long id) {
        log.info("启用或禁用分类：status={}, id={}", status, id);
        categoryService.enableOrDisable(status, id);
        return Result.success();
    }
}

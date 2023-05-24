package com.example.springboot.controller;


import com.example.springboot.config.JsonResult;
import com.example.springboot.entity.Category;
import com.example.springboot.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 帖子的种类
 */
@Api
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @ApiOperation(value = "分类列表")
    @GetMapping("/CategoryList")
    public JsonResult CategoryList() {
        List<Category> list = categoryService.list();
        return JsonResult.success(list);
    }


}

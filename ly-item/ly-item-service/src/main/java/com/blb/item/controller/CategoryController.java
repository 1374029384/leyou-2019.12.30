package com.blb.item.controller;

import com.blb.item.service.CategoryService;
import com.blb.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> queryByParentId(@RequestParam("pid") Long id){
        List<Category> categoryList = categoryService.queryByParentId(id);
        if(null!=categoryList&&categoryList.size()>0){
            return  ResponseEntity.ok(categoryList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("bid/{bid}")
    public ResponseEntity<List<Category>> queryByBrandId(@PathVariable("bid") Long id){
            List<Category> categoryList = categoryService.queryByBrandId(id);
            if(categoryList!=null && categoryList.size()>0){
                    return ResponseEntity.ok(categoryList);
            }
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

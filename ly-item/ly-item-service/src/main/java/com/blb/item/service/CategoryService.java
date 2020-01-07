package com.blb.item.service;

import com.blb.item.mapper.CategoryMapper;
import com.blb.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryByParentId(Long id) {
        //select * from tb_category where parent_id = id;
        Category category = new Category();
        category.setParentId(id);
        return categoryMapper.select(category);
    }

    public List<Category> queryByBrandId(Long id) {
        return  categoryMapper.queryBrandId(id);
    }
}

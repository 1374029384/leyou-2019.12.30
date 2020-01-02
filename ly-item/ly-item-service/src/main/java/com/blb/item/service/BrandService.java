package com.blb.item.service;

import com.blb.common.po.PageResult;
import com.blb.item.mapper.BrandMapper;
import com.blb.pojo.Brand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> pageQuery(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //开启分页
        PageHelper.startPage(page,rows);
        //查询条件
        Example example = new Example(Brand.class);

        if(StringUtils.isNotBlank(key)){
            //获得一个对象
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("name","%"+key+"%");
        }
        //排序
        if(StringUtils.isNotBlank(sortBy)){
            example.setOrderByClause(sortBy+ (desc?" desc":" asc"));
        }
        //查询
         Page<Brand> page1 = (Page<Brand>) brandMapper.selectByExample(example);

    //    private Long total;//一共有多少条数据
     //   private Long totalPage;//一共多少页
        //private List<T> items;//每页显示的数据

         return  new PageResult<>(page1.getTotal(),new Long(page1.getPages()),page1
         .getResult());
    }
}

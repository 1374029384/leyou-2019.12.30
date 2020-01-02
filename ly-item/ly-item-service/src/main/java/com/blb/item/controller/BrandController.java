package com.blb.item.controller;

import com.blb.common.po.PageResult;
import com.blb.item.service.BrandService;
import com.blb.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> pageQuery(@RequestParam(value = "page",defaultValue ="1") Integer page,
                                                       @RequestParam(value = "rows",defaultValue = "5") Integer rows,
                                                       @RequestParam(value = "sortBy",required = false) String sortBy,
                                                       @RequestParam(value = "desc",required = false) Boolean desc,
                                                       @RequestParam(value = "key",required = false) String key
                                                       ){
       PageResult<Brand> pageResult = brandService.pageQuery(page,rows,sortBy,desc,key);
       if(null!=pageResult&&pageResult.getItems().size()>0){
                return  ResponseEntity.ok(pageResult);
       }
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

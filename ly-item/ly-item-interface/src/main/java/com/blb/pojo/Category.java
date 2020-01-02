package com.blb.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id; //类目Id
    private  String name; //类目名称
    private  Long parentId; //父类目id,顶级类目是0
    private  Boolean isParent; //是否为父节点,0为否,1为是
    private  String sort; //排序指数,越小越往前
}

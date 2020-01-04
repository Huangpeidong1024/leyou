package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
    * @Description 根据父节点查询子节点
    * @Author: HuangPeiDong
    * @Date: 2020/1/2 13:15
    * @Param: [pid]
    * @Return: java.util.List<com.leyou.item.pojo.Category>
    **/
    List<Category> queryCategoriesByPid(Long pid);
}

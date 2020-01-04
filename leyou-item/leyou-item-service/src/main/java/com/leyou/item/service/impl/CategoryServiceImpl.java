package com.leyou.item.service.impl;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @ProjectName: leyou
 * @Package: com.leyou.item.service.impl
 * @Author: HuangPeiDong
 * @CreateDate: 2020/1/2 12:51
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryMapper categoryMapper;

/**
* @Description: 根据父节点查询子节点
* @Author: HuangPeiDong
* @Date: 2020/1/2 13:17
* @Param: [pid]
* @Return: java.util.List<com.leyou.item.pojo.Category>
**/
    @Override
    public List<Category> queryCategoriesByPid(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return this.categoryMapper.select(record);
    }
}

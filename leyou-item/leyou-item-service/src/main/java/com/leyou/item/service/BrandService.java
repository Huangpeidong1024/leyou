package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;

/**
 * @Description: TODO
 * @ProjectName: leyou
 * @Package: com.leyou.item.service
 * @Author: HuangPeiDong
 * @CreateDate: 2020/1/4 23:58
 */
public interface BrandService {

    /**
     * @Description:根据查询条件分页并排序查询商品信息
     * @Author: HuangPeiDong
     * @Date: 2020/1/5 0:32
     * @Param: [key, page, rows, sortBy, desc]
     * @Return: com.leyou.common.pojo.PageResult<com.leyou.item.pojo.Brand>
     **/
    PageResult<Brand> queryBrandByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);
}

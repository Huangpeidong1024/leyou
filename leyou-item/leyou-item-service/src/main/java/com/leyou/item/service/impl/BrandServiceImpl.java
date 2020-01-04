package com.leyou.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @Description: TODO
 * @ProjectName: leyou
 * @Package: com.leyou.item.service.impl
 * @Author: HuangPeiDong
 * @CreateDate: 2020/1/5 0:00
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        //分页
        PageHelper.startPage(page,rows);
        /**
         * WHERE 'name' LIKE "%x%" OR letter == 'x'
         * ORDER BY id DESC
         * */
        //根据name模糊查询，或者根据首字母查询
        Example example = new Example(Brand.class);
        if(StringUtils.isNotBlank(key)){
            //过滤条件
            example.createCriteria().orLike("name", "%"+key+"%")
                    .orEqualTo("letter", key.toUpperCase());
        }
        //排序条件
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + (desc ? " DESC" : " ASC"));
        }
        //查询条件
        List<Brand> brands = this.brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brands)) {
//            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        //创建PageInfo,解析分页结果，获得总条数Total
        PageInfo<Brand> pageInfo=new PageInfo<>(brands);
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }
}

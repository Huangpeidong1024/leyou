package com.leyou.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description:
 * @Author: HuangPeiDong
 * @Date: 2020/1/4 22:24
 **/
@Table(name = "tb_brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 品牌名称
    private String name;

    // 品牌图片
    private String image;

    private Character letter;

}
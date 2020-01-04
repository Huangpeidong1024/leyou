package com.leyou.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @ProjectName: leyou
 * @Package: com.leyou.common.pojo
 * @Author: HuangPeiDong
 * @CreateDate: 2020/1/4 23:41
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult<T> {
    private Long total;
    private Integer totalPage;
    private List<T> items;

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}

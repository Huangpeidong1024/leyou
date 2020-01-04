package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;
import java.util.Collection;
import java.util.List;

/**
 * @Description: TODO
 * @ProjectName: leyou
 * @Package: com.leyou.item.controller
 * @Author: HuangPeiDong
 * @CreateDate: 2020/1/2 12:54
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
    * @Description: 根据父节点查询子节点
    * @Author: HuangPeiDong
    * @Date: 2020/1/2 13:17
    * @Param: [pid]
    * @Return: org.springframework.http.ResponseEntity<java.util.List<com.leyou.item.pojo.Category>>
    **/
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
        if (pid == null || pid < 0) {
            //参数不合法 400
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.badRequest().build();
        }
        List<Category> categories = this.categoryService.queryCategoriesByPid(pid);
        if (CollectionUtils.isEmpty(categories)) {
            //资源服务未找到 404
            return ResponseEntity.notFound().build();
        }
        //查询成功 200
        return ResponseEntity.ok(categories);
    }
}

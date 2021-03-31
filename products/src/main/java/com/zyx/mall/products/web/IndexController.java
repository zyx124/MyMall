package com.zyx.mall.products.web;

import com.zyx.mall.products.entity.CategoryEntity;
import com.zyx.mall.products.service.CategoryService;
import com.zyx.mall.products.vo.Catalog2VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class IndexController {
    @Autowired
    CategoryService categoryService;

    @GetMapping({"/", "/index.html"})
    public String indexPage(Model model) {
        // check all the first level categories
        List<CategoryEntity> categoryEntities = categoryService.getFirstLevelCategories();

        model.addAttribute("categories", categoryEntities);
        return "index";
    }

    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catalog2VO>> getCatalogJson() {
        Map<String, List<Catalog2VO>> map = categoryService.getCatalogJson();
        return map;
    }
}

package com.jxufe.sell.repository;

import com.jxufe.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    //使得查询数据为一个list的集合
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

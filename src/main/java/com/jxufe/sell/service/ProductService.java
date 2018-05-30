package com.jxufe.sell.service;

import com.jxufe.sell.dataobject.ProductInfo;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    //查询所有在架商品
    List<ProductInfo> findUpAll();

    List<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //件库存
}

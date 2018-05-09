package com.jxufe.sell.repository;

import com.jxufe.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private  ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findById(2).get();
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){



        //通过自增id可以直接添加数据
        //ProductCategory productCategory = new ProductCategory();
        //productCategory.setCategoryName("男生最爱");
        //productCategory.setCategoryType(3);

        //更新--创建时间也会更改
//        productCategory.setCategoryId(2);
//        productCategory.setCategoryName("女生最爱");
//        productCategory.setCategoryType(3);

        //更新--不改变时间  因为是查询出来的   加上注解以后改变值的话就会改时间
        ProductCategory productCategory = repository.findById(2).get();
        productCategory.setCategoryType(3);

        repository.save(productCategory);
    }

    @Test
    @Transactional  //测试后不在数据库留下数据，直接回滚删除数据
    public void  saveTest1(){
        ProductCategory productCategory = new ProductCategory("女生最爱",3);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);//断言
//        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeIn(){

        //需要一个无参构造方法
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}
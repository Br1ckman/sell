package com.jxufe.sell.repository;

import com.jxufe.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private  ProductCategoryRepository repository;

    @Test
    public  void findOneTest(){
        Optional<ProductCategory> productCategory = repository.findById(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){

        ProductCategory productCategory = new ProductCategory();
        //repository.findOne(2);

        //通过id可以更改值
        productCategory.setCategoryType(10);
        repository.save(productCategory);
    }
}
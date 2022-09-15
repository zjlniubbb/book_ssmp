package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@SpringBootTest

public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(9));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("测试数据1");
        book.setType("测试数据1");
        book.setDescription("测试数据1");

        System.out.println(bookDao.insert(book));
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(10);
        book.setName("测试数据111");
        book.setType("测试数据111");
        book.setDescription("测试数据111");
        System.out.println(bookDao.updateById(book));
    }

    @Test
    void testDelete(){
        System.out.println(bookDao.deleteById(10));
    }

    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage(){
        Page page = new Page(1,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("name","日");
        bookDao.selectList(wrapper);
    }

    @Test
    void testGetBy2(){
        String des = "爱";
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(des!=null,Book::getDescription,des);
        bookDao.selectList(wrapper);
    }

}

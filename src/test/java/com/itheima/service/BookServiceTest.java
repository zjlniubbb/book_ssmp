package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("测试数据aaa");
        book.setType("测试数据aaa");
        book.setDescription("测试数据aaa");

        System.out.println(bookService.save(book));
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(15);
        book.setName("测试数据111");
        book.setType("测试数据111");
        book.setDescription("测试数据111");
        System.out.println(bookService.update(book));
    }

    @Test
    void testDelete(){
        System.out.println(bookService.delete(15));
    }

    @Test
    void testGetAll(){
        System.out.println(bookService.getAll());
    }

    @Test
    void testGetPage(){

        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }

//    @Test
//    void testGetBy(){
//        QueryWrapper<Book> wrapper = new QueryWrapper<>();
//        wrapper.like("name","日");
//        bookService.selectList(wrapper);
//    }
//
//    @Test
//    void testGetBy2(){
//        String des = "爱";
//        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(des!=null,Book::getDescription,des);
//        bookService.selectList(wrapper);
//    }
}

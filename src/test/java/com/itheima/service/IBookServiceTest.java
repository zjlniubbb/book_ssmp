package com.itheima.service;

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
public class IBookServiceTest {

    @Autowired
    private IBookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("测试数据bbb");
        book.setType("测试数据bbb");
        book.setDescription("测试数据bbb");

        System.out.println(bookService.save(book));
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(16);
        book.setName("测试数据ccc");
        book.setType("测试数据ccc");
        book.setDescription("测试数据ccc");
        System.out.println(bookService.updateById(book));
    }

    @Test
    void testDelete(){
        System.out.println(bookService.removeById(9));
    }

    @Test
    void testGetAll(){
        System.out.println(bookService.list());
    }

    @Test
    void testGetPage(){

        Page page = new Page(2, 5);
        bookService.page(page);
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

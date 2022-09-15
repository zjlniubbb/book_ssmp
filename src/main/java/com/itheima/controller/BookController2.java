package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import com.itheima.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService iBookService;

    @GetMapping()
    public MyUtils getAll(){
        return new MyUtils(true,iBookService.list());
    }

    @PostMapping()
    public MyUtils save(@RequestBody Book book) throws Exception {
//        MyUtils myUtils = new MyUtils();
//        boolean save = iBookService.save(book);
//        myUtils.setFlag(save);
        if (book.getName().equals("666"))throw new Exception();
        boolean flag = iBookService.save(book);
        return new MyUtils(flag,null,flag?"添加成功^_^":"添加失败-_-!");
    }

    @PutMapping()
    public MyUtils update(@RequestBody Book book){
        return new MyUtils( iBookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public MyUtils delete(@PathVariable Integer id){
        return new MyUtils( iBookService.removeById(id));
    }

    @GetMapping("{id}")
    public MyUtils getById(@PathVariable Integer id){
        return new MyUtils(true,iBookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public MyUtils getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        IPage<Book> page = iBookService.getPage(currentPage, pageSize);
        if (currentPage > page.getPages()){
             page = iBookService.getPage((int)page.getPages(), pageSize);
        }
        return new MyUtils(true,page);
    }
}

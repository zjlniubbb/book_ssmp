package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author zjlniubbb
 * @version 1.0
 */
//@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("/getAll")
    public List<Book> getAll(){
        return iBookService.list();
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody Book book){
        return iBookService.save(book);
    }

    @PutMapping("/update")
    public Boolean update(@RequestBody Book book){
        return iBookService.updateById(book);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        return iBookService.removeById(id);
    }

    @GetMapping("/getById/{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id);
    }

    @GetMapping("/getPage/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){

        return iBookService.getPage(currentPage, pageSize);
    }
}

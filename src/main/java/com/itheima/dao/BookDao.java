package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@Mapper
@Repository
public interface BookDao extends BaseMapper<Book> {
//
//    @Select("select * from book where id=#{id}")
//     Book getById(Integer id);

}

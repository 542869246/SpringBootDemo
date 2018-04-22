package com.example.springbootdemo.dao;

import com.example.springbootdemo.pojo.BookInfo;
import com.example.springbootdemo.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper {

	List<BookInfo> findAll(@Param("book_type") Integer book_type,
                           @Param("book_name") String book_name,
                           @Param("is_borrow") Integer is_borrow,
                           @Param("form") Integer currentPageNo,
                           @Param("pageSize") Integer pageSize);

	int findCount(@Param("book_type") Integer book_type,
                  @Param("book_name") String book_name,
                  @Param("is_borrow") Integer is_borrow);

	Users findByUser(@Param("user_code") String code,
                     @Param("password") String pwd);
	
	int delById(Integer id);
	
	int update(BookInfo bookInfo);

	int add(BookInfo bookInfo);

}

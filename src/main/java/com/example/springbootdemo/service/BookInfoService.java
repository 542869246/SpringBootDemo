package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.BookInfo;
import com.example.springbootdemo.pojo.Users;

import java.util.List;

public interface BookInfoService {
	List<BookInfo> findAll(Integer book_type, String book_name, Integer is_borrow, Integer currentPageNo,
                           Integer pageSize);

	int findCount(Integer book_type, String book_name, Integer is_borrow);

	Users findByUser(String code, String pwd);

	int delById(Integer id);

	int update(BookInfo bookInfo);

	int add(BookInfo bookInfo);

}

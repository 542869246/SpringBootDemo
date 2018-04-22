package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.BookInfoMapper;
import com.example.springbootdemo.pojo.BookInfo;
import com.example.springbootdemo.pojo.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "bookInfoService")
public class BookInfoServiceImpl implements BookInfoService {
	@Resource(name = "bookInfoMapper")
	BookInfoMapper bookInfoMapper;

	public List<BookInfo> findAll(Integer bookType, String bookName,
			Integer isBorrow, Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return bookInfoMapper.findAll(bookType, bookName, isBorrow, currentPageNo, pageSize);
	}

	public Users findByUser(String code, String pwd) {
		// TODO Auto-generated method stub
		return bookInfoMapper.findByUser(code, pwd);
	}

	public int findCount(Integer book_type, String book_name,
			Integer is_borrow) {
		// TODO Auto-generated method stub
		return bookInfoMapper.findCount(book_type,book_name,is_borrow);
	}

	@Override
	public int delById(Integer id) {
		// TODO Auto-generated method stub
		return bookInfoMapper.delById(id);
	}

	@Override
	public int update(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return bookInfoMapper.update(bookInfo);
	}

	@Override
	public int add(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return bookInfoMapper.add(bookInfo);
	}

	

	

}

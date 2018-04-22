package com.example.springbootdemo.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class BookInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer book_id;
    private String book_code;
    private String book_name;
    private Integer book_type;
    private String book_atuthor;
    private String publish_press;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publish_date;
    private Integer is_borrow;
    private String createdBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creation_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date last_updatetime;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer bookId) {
        book_id = bookId;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String bookCode) {
        book_code = bookCode;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String bookName) {
        book_name = bookName;
    }

    public Integer getBook_type() {
        return book_type;
    }

    public void setBook_type(Integer bookType) {
        book_type = bookType;
    }

    public String getBook_atuthor() {
        return book_atuthor;
    }

    public void setBook_atuthor(String bookAtuthor) {
        book_atuthor = bookAtuthor;
    }

    public String getPublish_press() {
        return publish_press;
    }

    public void setPublish_press(String publishPress) {
        publish_press = publishPress;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publishDate) {
        publish_date = publishDate;
    }

    public Integer getIs_borrow() {
        return is_borrow;
    }

    public void setIs_borrow(Integer isBorrow) {
        is_borrow = isBorrow;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creationTime) {
        creation_time = creationTime;
    }

    public Date getLast_updatetime() {
        return last_updatetime;
    }

    public void setLast_updatetime(Date lastUpdatetime) {
        last_updatetime = lastUpdatetime;
    }

}

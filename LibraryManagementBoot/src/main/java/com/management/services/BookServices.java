package com.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.BookDao;
import com.management.model.Book;

import java.util.*;


@Service
public class BookServices {
	
	@Autowired
	private BookDao bookDao;
	
	public void addBook(Book book) {
		this.bookDao.save(book);
	}
	
	public List<Book> getBookList(){
		return this.bookDao.findAll();
	}
	
	public Book getBook(int id){
		return bookDao.findById(id);
	}
	
	
	
	public void updateBook(Book book) {
       bookDao.save(book);
    }
	
	public void deleteBook(int id) {
		Book entity = bookDao.findById(id);
		bookDao.delete(entity);
	}


}
package com.management.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.management.model.Book;
import com.management.services.BookServices;

import java.util.*;
@RestController
public class BookController {
	
	@Autowired
	private BookServices bookServices;

	@GetMapping("/")
	public String home() {
		return "<h1>Home</h1>";
	}
	
	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		this.bookServices.addBook(book);
		
	}
	
	@GetMapping("/books")
	public List<Book> getBookList(){
		return bookServices.getBookList();
	}
	
	
	
	@GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        return this.bookServices.getBook(bookId);
    }
	
	@PostMapping("/update")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		        bookServices.updateBook(book);
		        List<Book> bookList = bookServices.getBookList();
		        if (!bookList.isEmpty()) {
		            return ResponseEntity.ok(bookList);
		        } else {
		            return ResponseEntity.badRequest().body(false);
		        }
	}
	
	@PostMapping("/delete/{id}")
    public List<Book> delete(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        bookServices.deleteBook(id);
        List<Book> bookList = bookServices.getBookList();
        //mv.addObject(Constant.bookList, bookList);
        //mv.setViewName(Constant.bookListing);
        return bookList;
    }
	
}

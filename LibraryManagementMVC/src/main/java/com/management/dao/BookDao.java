package com.management.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.management.model.Book;

import java.util.*;

@Component
public class BookDao {

	 @Autowired
	    private HibernateTemplate hibernateTemplate;

	    @Transactional
	    public void saveToDatabase(Book book) {
	        this.hibernateTemplate.save(book);
	    }
    
	    public List<Book> getBook() {
	        List<Book> list = this.hibernateTemplate.loadAll(Book.class);
	        return list;
	    }

}

package com.management.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.AuthorDao;
import com.management.model.Author;

import java.util.*;

@Service
public class AuthorServices {

	@Autowired
	private AuthorDao authorDao;
	
	public void addAuthor(Author author) {
		this.authorDao.save(author);
	}
	
	public List<Author> getAuthor(){
		List<Author> list = this.authorDao.findAll();
		return list;
	}
	
	public Optional<Author> getAuthorById(String id) {
		return this.authorDao.findById(id);
	}
	
}
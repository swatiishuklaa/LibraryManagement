package com.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.model.Author;
import com.management.services.AuthorServices;

import java.util.*;

@RestController
public class AuthorController {

	@Autowired
	private AuthorServices authorServices;
	
	@PostMapping("/authors")
	public void addAuthor(Author author) {
		this.authorServices.addAuthor(author);
	}
	
	@GetMapping("/authors")
	public List<Author> getAuthors(){
		return this.authorServices.getAuthor();
	}
	
	@GetMapping("/authors/{id}")
	public Optional<Author> getAuthorById(String id) {
		return this.authorServices.getAuthorById(id);
		
	}
}
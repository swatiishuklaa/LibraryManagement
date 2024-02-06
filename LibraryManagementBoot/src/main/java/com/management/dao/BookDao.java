package com.management.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.management.model.Book;

public interface BookDao extends JpaRepository<Book,Integer> {
	
	Book findById(int id);
}

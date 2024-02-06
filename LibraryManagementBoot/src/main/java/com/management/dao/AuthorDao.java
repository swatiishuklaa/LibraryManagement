package com.management.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.model.Author;

public interface AuthorDao extends JpaRepository<Author,String> {
	Optional<Author> findById(String id);
}

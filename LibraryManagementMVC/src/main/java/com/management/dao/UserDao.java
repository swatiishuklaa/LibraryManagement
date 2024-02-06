package com.management.dao;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.management.model.User;

import java.util.*;


@Component
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void saveToDatabase(User user) {
		this.hibernateTemplate.save(user);
	}

	public List<User> getUsers() {
		List<User> list = this.hibernateTemplate.loadAll(User.class);
		return list;
	}

}

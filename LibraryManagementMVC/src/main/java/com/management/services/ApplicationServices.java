package com.management.services;

import java.util.*;

import com.management.dao.UserDao;
import com.management.model.User;

public class ApplicationServices {

	public boolean authenticate(UserDao userDao, String username, String password) {
		boolean result = false;

		List<User> userList = userDao.getUsers();

		for (User iter : userList) {
			if (iter.getUsername().equals(username) && iter.getPassword().equals(password)) {
				result = true;
			}
		}

		return result;
	}
}
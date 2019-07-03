package com.naresh.bankingapp.dao;

import java.util.List;

import com.naresh.bankingapp.dao.impl.UserDAOImpl;
import com.naresh.bankingapp.exception.DBException;
import com.naresh.bankingapp.model.User;

public class TestUserDAO {

	static UserDAO userDAO = new UserDAOImpl();

	public static void main(String[] args) {

		// registerUser();
		// login();
		//findOne();
		listUsers();
		// updateUser();

		// deleteUser();
	}

	private static void listUsers() {
		try {
			List<User> list = userDAO.list();
			System.out.println(list);
			if (list != null) {
				for (User user : list) {
					System.out.println(user);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	private static void registerUser() {
		String name = "ravi";
		String email = "ravi@gmail.com";
		String password = "pass123";

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);

		try {
			userDAO.insert(user);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	private static void findOne() {
		int userId = 1;

		try {
			User findOne = userDAO.findOne(userId);
			System.out.println(findOne);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	private static void updateUser() {
		int userId = 1;

		try {
			User findOne = userDAO.findOne(userId);
			findOne.setName("Naresh Kumar");
			userDAO.update(findOne);
			System.out.println(findOne);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	private static void deleteUser() {
		int userId = 5;

		try {
			User findOne = userDAO.findOne(userId);
			userDAO.delete(findOne);
			System.out.println(findOne);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}

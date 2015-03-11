package com.ticketmaster.dao;

import java.util.List;

import com.ticketmaster.bean.UserBean;

public interface UserDao {
	
	/** Standard - CRUD operation **/
	public UserBean createUser(UserBean user);
	public UserBean readUser(int id);
	public UserBean updateUser(int id, UserBean userToUpdate);
	public UserBean deleteUser(int id);
	
	// Inserts a user into the database with the specified parameters
	public List<UserBean> getAllUsers();
	public UserBean createUser(int id, String firstName, String lastName, String username);
	public UserBean getUser(String username);
}

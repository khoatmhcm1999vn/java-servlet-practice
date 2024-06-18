package com.webmvc.service.impl;

import com.webmvc.dao.IUserDAO;
import com.webmvc.dao.impl.UserDAO;
import com.webmvc.model.UserModel;
import com.webmvc.service.IUserService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
}

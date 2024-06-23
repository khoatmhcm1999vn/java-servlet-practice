package com.webmvc.dao;

import com.webmvc.model.UserModel;

public interface IUserDAO {

	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);

}

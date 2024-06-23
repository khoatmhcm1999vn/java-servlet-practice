package com.webmvc.service;

import com.webmvc.model.UserModel;

public interface IUserService {

	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);

}

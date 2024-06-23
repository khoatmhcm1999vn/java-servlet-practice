package com.webmvc.dao.impl;

import com.webmvc.dao.IUserDAO;
import com.webmvc.mapper.UserMapper;
import com.webmvc.model.UserModel;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("select * from user as u");
		sql.append(" inner join role as r on r.id = u.roleid");
		sql.append(" where username = ? and password = ? and status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

}

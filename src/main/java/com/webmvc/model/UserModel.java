package com.webmvc.model;

public class UserModel extends AbstractModel<UserModel> {
	
    private String userName;

    private String fullName;

    private String password;

    private int status;

    private int roleId;

	private RoleModel role;
    
    public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public RoleModel getRole() {
		return this.role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

}

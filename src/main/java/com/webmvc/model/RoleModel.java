package com.webmvc.model;

public class RoleModel extends AbstractModel<RoleModel> {
	 
    private String name;

    private String code;

    private RoleModel role;
    
	public RoleModel getRole() {
		return this.role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

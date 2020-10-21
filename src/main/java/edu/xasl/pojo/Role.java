package edu.xasl.pojo;

import java.util.List;

public class Role {
	private int role_id;
	private String role_name;
	private List<Authority> authorityList;
	private List<Role> roleList;
	private String functon_name;
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getFuncton_name() {
		return functon_name;
	}

	public void setFuncton_name(String functon_name) {
		this.functon_name = functon_name;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Authority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}



}

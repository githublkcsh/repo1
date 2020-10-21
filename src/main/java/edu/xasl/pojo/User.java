package edu.xasl.pojo;

import org.aspectj.lang.annotation.Aspect;

import java.util.List;

public class User {
	private int user_id;
	private String user_name;
	private String user_password;
	private String user_sex;
	private int user_age;
	private List<User> userlist;
	//private  IdCard idCard;
	private String idcard_no;
	private int idcard_id;
	private IdCard idcard;
	private String dept_name;
	private int dept_id;
	private List<Role> roleList;
	private  String role_name;

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
//	public IdCard getIdcard_no() {
//		return idcard_no;
//	}
//
//	public void setIdcard_no(IdCard idcard_no) {
//		this.idcard_no = idcard_no;
//	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public User() {
		super();
		
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	
	public User(int user_id, String user_name, String user_password, String user_sex, int user_age, 
			String idcard_no,String dept_name) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_sex = user_sex;
		this.user_age = user_age;
	
		this.idcard_no = idcard_no;
		this.dept_name=dept_name;
	}
	public User(int user_id, String user_name, String user_password, String user_sex, int user_age,int idcard_id,int dept_id) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_sex = user_sex;
		this.user_age = user_age;

		this.idcard_id = idcard_id;
		this.dept_id=dept_id;
	}
	public User(int user_id, String user_name, String user_password, String user_sex, int user_age) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_sex = user_sex;
		this.user_age = user_age;
	
		
	}
	public String getIdcard_no() {
		return idcard_no;
	}
	public void setIdcard(String idcard_no) {
		this.idcard_no = idcard_no;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_sex=" + user_sex + ", user_age=" + user_age + ", userlist=" + userlist + ", idCard=" + idcard_no
				+ ", idcard_no=" + idcard_no + ", dept=" + dept_name + "]";
	}
	
	

}

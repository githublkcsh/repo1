package edu.xasl.pojo;

import java.util.List;

public class Dept {
	private int dept_id;
	private String dept_name;
	private String dept_address;
	private String user_name;


	private List<Dept> deptList;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Dept(int dept_id, String dept_name, String dept_address) {
//		super();
//		this.dept_id = dept_id;
//		this.dept_name = dept_name;
//		this.dept_address = dept_address;
//	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_address() {
		return dept_address;
	}
	public void setDept_address(String dept_address) {
		this.dept_address = dept_address;
	}
	@Override
	public String toString() {
		return "Dept [dept_id=" + dept_id + ", dept_name=" + dept_name + ", dept_address=" + dept_address + ", user_name="
				+ user_name + ", deptList=" + deptList + "]";
	}
	public Dept(int dept_id, String dept_name, String dept_address, String user_name) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_address = dept_address;
		this.user_name = user_name;
		this.deptList = deptList;
	}
	public Dept(int dept_id, String dept_name, String dept_address) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_address = dept_address;
		
	}
	public Dept(int dept_id, String dept_name) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		
		
	}
	

}

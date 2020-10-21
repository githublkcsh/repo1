package edu.xasl.pojo;

import java.util.List;

public class Authority {
	private int function_id;
	private String function_name;
	private String function_address;
	//因为是自关联，所以要有一个关于自己的引用 表示父亲
	private Authority fatherFunction;
	private String fatherFunction_name;
	private String role_name;
	private List<Authority> authorityList;

	public List<Authority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getFatherFunction_name() {
		return fatherFunction_name;
	}

	public void setFatherFunction_name(String fatherFunction_name) {
		this.fatherFunction_name = fatherFunction_name;
	}

	private List<Role> roleList;
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFunction_id() {
		return function_id;
	}

	public void setFunction_id(int function_id) {
		this.function_id = function_id;
	}

	public String getFunction_name() {
		return function_name;
	}

	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}

	public String getFunction_address() {
		return function_address;
	}

	public void setFunction_address(String function_address) {
		this.function_address = function_address;
	}

	public Authority getFatherFunction() {
		return fatherFunction;
	}

	public void setFatherFunction(Authority fatherFunction) {
		this.fatherFunction = fatherFunction;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "Authority{" +
				"function_id=" + function_id +
				", function_name='" + function_name + '\'' +
				", function_address='" + function_address + '\'' +
				", fatherFunction=" + fatherFunction +
				", fatherFunction_name='" + fatherFunction_name + '\'' +
				", role_name='" + role_name + '\'' +
				", roleList=" + roleList +
				'}';
	}
}


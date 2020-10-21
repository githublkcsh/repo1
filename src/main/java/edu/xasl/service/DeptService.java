package edu.xasl.service;

import java.util.List;

import edu.xasl.pojo.Dept;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.pojo.User;

public interface DeptService {

	boolean insertDept(String dept_name,String dept_address);

	PagingForUser selectDept(PagingForUser pagingForUser);

	Dept findDeptById(int dept_id);

	boolean updatedept(String dept_id,String dept_name,String dept_address);

	Dept selectDeptById(String dept_id);

	List<Dept> selectDept();

	boolean updateUserDept(String dept_id);

	boolean deleteDept(String dept_id);

	List<User> selectAllUser();

	List<Dept> selectUserDept();

	List<User> selectUserDept(int dept_id);

	void addSelected(String[] ids);

	void addSelected(String[] user_id, int dept_id);
}
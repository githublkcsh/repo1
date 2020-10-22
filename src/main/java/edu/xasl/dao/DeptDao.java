package edu.xasl.dao;

import java.util.List;
import java.util.Map;

import edu.xasl.pojo.Dept;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("deptDao")
public interface DeptDao {

	boolean insertDept(@Param("dept_name")String dept_name,@Param("dept_address")String dept_address);              //注册部门

	PagingForUser selectDept(PagingForUser pagingForUser);                                                              //分页查找部门

	Dept findDeptById(int dept_id);                                                                                     //通过部门id查找部门

	boolean updatedept(@Param("dept_id") String dept_id,@Param("dept_name") String dept_name,@Param("dept_address") String dept_address);//更新部门信息

	Dept selectDeptById(@Param("dept_id") String dept_id);                                                             //通过部门id查找部门

	List<Dept> selectDept();

    int selectTotalRecord();

	List<Dept> selectDept1(Map<String, Integer> map);                                                                   //分页查找部门

	boolean updateUserDept(@Param("dept_id")String dept_id);                                                          //更新部门前的信息回写

	boolean deleteDept(@Param("dept_id")String dept_id);                                                              //通过部门id删除部门

	List<User> selectAllUser();

	List<User> selectUserDept(int dept_id);



	void insertUser(@Param("uid")String id, int dept_id);                                                              //给部门添加用户
}
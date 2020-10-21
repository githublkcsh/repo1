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

	boolean insertDept(@Param("dept_name")String dept_name,@Param("dept_address")String dept_address);

	PagingForUser selectDept(PagingForUser pagingForUser);

	Dept findDeptById(int dept_id);

	boolean updatedept(@Param("dept_id") String dept_id,@Param("dept_name") String dept_name,@Param("dept_address") String dept_address);

	Dept selectDeptById(@Param("dept_id") String dept_id);

	List<Dept> selectDept();

    int selectTotalRecord();

	List<Dept> selectDept1(Map<String, Integer> map);

	boolean updateUserDept(@Param("dept_id")String dept_id);

	boolean deleteDept(@Param("dept_id")String dept_id);

	List<User> selectAllUser();

	List<User> selectUserDept(int dept_id);



	void insertUser(@Param("uid")String id, int dept_id);
}
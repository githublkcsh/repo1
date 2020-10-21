package edu.xasl.dao;

import java.util.List;
import java.util.Map;

import edu.xasl.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
	//�����ܼ�¼��
	 int selectTotalRecord();


	//��ǰ��ʾ�ļ�¼��
	List<User> selectUser(Map<String,Integer> map);

	//��ѯ��ҳ��Ϣ
	PagingForUser selectUser(PagingForUser pagingForUser);
	//����PagingForUser���ܼ�¼������

	boolean register(User user);

	

	User findUserById(User user);

	void updateUserById(@Param("user_id") String user_id,@Param("user_name") String user_name, @Param("user_password")String user_password, @Param("user_sex")String user_sex, @Param("user_age")String user_age,@Param("idcard_id")String idcard_id,@Param("dept_id")String dept_id);

	boolean deleteUserByIdServlet(@Param("user_id")String user_id);

	

	//PagingForUser findAllUserno(User user);

	List<User> findAllUserno(Map<String,Integer> map);

	User login(User user);

	List<IdCard>  findnoIdcard();


	User findUserById(@Param("user_id") String user_id);

    List<Role> selectRole();

	boolean addrole(Role role);

	User findUserById01(String user_id);

	List<Authority> selectFunctionByUsername(String user_name);
}
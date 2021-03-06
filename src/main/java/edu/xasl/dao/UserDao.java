package edu.xasl.dao;

import java.util.List;
import java.util.Map;

import edu.xasl.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
	//查找总记录数
	 int selectTotalRecord();
	//当前显示的记录数
	List<User> selectUser(Map<String,Integer> map);
	//查询分页信息
	PagingForUser selectUser(PagingForUser pagingForUser);
	//设置PagingForUser里总记录数参数
	boolean register(User user);                                                                                        //注册用户

	User findUserById(User user);                                                                                       //通过用户id查找用户信息

	void updateUserById(@Param("user_id") String user_id,@Param("user_name") String user_name, @Param("user_password")String user_password, @Param("user_sex")String user_sex, @Param("user_age")String user_age,@Param("idcard_id")String idcard_id,@Param("dept_id")String dept_id);//更新用户信息

	boolean deleteUserByIdServlet(@Param("user_id")String user_id);                                                   //删除用户信息

	//PagingForUser findAllUserno(User user);

	List<User> findAllUserno(Map<String,Integer> map);                                                                  //分页查找用户信息

	User login(User user);                                                                                              //用户登录

	List<IdCard>  findnoIdcard();

	User findUserById(@Param("user_id") String user_id);                                                               //通过用户id查找用户信息

    List<Role> selectRole();                                                                                            //查找角色信息

	boolean addrole(Role role);                                                                                         //添加角色

	User findUserById01(String user_id);

	List<Authority> selectFunctionByUsername(String user_name);
}
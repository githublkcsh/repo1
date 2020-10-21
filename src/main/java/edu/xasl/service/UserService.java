package edu.xasl.service;

import java.util.List;

import edu.xasl.pojo.*;
import org.springframework.stereotype.Service;

@Service("userService")
public interface UserService {

	PagingForUser finAllUser(PagingForUser pagingForUser);

	boolean register( User user);

	

	User findUserById(String user_id);

	void updateUserById(String user_id, String user_name, String user_password, String user_sex, String user_age,String idcard_id,String dept_id);

	boolean deleteUserByIdServlet(String user_id);



	//User findAllUserno(User user);

	PagingForUser findAllUserno(PagingForUser pagingForUser);

	User login(User user);

	List<IdCard> findnoIdcard();

    List<Role> selectRole();

	User findUserById01(String user_id);

	List<Authority> selectFunctionByUsername(String user_name);
}
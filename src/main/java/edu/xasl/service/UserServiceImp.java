package edu.xasl.service;

import edu.xasl.dao.UserDao;
import edu.xasl.pojo.*;
import edu.xasl.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("userServiceImp")
public class UserServiceImp implements UserService {
    private UserDao userDao;
    @Override
    public PagingForUser finAllUser(PagingForUser pagingForUser) {                           //分页查询
        int totalRecord = userDao.selectTotalRecord();
        pagingForUser.setTotalRecord(totalRecord);
        int startIndex=(pagingForUser.getCurrentPageNo()-1)*Constant.PAGE_UNIT;
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",startIndex);                               //通过map传值
        map.put("pageUtil",Constant.PAGE_UNIT);
        List<User> users = userDao.selectUser(map);
        pagingForUser.setCurrentUser(users);
        return pagingForUser;
    }
    @Override
    public boolean register( User user) {                              //用户注册
        boolean result=userDao.register(user);
        List<User> userList=new ArrayList<User>();
        userList.add(user);
        boolean result_role=false;
        int flag=0;
        List<Role> roleList1=user.getRoleList();                        //添加角色
        for (Role role:roleList1){
            role.setUserList(userList);
            boolean result1=userDao.addrole(role);
            if (result1){
                flag++;
            }
        }
        if (flag==roleList1.size()){
            result_role=true;
        }
        return result&&result_role;
    }

    @Override
    public User findUserById(String user_id) {
        return userDao.findUserById(user_id);
    }  //查找用户

    @Override
    public void updateUserById(String user_id, String user_name, String user_password, String user_sex, String user_age,String idcard_id,String dept_id) {
        userDao.updateUserById(user_id, user_name, user_password, user_sex, user_age,idcard_id,dept_id);    //更新用户
    }

    @Override
    public boolean deleteUserByIdServlet(String user_id) {
        return userDao.deleteUserByIdServlet(user_id);
    }//删除用户

    @Override
    public PagingForUser findAllUserno(PagingForUser pagingForUser1) {
        int totalRecord1 = userDao.selectTotalRecord();
        pagingForUser1.setTotalRecord(totalRecord1);
        int startIndex=(pagingForUser1.getCurrentPageNo()-1)*Constant.PAGE_UNIT;
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",startIndex);
        map.put("pageUtil",Constant.PAGE_UNIT);
        List<User> users = userDao.findAllUserno(map);
        pagingForUser1.setCurrentUser(users);
        return pagingForUser1;
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<IdCard> findnoIdcard() {
        return userDao.findnoIdcard();
    }

    @Override
    public List<Role> selectRole() {
        return userDao.selectRole();
    }

    @Override
    public User findUserById01(String user_id) {
        return userDao.findUserById01(user_id);
    }

    @Override
    public List<Authority> selectFunctionByUsername(String user_name) {
        return userDao.selectFunctionByUsername(user_name);
    }

    public UserDao getUserDao() {
        return userDao;
    }
     @Resource(name="userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

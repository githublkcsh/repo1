package edu.xasl.service;

import edu.xasl.dao.RoleDao;
import edu.xasl.dao.UserDao;
import edu.xasl.pojo.*;
import edu.xasl.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleServiceImp")
public class RoleServiceImp implements RoleService {
    private RoleDao roleDao;
    public UserDao userDao;


//    @Override
//    public boolean addrole(String role_name, String functions) {
//        return roleDao.addrole(role_name,functions);
//    }

    @Override
    public boolean addrole(Role role) {
        boolean result_role=roleDao.insertRole(role);                             //给角色添加权限
        //让权限中当前角色信息
        List<Role> roleList=new ArrayList<Role>();
        roleList.add(role);
        boolean result_rolefunction=false;
        int flag=0;
        List<Authority> authorityList= role.getAuthorityList();                     //使用list集合遍历
        System.out.println(authorityList.size());
        for(Authority authority:authorityList){
            authority.setRoleList(roleList);                                        //保存到authority
            System.out.println(authority.getFunction_name());
            boolean result=roleDao.insertRoleFunction(authority);
            if (result){
                flag++;
            }
        }
        if (flag==authorityList.size()){
            result_rolefunction=true;
        }
        return result_role&&result_rolefunction;
    }

    @Override
    public List<Authority> selectAuthority() {
        List<Authority> authorityList =roleDao.selectAuthority();           //查询角色权限，返回集合

        return authorityList;
    }

    @Override
    public PagingForUser selectRole(PagingForUser pagingForUser) {            //分页查询
        int totalRecord1=roleDao.selectTotalRecord();
        pagingForUser.setTotalRecord(totalRecord1);
        int startIndex=(pagingForUser.getCurrentPageNo()-1)* Constant.PAGE_UNIT;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("startIndex",startIndex);
        map.put("pageUtil",Constant.PAGE_UNIT);
        List<Role> roleListlist=roleDao.selectIdCard(map);
        pagingForUser.setCurrentRole(roleListlist);
        return pagingForUser;
    }

    @Override
    public Role selectRoleById(String role_id) {
        return roleDao.selectRoleById(role_id);
    }//id查询

    @Override
    public boolean updateRoleById(Role role) {
        boolean result_role=roleDao.updateRoleByRoleId(role);
        boolean result_delete=roleDao.deleteRoleFunction(role);
        //遍历角色的权限信息
        List<Role> roleList=new ArrayList<Role>();
        roleList.add(role);
        boolean result_rolefunction=false;
        int flag=0;
        List<Authority> authorityList=role.getAuthorityList();
        for (Authority authority:authorityList){
            authority.setRoleList(roleList);
            boolean result=roleDao.updateRoleFunction(authority);
            if (result){
                flag++;
            }
        }
        if (flag==authorityList.size()){
            result_rolefunction=true;
        }
        return result_delete&&result_role&&result_rolefunction;
    }

    @Override
    public boolean deleteByRoleId( Role role) {                    //删除角色
        boolean result_role=roleDao.deleteRoleFunction(role);
        boolean result_function=roleDao.deleteByRoleId(role);
        return result_function&&result_role;                        //同为true成立

    }

    @Override
    public PagingForUser selectUserRole(PagingForUser pagingForUser) {
        int totalRecord1=roleDao.selectTotalRecord01();
        pagingForUser.setTotalRecord(totalRecord1);
        int startIndex=(pagingForUser.getCurrentPageNo()-1)* Constant.PAGE_UNIT;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("startIndex",startIndex);
        map.put("pageUtil",Constant.PAGE_UNIT);
        List<User> userListlist=roleDao.selectUserRole(map);
        pagingForUser.setCurrentUser(userListlist);
        return pagingForUser;
    }

    @Override
    public boolean update(User user) {                           //  更新用户角色
        System.out.println(user.getRole_name());
        boolean result1=roleDao.updaterole(user);
        return result1;
    }

    @Override
    public boolean deleteuserrole(String user_id) {               //删除用户角色
        boolean result1=roleDao.deleteuserrole(user_id);
        boolean result2=userDao.deleteUserByIdServlet(user_id);
        return result1&&result2;
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }
    @Resource(name = "roleDao")
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
@Resource(name = "userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
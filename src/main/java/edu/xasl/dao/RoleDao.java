package edu.xasl.dao;

import edu.xasl.pojo.Authority;
import edu.xasl.pojo.Role;
import edu.xasl.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("roleDao")
public interface RoleDao {

   // boolean addrole(@Param("role_name") String role_name,@Param("functions") String functions);

    boolean insertRoleFunction(Authority authority);                                                                   //为角色分配权限

    boolean insertRole(Role role);                                                                                     //添加角色

    List<Authority> selectAuthority();                                                                                  //查询所有角色

    int selectTotalRecord();

    List<Role> selectIdCard(Map<String, Integer> map);                                                                  //分页查询角色

    Role selectRoleById(String role_id);                                                                                //通过角色id查找角色信息

    boolean updateRoleByRoleId(Role role);                                                                             //更新角色信息

    boolean deleteRoleFunction(Role role);                                                                             //删除角色权限表信息

    boolean updateRoleFunction(Authority authority);                                                                   //更新角色权限表



    boolean deleteByRoleId( Role role);                                                                                //删除角色信息

    int selectTotalRecord01();

    List<User> selectUserRole(Map<String, Integer> map);                                                                //查找用户角色信息

    boolean updaterole(User user);                                                                                     //更新用户角色

    boolean deleteuserrole(String user_id);                                                                            //删除用户角色
}

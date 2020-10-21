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

    boolean insertRoleFunction(Authority authority);

    boolean insertRole(Role role);

    List<Authority> selectAuthority();

    int selectTotalRecord();

    List<Role> selectIdCard(Map<String, Integer> map);

    Role selectRoleById(String role_id);

    boolean updateRoleByRoleId(Role role);

    boolean deleteRoleFunction(Role role);

    boolean updateRoleFunction(Authority authority);



    boolean deleteByRoleId( Role role);

    int selectTotalRecord01();

    List<User> selectUserRole(Map<String, Integer> map);

    boolean updaterole(User user);

    boolean deleteuserrole(String user_id);
}

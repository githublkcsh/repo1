package edu.xasl.service;

import edu.xasl.pojo.Authority;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.pojo.Role;
import edu.xasl.pojo.User;

import java.util.List;

public interface RoleService {
//    boolean addrole(String role_name, String functions);

    boolean addrole(Role role);

    List<Authority> selectAuthority();

    PagingForUser selectRole(PagingForUser pagingForUser);

    Role selectRoleById(String role_id);

    boolean updateRoleById(Role role);

    boolean deleteByRoleId( Role role);

    PagingForUser selectUserRole(PagingForUser pagingForUser);

    boolean update(User user);

    boolean deleteuserrole(String user_id);
}

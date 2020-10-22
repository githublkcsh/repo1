package edu.xasl.handler;

import edu.xasl.pojo.Authority;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.pojo.Role;
import edu.xasl.pojo.User;
import edu.xasl.service.RoleService;
import edu.xasl.service.RoleServiceImp;
import edu.xasl.util.Constant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller("roleHandler")
@RequestMapping("/roleHandler")
public class RoleHandler {
    private RoleService roleService;
    @RequestMapping("/addrole.do")
    public String addrole(@Param("role_name") String role_name,@Param("functions") String functions){
        String f=functions;
        System.out.println(functions);
        String[] functionArray=f.split("\\.");                             //将获取的权限转换为数组
        System.out.println(functionArray.length);
        for (int n=0;n<functionArray.length;n++){
            System.out.println(functionArray[n]);
        }
        List<Authority> authorityList=new ArrayList<>();
        for (int i=0;i<functionArray.length;i++){                                  //遍历数组
            Authority authority=new Authority();
            authority.setFunction_name(functionArray[i]);
            authorityList.add(authority);                                            //将权限添加到authorityList集合中

        }
        System.out.println("角色需添加的权限为："+authorityList);
        Role role=new Role();
        role.setRole_name(role_name);
        role.setAuthorityList(authorityList);

        boolean b=roleService.addrole(role);                                      //调用添加方法
        if (b){
            return "redirect:selectRole.do";
        }else{
            return"";
        }

    }
    @RequestMapping("/allfunction.do")
    public String allfunction(HttpSession session){                                       //查询全部权限
        List<Authority> authorityList=roleService.selectAuthority();
        System.out.println(authorityList);
        session.setAttribute("allFunction",authorityList);
        return "redirect:/addRole.jsp";
    }
    @RequestMapping("/selectRole.do")
    public String selectRole(Integer currentPageNo, HttpSession session){                  //分页查询角色
        PagingForUser pagingForUser=new PagingForUser();
        if(currentPageNo==null){
            currentPageNo=1;
        }
        pagingForUser.setCurrentPageNo(currentPageNo);
        pagingForUser.setPageUnit(Constant.PAGE_UNIT);
        PagingForUser pagingForUser1=roleService.selectRole(pagingForUser);
        session.setAttribute("currentRole",pagingForUser1);

        return "redirect:/showRole.jsp";
    }
    @RequestMapping("/updateFindFunction.do")                                            //更新角色权限前的权限回写
    public String updateFinfFunction(@Param("role_id")String role_id,HttpSession session){
        List<Authority> authorityList = roleService.selectAuthority();
        session.setAttribute("AllFunction",authorityList);
        Role role=roleService.selectRoleById(role_id);
        session.setAttribute("updateRole",role);
        String functions="";
        List<Authority> authorityList1=role.getAuthorityList();
        for (Authority authority:authorityList1){
            functions+=authority.getFunction_name()+".";
        }
        functions=functions.substring(0,functions.length()-1);
        System.out.println(functions);
        session.setAttribute("functionName",functions);
        return "redirect:/updaterole.jsp";



    }
    @RequestMapping("/updateRoleById.do")                                         //更新角色信息
    public String updateRoleById(@Param("role_id")String role_id,@Param("role_name")String role_name,@Param("function")String function){
        Role role=new Role();
        role.setRole_name(role_name);
        role.setRole_id(Integer.parseInt(role_id));
        String[] functionArray=function.split("\\.");                       //将获取的权限转换为数组
        List<Authority> authorityList=new ArrayList<Authority>();
        for(int i=0;i<functionArray.length;i++){
            Authority authority=new Authority();
            authority.setFunction_name(functionArray[i]);
            System.out.println(functionArray[i]);
            authorityList.add(authority);
        }
        System.out.println(authorityList);
        role.setAuthorityList(authorityList);
        boolean result=roleService.updateRoleById(role);
        if (result){
            return "redirect:selectRole.do";
        }else {
            return "";
        }





    }
    @RequestMapping("/deleteByRoleId.do")                                           //获取角色id删除角色
    public String deleteByRoleId(@Param("role_id")String role_id){
        Role role=new Role();
        role.setRole_id(Integer.parseInt(role_id));
        boolean result=roleService.deleteByRoleId(role);
        if (result){
            return"redirect:/deleterolesuccess.jsp";
        }else {
            return"redirect:/deleteroleerror.jsp";
        }
    }
    @RequestMapping("/selectUserRole.do")                                           //查找用户角色
    public String selectUserRole(Integer currentPageNo, HttpSession session){
        PagingForUser pagingForUser=new PagingForUser();
        if(currentPageNo==null){
            currentPageNo=1;
        }
        pagingForUser.setCurrentPageNo(currentPageNo);
        pagingForUser.setPageUnit(Constant.PAGE_UNIT);
        PagingForUser pagingForUser1=roleService.selectUserRole(pagingForUser);
        session.setAttribute("selectUserRole",pagingForUser1);

        return "redirect:/showUserRole.jsp";
    }
    @RequestMapping("/updateUserroleById.do")                                             //更新用户角色
    public String updateUserroleById(@Param("user_name") String user_name, @Param("roles")String roles,@Param("user_id")String user_id) {

        User user = new User();
        user.setUser_name(user_name);
        user.setUser_id(Integer.parseInt(user_id));
        System.out.println(roles);
        System.out.println(user_id);
        user.setRole_name(roles);
        boolean result= roleService.update(user);
        if(result){
            return "redirect:selectUserRole.do";
        }else {
            return "redirect:/resgin.jsp";
        }}
        @RequestMapping("/deleteuserrole.do")
        public String deleteuserrole(@Param("user_id")String user_id){
             boolean result=roleService.deleteuserrole(user_id);
             if (result){
                 return"redirect:selectRole.do";
             }else{
                 return"";
             }


        }



    public RoleService getRoleService() {
        return roleService;
    }
@Resource(name="roleServiceImp")
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}

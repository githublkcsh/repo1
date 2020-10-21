package edu.xasl.handler;

import edu.xasl.pojo.*;
import edu.xasl.service.DeptService;
import edu.xasl.service.UserService;
import edu.xasl.util.Constant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller("userHandler")
@RequestMapping("/userHandler")
public class UserHandler {
    private UserService userService;
    private DeptService deptService;



    @RequestMapping("/finduser.do")                                  //分页查找所有用户信息
    public  String method01(Integer currentPageNo, HttpSession session){
        PagingForUser pagingForUser=new PagingForUser();
        if(currentPageNo==null)
            currentPageNo=1;                                          //默认页号为1
        pagingForUser.setCurrentPageNo(currentPageNo);
        pagingForUser.setPageUnit(Constant.PAGE_UNIT);               //传入每页的固定记录数
        PagingForUser pagingForUser1 = userService.finAllUser(pagingForUser);
        session.setAttribute("currentuser",pagingForUser1);      //用session存储查找的记录数让前台调用
       return "redirect:/userfind.jsp";
    }
    @RequestMapping("/update.do")                                   //通过用户id修改用户信息
    public String Update(HttpSession session,String user_id)
    {
        User user1 = userService.findUserById(user_id);              //调用user service的findUserById方法
        List<IdCard> idCard1=userService.findnoIdcard();
        List<Dept> dept=deptService.selectDept();
        session.setAttribute("user",user1);                        //设置session将原信息存入
        session.setAttribute("dept2", dept);
        session.setAttribute("idCard1", idCard1);
        return "redirect:/modify.jsp";                             //转发到modify.jsp

    }
    @RequestMapping("/updateById.do")
    public String UpdateById(String user_id, String user_name, String user_password, String user_sex, String user_age,String idcard_id,String dept_id){
        userService.updateUserById(user_id, user_name, user_password, user_sex, user_age,idcard_id,dept_id);
        return "redirect:finduser.do";
    }
    @RequestMapping("/deleteuser.do")
    public String deleteuser(String user_id){
        boolean result=userService.deleteUserByIdServlet(user_id);
        if(result){
            return "redirect:finduser.do";
        }else {
            return "redirect:finduser.do";
        }
    }
    @RequestMapping("/adduser01.do")
    public String finddept(HttpSession session){
        List<Dept> dept=deptService.selectDept();
        List<Role> role=userService.selectRole();
        session.setAttribute("dept3", dept);
        session.setAttribute("role",role);
        return "redirect:/resgin.jsp";
    }
    @RequestMapping("/adduser.do")
    public String adduser(@Param("user_name") String user_name, @Param("user_password")String user_password, @Param("user_sex")String user_sex, @Param("user_age")String user_age,@Param("dept_id") String dept_id, @Param("roles")String roles){
        System.out.println(user_age);
        User user=new User();
        user.setUser_name(user_name);
        user.setUser_age(Integer.parseInt(user_age));
        user.setUser_sex(user_sex);
        user.setUser_password(user_password);
        System.out.println(dept_id);
        user.setDept_id(Integer.parseInt(dept_id));
        String[] functionArray=roles.split("\\.");
        List<Role> authorityList=new ArrayList<Role>();
        for(int i=0;i<functionArray.length;i++){
            Role role=new Role();
            role.setRole_name((functionArray[i]));
            System.out.println(functionArray[i]);
            authorityList.add(role);
        }
        System.out.println(authorityList);
       user.setRoleList(authorityList);


       boolean result= userService.register(user);

        if(result){
            return "redirect:selectUserRole.do";
        }else {
            return "redirect:/resgin.jsp";
        }
    }
    @RequestMapping("/finuser.do")
    public String finduser(Integer currentPageNo, HttpSession session){
        PagingForUser pagingForUser=new PagingForUser();
        if(currentPageNo==null)
            currentPageNo=1;
        pagingForUser.setCurrentPageNo(currentPageNo);
        pagingForUser.setPageUnit(Constant.PAGE_UNIT);
        PagingForUser pagingForUser1 = userService.findAllUserno(pagingForUser);
        session.setAttribute("currentuser",pagingForUser1);
        return "redirect:/userfind.jsp";
    }
    @RequestMapping("/updateUserRole.do")
    public String updateUserRole(@Param("user_id")String user_id,HttpSession session){
        User user =userService.findUserById01(user_id);
        List<Role> roleList=userService.selectRole();

        session.setAttribute("user4",user);
        System.out.println(user.getRole_name());
        session.setAttribute("role4",roleList);
        return"redirect:/updateUserrole.jsp";
    }
    @RequestMapping("/login.do")
    public String login(@Param("user_name")String user_name,@Param("user_password")String user_password,HttpSession session){
        User user=new User();
        user.setUser_name(user_name);
        user.setUser_password(user_password);
        User user1=userService.login(user);
        session.setAttribute("user1",user1);
        if (user==null){
            return "redirect:";
        }else {
            return "redirect:/backindex.jsp";
        }

    }
    @RequestMapping("/selectfunction.do")
    public String selectfunction(@Param("user_name")String user_name,HttpSession session){
        List<Authority> list=userService.selectFunctionByUsername(user_name);
        session.setAttribute("list",list);
        return "redirect:/left.jsp";

    }








    public UserService getUserService() {
        return userService;
    }
@Resource(name="userServiceImp")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public DeptService getDeptService() {
        return deptService;
    }
@Resource(name = "deptServiceImp")
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }
}


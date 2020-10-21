package edu.xasl.handler;

import edu.xasl.pojo.Dept;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.pojo.User;
import edu.xasl.service.DeptService;
import edu.xasl.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("deptHandler")
@RequestMapping("/deptHandler")
public class DeptHandler {
    private DeptService deptService;
    @RequestMapping("/selectDept.do")
    public String selectDept(Integer currentPageNo, HttpSession session){
        PagingForUser pagingForUser=new PagingForUser();
        if (currentPageNo==null){
            currentPageNo=1;
        }
        pagingForUser.setCurrentPageNo(currentPageNo);
        pagingForUser.setPageUnit(Constant.PAGE_UNIT);
        PagingForUser pagingForUser1=deptService.selectDept(pagingForUser);
        session.setAttribute("currentdept",pagingForUser1);
        return "redirect:/departmentmanagement.jsp";
    }
    @RequestMapping("/updateDept.do")
    public String updateDept(String dept_id,HttpSession session){
        Dept dept =deptService.selectDeptById(dept_id);
        session.setAttribute("dept1",dept);
        return "redirect:/updatedept.jsp";


    }
    @RequestMapping("/updateByIdDept.do")
    public String updateByIdDept(String dept_id,String dept_name,String dept_address){
        boolean result=deptService.updatedept(dept_id,dept_name,dept_address);
        if (result){
            return "redirect:affterdept.do";
        }else {
            return "redirect:/updatedept.jsp";
        }
    }
    @RequestMapping("/affterdept.do")
    public String afterdept(HttpSession session){
       Dept dept1= (Dept) session.getAttribute("dept1");
       int dept_id=dept1.getDept_id();
        Dept dept=deptService.findDeptById(dept_id);
        session.setAttribute("dept",dept);
        return "redirect:/Afteradddept.jsp";
    }
    @RequestMapping("/deleteDept.do")
    public String deleteDept(String dept_id){
       boolean result= deptService.updateUserDept(dept_id);
        System.out.println(result);
       if(result==true){
           boolean result2 = deptService.deleteDept(dept_id);
           System.out.println(result2);
           if (result2){
               return "redirect:selectDept.do";
           }else {
               return "redirect:/Afteradddept.jsp";
           }
       }else {
           boolean result2 = deptService.deleteDept(dept_id);
           System.out.println(result2);
           if (result2){
               return "redirect:selectDept.do";
           }else {
               return "redirect:/Afteradddept.jsp";
           }
       }
    }
    @RequestMapping("/addDept.do")
    public String addDept(String dept_name,String dept_address ){
        boolean result=deptService.insertDept(dept_name,dept_address);
        return "redirect:selectDept.do";

    }
    @RequestMapping("/findallUser.do")
    public String findAllUser(HttpSession session){
        List<User> list=deptService.selectAllUser();
        Dept dept= (Dept) session.getAttribute("dept1");
        int dept_id=dept.getDept_id();
        System.out.println(dept_id);
        List<User> list1=deptService.selectUserDept(dept_id);
        session.setAttribute("userlist",list);
        session.setAttribute("user012",list1);
        return"redirect:/showuserjsp.jsp";
    }
    @RequestMapping("/addSelected.do")
    public String addSelected(String[] user_id,HttpSession session){
        Dept dept= (Dept) session.getAttribute("dept1");
        int dept_id=dept.getDept_id();
        deptService.addSelected(user_id,dept_id);
        return "redirect:selectDept.do";

    }






    public DeptService getDeptService() {
        return deptService;
    }
@Resource(name = "deptServiceImp")
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }
}

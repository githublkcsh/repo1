package edu.xasl.service;

import edu.xasl.pojo.Dept;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.util.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class DeptServiceImpTest {
    @Autowired
    @Qualifier("deptServiceImp")
    private DeptService deptService;

    @Test
    public void selectDept() {
        List<Dept> list=deptService.selectDept();
        System.out.println(list);
    }
    @Test
    public void test1(){
        PagingForUser pagingForUser=new PagingForUser();
        pagingForUser.setCurrentPageNo(1);
        pagingForUser.setPageUnit(Constant.PAGE_UNIT);
        PagingForUser pagingForUser1 = deptService.selectDept(pagingForUser);
        System.out.println(pagingForUser1.getCurrentDept());
    }
    @Test
    public void test2(){
        String dept_id="3";
        boolean b=deptService.updateUserDept(dept_id);
        System.out.println(b);
        if (b==true){
            boolean b1=deptService.deleteDept(dept_id);
            System.out.println(b1);
            if(b1){
                System.out.println(123);
            }
        }
    }
}
package edu.xasl.service;

import edu.xasl.pojo.PagingForUser;
import edu.xasl.util.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserServiceImpTest {
    @Autowired
    @Qualifier("userServiceImp")
    private UserService userService;
    @Test
    public void findAllUser(){
        PagingForUser pagingForUser=new PagingForUser();
        pagingForUser.setCurrentPageNo(1);
        pagingForUser.setPageUnit(Constant.PAGE_UNIT);
        PagingForUser pagingForUser1 = userService.finAllUser(pagingForUser);
        System.out.println(pagingForUser1);
    }


}
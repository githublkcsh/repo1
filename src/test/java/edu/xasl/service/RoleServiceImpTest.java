package edu.xasl.service;

import edu.xasl.pojo.Authority;
import edu.xasl.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class RoleServiceImpTest {
    @Autowired
    @Qualifier("roleServiceImp")
    private RoleService roleService;


    @Test
    public void selectAuthority() {
        List<Authority> list=roleService.selectAuthority();
        System.out.println(list);
    }
    @Test
    public void test01(){
//        String role_name="管理员";
//        String dd ;
        Role role = new Role();
        role.setRole_name("role0");
        List<Authority> functionList = new ArrayList<Authority>();
        Authority function01 = new Authority();
        function01.setFunction_name("用户管理");
        functionList.add(function01);
        Authority function02 = new Authority();
        function02.setFunction_name("查询用户");
        functionList.add(function02);
        System.out.println(functionList);
        role.setAuthorityList(functionList);
        boolean result = roleService.addrole(role);
        System.out.println(result);

    }
}
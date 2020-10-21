package edu.xasl.dao;

import edu.xasl.pojo.Authority;
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
public class RoleDaoTest {
    @Autowired
    @Qualifier("roleDao")
    private RoleDao roleDao;

    @Test
    public void selectAuthority() {
        List<Authority> authorityList=roleDao.selectAuthority();
        System.out.println(authorityList);
    }
}
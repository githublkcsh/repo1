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
public class FunctionDaoTest {
    @Autowired
    @Qualifier("functionDao")
private FunctionDao functionDao;
    @Test
    public void findAllFatherFunction() {
        List<Authority>list=functionDao.findAllFatherFunction();
        for (Authority i:list){
            System.out.println(i);
        }
    }
}
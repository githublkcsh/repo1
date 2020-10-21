package edu.xasl.dao;

import edu.xasl.pojo.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class DeptDaoTest {
    @Autowired
    @Qualifier("deptDao")
    private DeptDao deptDao;

    @Test
    public void selectDept() {
        List<Dept> list=deptDao.selectDept();
       // for (Dept i:list){
            System.out.println(list);

       // }

    }
    @Test
    public void test1(){
        String dept_name="企划部";
        String dept_address="东北角";
        String dept_id="1";
        boolean b=deptDao.updatedept(dept_id,dept_name,dept_address);
        System.out.println(b);
    }
}
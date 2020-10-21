package edu.xasl.dao;

import edu.xasl.pojo.IdCard;
import edu.xasl.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext.xml")
public class UserDaoTest {
    @Autowired
    @Qualifier(value = "dataSource")
    private DataSource dataSource;
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    @Test
    public void test01(){
        System.out.println(dataSource);
    }
    @Test
    public void test02(){
        int record = userDao.selectTotalRecord();
        System.out.println(record);
    }
    @Test
    public void test03(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageUtil",5);
        List<User> users = userDao.selectUser(map);
        System.out.println(users);
    }
    @Test
    public void test04(){
        List<IdCard> idCardList=userDao.findnoIdcard();
        for (IdCard d:idCardList){
        System.out.println(d);}
    }
    @Test
    public void test05(){
        String user_id="20";
        boolean b = userDao.deleteUserByIdServlet(user_id);
        System.out.println(b);
    }

}


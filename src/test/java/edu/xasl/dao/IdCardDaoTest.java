package edu.xasl.dao;

import edu.xasl.pojo.IdCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class IdCardDaoTest {
    @Autowired
    @Qualifier("idCardDao")
    private IdCardDao idCardDao;
    @Test
    public void selectIdCard() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageUtil",5);
        List<IdCard> idCards=idCardDao.selectIdCard(map);
        System.out.println(idCards);
    }
    @Test
    public void selectIdCard01() {
        int record = idCardDao.selectTotalRecord();
        System.out.println(record);
    }
}
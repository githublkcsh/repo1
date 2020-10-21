package edu.xasl.service;

import edu.xasl.dao.IdCardDao;
import edu.xasl.pojo.IdCard;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("idCardServiceImp")
public class IdCardServiceImp implements IdCardService {
    private IdCardDao idCardDao;



    @Override
    public PagingForUser selectIdCard(PagingForUser pagingForUser) {
        int totalRecord1=idCardDao.selectTotalRecord();
        pagingForUser.setTotalRecord(totalRecord1);
        int startIndex=(pagingForUser.getCurrentPageNo()-1)* Constant.PAGE_UNIT;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("startIndex",startIndex);
        map.put("pageUtil",Constant.PAGE_UNIT);
        List<IdCard> idcardlist=idCardDao.selectIdCard(map);
        pagingForUser.setCurrentIdcard(idcardlist);
        return pagingForUser;
    }

    @Override
    public boolean insertIdCard(String idcard_no) {

        return idCardDao.insertIdCard(idcard_no);
    }

    @Override
    public IdCard upateFindByIdcard(String idcard_id) {

        return idCardDao.upateFindByIdcard(idcard_id);
    }

    @Override
    public boolean updateidcard(String idcard_id,String idcard_no) {
        return idCardDao.updateidcard(idcard_id,idcard_no);
    }

    @Override
    public PagingForUser findAllUserno(PagingForUser pagingForUser) {

        int totalRecord1=idCardDao.selectTotalRecord();
        pagingForUser.setTotalRecord(totalRecord1);
        int startIndex=(pagingForUser.getCurrentPageNo()-1)* Constant.PAGE_UNIT;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("startIndex",startIndex);
        map.put("pageUtil",Constant.PAGE_UNIT);
        List<IdCard> idcardlist=idCardDao.findAllUserno(map);
        pagingForUser.setCurrentIdcard(idcardlist);
        return pagingForUser;
    }

    @Override
    public IdCard selectDeptById(IdCard idCard) {

        return idCardDao.selectDeptById(idCard);
    }

    @Override
    public boolean deleteById(String idcard_id) {

        return idCardDao.deleteById(idcard_id);
    }
    public IdCardDao getIdCardDao() {
        return idCardDao;
    }
@Resource(name="idCardDao")
    public void setIdCardDao(IdCardDao idCardDao) {
        this.idCardDao = idCardDao;
    }
}

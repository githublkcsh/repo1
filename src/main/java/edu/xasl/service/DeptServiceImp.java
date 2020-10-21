package edu.xasl.service;

import edu.xasl.dao.DeptDao;
import edu.xasl.pojo.Dept;

import edu.xasl.pojo.PagingForUser;
import edu.xasl.pojo.User;
import edu.xasl.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("deptServiceImp")
public class DeptServiceImp implements DeptService {
    private DeptDao deptDao;
    @Override
    public boolean insertDept(String dept_name,String dept_address) {

        return deptDao.insertDept(dept_name,dept_address);
    }

    @Override
    public PagingForUser selectDept(PagingForUser pagingForUser) {
        int totalRecord1=deptDao.selectTotalRecord();
        pagingForUser.setTotalRecord(totalRecord1);
        int startIndex=(pagingForUser.getCurrentPageNo()-1)* Constant.PAGE_UNIT;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("startIndex",startIndex);
        map.put("pageUtil",Constant.PAGE_UNIT);
        List<Dept> deptlist=deptDao.selectDept1(map);
        pagingForUser.setCurrentDept(deptlist);
        return pagingForUser;
    }

    @Override
    public Dept findDeptById(int dept_id) {

        return deptDao.findDeptById(dept_id);
    }

    @Override
    public boolean updatedept(String dept_id,String dept_name,String dept_address) {

        return deptDao.updatedept(dept_id,dept_name,dept_address);
    }

    @Override
    public Dept selectDeptById(String dept_id) {

        return deptDao.selectDeptById(dept_id);
    }

    @Override
    public List<Dept> selectDept() {
        List<Dept>list=deptDao.selectDept();
        return list;
    }

    @Override
    public boolean updateUserDept(String dept_id) {
        return deptDao.updateUserDept(dept_id);
    }

    @Override
    public boolean deleteDept(String dept_id) {
        return deptDao.deleteDept(dept_id);
    }

    @Override
    public List<User> selectAllUser() {
        return deptDao.selectAllUser();
    }

    @Override
    public List<Dept> selectUserDept() {
        return null;
    }

    @Override
    public List<User> selectUserDept(int dept_id) {
        return deptDao.selectUserDept(dept_id);
    }

    @Override
    public void addSelected(String[] ids) {



    }

    @Override
    public void addSelected(String[] user_id, int dept_id) {
        if(user_id!=null&& user_id.length>0){
            for (String id:user_id){
                deptDao.insertUser(id,dept_id);
            }
        }
    }

    public DeptDao getDeptDao() {
        return deptDao;
    }
@Resource(name="deptDao")
    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}

package edu.xasl.service;

import edu.xasl.dao.FunctionDao;
import edu.xasl.pojo.Authority;
import edu.xasl.pojo.IdCard;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("functionServiceImp")
public class FunctionServiceImp implements FunctionService {
    private FunctionDao functionDao;


    @Override
    public boolean addfunction(String function_name, String function_address, String fatherFunction) {
        return functionDao.addfunction(function_name,function_address,fatherFunction);                //添加权限
    }

    @Override
    public List<Authority> findAllFatherFunction() {
        return functionDao.findAllFatherFunction();
    }   //查找所有父权限

    @Override
    public PagingForUser selectFunction(PagingForUser pagingForUser) {
        int totalRecord1=functionDao.selectTotalRecord();                                              //分页查询权限
        pagingForUser.setTotalRecord(totalRecord1);
        int startIndex=(pagingForUser.getCurrentPageNo()-1)* Constant.PAGE_UNIT;                        //计算公式
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("startIndex",startIndex);
        map.put("pageUtil",Constant.PAGE_UNIT);
        List<Authority> authorityList=functionDao.selectFunction(map);
        pagingForUser.setCurrentFunction(authorityList);
        return pagingForUser;
    }

    @Override
    public Authority selectFunctionById(String function_id) {                                         //通过权限id查询权限
        Authority authority=new Authority();
        Integer exitFather = functionDao.selectFatherFunctionById(function_id);
        if (exitFather==null){//没有父权限
            authority = functionDao.selectFaFunctionById(function_id);
        }else{
            authority = functionDao.selectSonFunctionById(function_id);
        }

        return authority;
    }

    @Override
    public Boolean updateFunction(String function_name, String function_address, String fatherFunction_name, int function_id) {
        return functionDao.updateFunction(function_name,function_address,fatherFunction_name,function_id);            //更新权限信息
    }

    @Override
    public boolean deleteFunction(String function_id) {
        boolean result1=functionDao.deleteFunction01(function_id);                                                    //删除权限信息
        boolean result= functionDao.deleteFunction(function_id);
        return result&&result1;
    }


    public FunctionDao getFunctionDao() {
        return functionDao;
    }
    @Resource(name = "functionDao")
    public void setFunctionDao(FunctionDao functionDao) {
        this.functionDao = functionDao;
    }

}

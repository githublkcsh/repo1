package edu.xasl.dao;

import edu.xasl.pojo.IdCard;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("idCardDao")
public interface IdCardDao {
	//查找总记录数
	int selectTotalRecord();

	PagingForUser selectIdCard(PagingForUser pagingForUser);
	//设置PagingForUser里总记录数参数
	List<IdCard> selectIdCard(Map<String,Integer> map);

	boolean insertIdCard(@Param("idcard_no") String idcard_no);                                                       //插入身份证号

	IdCard upateFindByIdcard(@Param("idcard_id") String idcard_id);                                                    //通过id查找身份号

	boolean updateidcard(@Param("idcard_id") String idcard_id,@Param("idcard_no") String idcard_no);                 //通过id修改身份证号

	IdCard selectDeptById(IdCard idCard);

	List<IdCard> findAllUserno(Map<String,Integer> map) ;
		// TODO Auto-generated method stub

	boolean deleteById(String idcard_id);
	

}
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
	//�����ܼ�¼��
	int selectTotalRecord();

	PagingForUser selectIdCard(PagingForUser pagingForUser);
	//����PagingForUser���ܼ�¼������
	List<IdCard> selectIdCard(Map<String,Integer> map);

	boolean insertIdCard(@Param("idcard_no") String idcard_no);                                                       //�������֤��

	IdCard upateFindByIdcard(@Param("idcard_id") String idcard_id);                                                    //ͨ��id������ݺ�

	boolean updateidcard(@Param("idcard_id") String idcard_id,@Param("idcard_no") String idcard_no);                 //ͨ��id�޸����֤��

	IdCard selectDeptById(IdCard idCard);

	List<IdCard> findAllUserno(Map<String,Integer> map) ;
		// TODO Auto-generated method stub

	boolean deleteById(String idcard_id);
	

}
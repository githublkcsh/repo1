package edu.xasl.service;

import edu.xasl.pojo.IdCard;
import edu.xasl.pojo.PagingForUser;

public interface IdCardService {

	PagingForUser selectIdCard(PagingForUser pagingForUser);

	boolean insertIdCard(String idcard_no);

	IdCard upateFindByIdcard(String idcard_id);

	boolean updateidcard(String idcard_id,String idcard_no);

	PagingForUser findAllUserno(PagingForUser pagingForUser);

	IdCard selectDeptById(IdCard idCard);

	boolean deleteById(String idcard_id);

}
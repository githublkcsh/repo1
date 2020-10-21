package edu.xasl.pojo;

import java.util.List;

public class IdCard {
	@Override
	public String toString() {
		return "IdCard [idcard_id=" + idcard_id + ", idcard_no=" + idcard_no + "]";
	}
	private int idcard_id;
	private String idcard_no;
	private String user_name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	private List<IdCard> idcardlist;
	public List<IdCard> getIdcardlist() {
		return idcardlist;
	}
	public void setIdcardlist(List<IdCard> idcardlist) {
		this.idcardlist = idcardlist;
	}
	public IdCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IdCard(int idcard_id, String idcard_no,String user_name) {
		super();
		this.idcard_id = idcard_id;
		this.idcard_no = idcard_no;
		this.user_name=user_name;
	}
	public IdCard(int idcard_id, String idcard_no) {
		super();
		this.idcard_id = idcard_id;
		this.idcard_no = idcard_no;
		
	}
	public int getIdcard_id() {
		return idcard_id;
	}
	public void setIdcard_id(int idcard_id) {
		this.idcard_id = idcard_id;
	}
	public String getIdcard_no() {
		return idcard_no;
	}
	public void setIdcard_no(String idcard_no) {
		this.idcard_no = idcard_no;
	}
	

}

package edu.xasl.pojo;

import org.aspectj.lang.annotation.Aspect;

import java.util.List;
@Aspect("pagingForUser")
public class PagingForUser {
	private int pageUnit;//分页单位
	private int currentPageNo;//当前页号
	private int totalRecord;//总记录数
	private int totalPage;//总页数
	private  List<IdCard> currentIdcard;
	private  List<Dept> currentDept;
	public List<Dept> getCurrentDept() {
		return currentDept;
	}
	public void setCurrentDept(List<Dept> currentDept) {
		this.currentDept = currentDept;
	}
	public List<IdCard> getCurrentIdcard() {
		return currentIdcard;
	}
	public void setCurrentIdcard(List<IdCard> currentIdcard) {
		this.currentIdcard = currentIdcard;
	}
	private List<User> currentUser;//所要显示的用户记录
	private List<Authority> currentFunction;
	private List<Role> currentRole;

	public List<Role> getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(List<Role> currentRole) {
		this.currentRole = currentRole;
	}

	public List<Authority> getCurrentFunction() {
		return currentFunction;
	}

	public void setCurrentFunction(List<Authority> currentFunction) {
		this.currentFunction = currentFunction;
	}

	public PagingForUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PagingForUser(int pageUnit, int currentPageNum, int totalRecord, int totalPage) {
		super();
		this.pageUnit = pageUnit;
		this.currentPageNo = currentPageNum;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return  (int)Math.ceil((double)this.totalRecord/this.pageUnit);
	}
	public void setTotalPage(int totalPage) {
		this.totalPage =totalPage;
	}
	public int getPrePageNo() {
		int result=this.currentPageNo-1;
		if(result<=0) {
			result=1;
		}
		return result;//获取上一页页号  当前页-1
	}
	public int getNextPageNo() {
		int result=this.currentPageNo+1;
		if(result>this.getTotalPage()) {
			result=this.getTotalPage();
		}
		return result;//获取下一页页号  当前页+1
	}
	public List<User> getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(List<User> currentUser) {
		this.currentUser = currentUser;
	}
	
	
	

}

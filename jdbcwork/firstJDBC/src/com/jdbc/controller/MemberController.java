package com.jdbc.controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.jdbc.model.dao.MemberDao;
import com.jdbc.model.service.MemberService;
import com.jdbc.model.vo.Member;
import com.jdbc.view.MemberView;

public class MemberController {

	public void connectDB()
	{
		ResultSet result = new MemberDao().connectDB();
//		if(result > 0)
//		{
//			new MemberView().displaySuccess("DB성공");
//		}
//		else
//			new MemberView().displayError("검색된 결과가 없습니다.");
			
	}
	
	public void selectAll()
	{
		ArrayList<Member> list=new MemberService().selectAll();
		if(list!=null && list.size()>0)
			new MemberView().displayList(list);
		else
			new MemberView().displayError("조회된 회원이 없습니다!");
	}
	public void insertMember()
	{
		Member m=new MemberView().inputMember();
		int result=new MemberService().insertMember(m);
		
		if(result>0) new MemberView().displaySuccess("가입완료");
		else new MemberView().displayError("가입실패!");
	}
	
	public void selectName()
	{
		String name=new MemberView().inputName();
		ArrayList<Member> list=new MemberService().selectName(name);
		if(list.size()>0) new MemberView().displayList(list);
		else new MemberView().displayError("조회된 결과가 없습니다");
	}
	
	
}



















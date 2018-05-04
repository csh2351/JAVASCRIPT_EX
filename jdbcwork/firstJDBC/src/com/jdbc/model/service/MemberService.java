package com.jdbc.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.jdbc.model.dao.MemberDao;
import com.jdbc.model.vo.Member;

public class MemberService {

	public ArrayList<Member> selectAll()
	{
		Connection conn=getConnection();//연결정보 획득!
		ArrayList<Member> list=new MemberDao().selectAll(conn);
		close(conn);
		return list;
	}
	
	public int insertMember(Member m)
	{
		Connection conn=getConnection();
		int result=new MemberDao().insertMember(conn, m);
		//트렌젝션 관리!
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn); 
		///////
		return result;
	}
	public ArrayList<Member> selectName(String name)
	{
		Connection conn=getConnection();
		ArrayList<Member> list=new MemberDao().selectName(conn,name);
		close(conn);
		return list;
		
	}
	
}


























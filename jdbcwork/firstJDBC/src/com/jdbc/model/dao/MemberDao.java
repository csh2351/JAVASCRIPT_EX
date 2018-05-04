package com.jdbc.model.dao;

import static common.JDBCTemplate.close;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.jdbc.model.vo.Member;

public class MemberDao {
	Properties prop=new Properties();
	public MemberDao(){
		try {
			prop.load(new BufferedReader(
				new FileReader("resource/driver.properties")));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="student";
	private String pw="student";
	private String selectAll="select * from member";
	private String selectName="select * from member where member_name like ?";
	private String update="update member set age=?, phone=?, email=? where member_id=?";
	
	
	public ResultSet connectDB() 
	{
		ResultSet result=null;
		Connection conn=null;
		Statement stmt=null;
		
		try
		{   //DB연결 드라이버 등록
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pw"));
			System.out.println(prop.getProperty("user"));
			
			stmt=conn.createStatement();
			String sql="select * from member";
			result=stmt.executeQuery(sql);
//			result.next();
//			System.out.println(result.getString("emp_id"));
			return result;
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				stmt.close();
				conn.close();	
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
						
		}
		return result;
	}//method끝
	
	public ArrayList<Member> selectAll(Connection conn)
	{
		ArrayList<Member> list=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql=selectAll;
		try
		{
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			list=new ArrayList<Member>();
			while(rs.next())
			{
				String id=rs.getString("member_id");
				String pw=rs.getString("member_pwd");
				String name=rs.getString("member_name");
				String gender=rs.getString("gender");
				int age=rs.getInt("age");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String addr=rs.getString("address");
				String hobby=rs.getString("hobby");
				Date enroll=rs.getDate("enroll_date");
				list.add(new Member(id,pw,name,gender,age,
						email,phone,addr,hobby,enroll));		
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
//			try
//			{
//				rs.close();
//				stmt.close();
//				conn.close();
//			}
//			catch(SQLException e)
//			{
//				e.printStackTrace();
//			}
			close(rs, stmt);
		}
		return list;
	}
	
	public int insertMember(Connection conn, Member m)
	{
		PreparedStatement pstmt=null;
		int result=0;
//		String sql="insert into member values("
//				+ "'"+m.getMemberId()+"', "
//				+ "'"+m.getMemberPwd()+"', "
//				+ "'"+m.getMemberName()+"', "
//				+ "'"+m.getGender()+"', "
//				+m.getAge()+", "
//				+ "'"+m.getEmail()+"', "
//				+ "'"+m.getPhone()+"', "
//				+ "'"+m.getAddress()+"', "
//				+ "'"+m.getHobby()+"', "
//				+ "sysdate)";
		String sql="insert into member values(?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try
		{
			//드라이브등록
			Class.forName(driver);
			//DB연결
			conn=DriverManager.getConnection(url,user,pw);
			//query문 전송차량 배치
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,m.getMemberId());
			pstmt.setString(2,m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4,String.valueOf(m.getGender()));
			pstmt.setInt(5,m.getAge());
			pstmt.setString(6,m.getEmail());
			pstmt.setString(7,m.getPhone());
			pstmt.setString(8,m.getAddress());
			pstmt.setString(9,m.getHobby());
			
			result=pstmt.executeUpdate();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		}
		finally 
		{
			close(pstmt);
		}
		return result;		
	}
	public ArrayList<Member> selectName(Connection conn,String name)
	{
		ArrayList<Member> list=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql=selectName;
		
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+name+"%");
			rs=pstmt.executeQuery();
			list=new ArrayList<Member>();
			while(rs.next())
			{
				list.add(new Member(rs.getString("member_id"),
						rs.getString("member_pwd"),
						rs.getString("member_name"),
						rs.getString("gender"),
						rs.getInt("age"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("hobby"),
						rs.getDate("enroll_date")
						)//생성끝
						);//list 추가끝
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
//			try
//			{
//				pstmt.close();
//			}
//			catch(SQLException e)
//			{
//				e.printStackTrace();
//			}
			close(pstmt);
		}
		return list;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}





























package com.jdbc.model.vo;

import java.sql.Date;
import java.util.GregorianCalendar;

public class Member {
	
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDate;
	
	public Member() {}
	public Member(String memberId, String memberPwd, String memberName
			,String gender, int age, String email, String phone
			,String address, String hobby, Date enrollDate)
	{
		this.memberId=memberId;
		this.memberPwd=memberPwd;
		this.memberName=memberName;
		this.gender=gender;
		this.age=age;
		this.email=email;
		this.phone=phone;
		this.address=address;
		this.hobby=hobby;
		this.enrollDate=enrollDate;
	}
	public void setMemberId(String memberId)
	{
		this.memberId=memberId;
	}
	public String getMemberId()
	{
		return this.memberId;
	}
	public void setMemberPwd(String memberPwd)
	{
		this.memberPwd=memberPwd;
	}
	public String getMemberPwd()
	{
		return memberPwd;
	}
	public void setMembetName(String memberName)
	{
		this.memberName=memberName;
	}
	public String getMemberName() 
	{
		return memberName;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public String getGender()
	{
		return gender;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public int getAge() 
	{
		return age;
	}
	public void setMail(String mail)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getAddress()
	{
		return address;
	}
	public void setHobby(String hobby)
	{
		this.hobby=hobby;
	}
	public String getHobby()
	{
		return hobby;
	}
	public void setEnrollDate(Date enrollDate)
	{
		this.enrollDate=enrollDate;
	}
	public Date getEnrollDate()
	{
		return enrollDate;
	}
	
	@Override
	public String toString()
	{
		return memberId+"\t"+memberName+"\t"+gender+"\t"+age
				+"\t"+email+"\t"+phone+"\t"+address+"\t"+hobby
				+"\t"+enrollDate;
	
	}
	
	
}











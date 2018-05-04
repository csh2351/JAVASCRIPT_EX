package com.jdbc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.jdbc.controller.MemberController;
import com.jdbc.model.vo.Member;

public class MemberView {
	private Scanner sc=new Scanner(System.in);
	//private MemberController mc=new MemberController();
	
	public MemberView() {}
	
	public void mainMenu() 
	{
		int choice=0;
		System.out.println("======= 회원관리 프로그램입니다. ========");
		do 
		{
			System.out.println("0. DB연결정보 확인");
			System.out.println("1. 전체 회원조회");
			System.out.println("2. 이름으로 검색");
			System.out.println("3. 회원가입");
			
			System.out.println("9. 프로그램 종료");
			System.out.print("입력 : ");
			choice=sc.nextInt();
			sc.nextLine();			
			
			switch(choice)
			{
				case 0 : new MemberController().connectDB();break;
				case 1 : new MemberController().selectAll();break;
				case 2 : new MemberController().selectName();break;
				case 3 : new MemberController().insertMember();break;
				case 9 : System.out.println("프로그램을 종료합니다");
						return;
			}
		}while(true);
		
	}
	
	public void displayList(ArrayList<Member> list)
	{
		System.out.println("======== 회원 조회결과 ========");
		System.out.println("아이디\t이름\t성별\t나이\t이메일\t\t전화번호\t주소\t\t\t취미\t\t가입일");
		for(Member m : list)
			System.out.println(m);
		
	}
	public void displaySuccess(String msg)
	{
		System.out.println(msg);
	}
	public void displayError(String msg)
	{
		System.out.println("에러발생!!\n"+msg);
	}
	public Member inputMember()
	{
		System.out.println("======= 회원가입 =======");
		System.out.print("아이디 : ");
		String id=sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd=sc.nextLine();
		System.out.print("이름 : ");
		String name=sc.nextLine();
		System.out.print("성별 : ");
		String gender=sc.nextLine();
		System.out.print("나이 : ");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.print("이메일 : ");
		String email=sc.nextLine();
		System.out.print("핸드폰 : ");
		String phone=sc.nextLine();
		System.out.print("주소 : ");
		String addr=sc.nextLine();
		System.out.print("취미(,로 구분) : ");
		String hobby=sc.nextLine();
		return new Member(id,pwd,name,gender,age,email,
						phone,addr,hobby,null);
		
	}
	public String inputName()
	{
		System.out.println("========= 이름으로 검색 ========");
		System.out.print("찾을 이름 : ");
		String name=sc.nextLine();
		return name; //sc.nextLine();
	}
}













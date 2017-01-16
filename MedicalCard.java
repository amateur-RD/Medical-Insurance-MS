package com.mims;
import java.util.*;
//import java.io.*;

public class MedicalCard {

	
	private long MCNumber=0;//医保卡号
    private String MPassword;//医保卡支付密码
	private float MBalance;//医保卡余额
	private boolean state;//医保卡状态，指出入保或挂失

	//构造函数初始化类
	public MedicalCard(){
		
		state=true;
		MCNumber++;	
	}
	
	//设置医保卡密码
	public void SetMPassword(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请设置您的医保卡密码：");
		String str1=sc.nextLine();
		System.out.println("请再输一次：");
		String str2=sc.nextLine();
		if(str1.equals(str2)){	
			MPassword=str1;
			System.out.println("恭喜您！入保成功！");
		}
		else{
			System.out.println("密码错误！");
		}
//		System.out.println("密码为"+MPassword);

		
	}
	
	//获取医保卡号
	public long GetMCNumber(){
		
		return MCNumber;
	}
	
	//医保卡收入
	public float MDeposit(float pay){
		
		MBalance+=pay*0.09;
		return MBalance;
	}
	
	//医保卡支出
	public void MWithdraw(float expense){
		
		if((expense<=MBalance)&(state=true))
		MBalance-=expense;
	}
	//退出医保
	public void retreat(){
		
		state=false;
		MCNumber--;
	}
	
	//挂失
    public void drop(){
    	
    	state=false;
    }
    
    //重发
    public void resend(){
    	
    	state=true;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MedicalCard m=new MedicalCard();
		m.SetMPassword();

	}

}


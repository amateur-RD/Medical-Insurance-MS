package com.mims;
import java.util.*;
public class User{

	/**
	 * @param args
	 */
	public long ID; //职工编号
	public String Name; //职工姓名
	public long PCNumber;//工资卡号
	public float Pay;//工资
	public float MBalance;//医保卡余额
    public boolean state;//医保卡状态，指出入保或挂失
//    public MedicalCard *medicalcard;//医保卡

	public User(){}    
    //构造函数初始化类  
    public User(String name,float pay){
    	
    	Name=name;
    	Pay=pay;
    }
    
    public String GetName(){
    	
    	return Name;
    }
    
    public float GetPay(){
    	
    	return Pay;
    }
    
    //设置工资卡号
    public void SetPCNumber(long number){
    	
    	PCNumber=number;
    }
    
    //获取工资卡号
    public long GetPCNumber(){
    	
    	return PCNumber;
    }
    
  //医保卡收入
  	public void MDeposit(float pay){
  		
  		MBalance+=pay*0.09;
  	}
   //医保卡支出
  	public void MWithdraw(float expense){
  		
  		if((expense<=MBalance)&(state=true))
  		MBalance-=expense;
  	}
    //入保
    public void Join(){
    	
    	System.out.println("请输入您的姓名：");
    	Scanner sc=new Scanner(System.in);
    	String name=sc.nextLine();
    	Name=name;
    	System.out.println("请输入您的工资：");
    	float pay=sc.nextFloat();
    	Pay=pay;
    	sc.close();
//    	state=true;
    	MedicalCard medicalcard=new MedicalCard();
    	ID=medicalcard.GetMCNumber()+1000; 
    	medicalcard.SetMPassword();
    	
    }
    
    //退保
    public void Exit(){
    	
    	System.out.println("您将退出医保，我们将收回您的医保卡。谢谢！");
    	MedicalCard medicalcard=new MedicalCard();
    	medicalcard.retreat();
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MedicalCard medicalcard=new MedicalCard();
		User user=new User("小阳",2000);
//		System.out.print(user.GetName());
		user.Join();
		System.out.println(medicalcard.GetMCNumber());
		
	}

}

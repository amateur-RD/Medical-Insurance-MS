package com.mims;
import java.sql.*;
import java.util.*;

public class Bill {
	
	private User user=new User();
	public float expend;//支付费用
	
	//构造函数，初始化职工信息
	public Bill(){
		
		for(int i=0;i<1;i++)  
        { 
            System.out.println("请输入第"+(i+1)+"个职工的姓名、工资、支出费用：");
            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine();
            float pay=sc.nextFloat();
            float expense=sc.nextFloat();
//          System.out.println(str); 
            try {
  		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
  		    }
  		    catch (Exception e) {
  		      e.printStackTrace();
  		    }
  		    try {
  		      Connection connect = DriverManager.getConnection(
  		          "jdbc:mysql://localhost:3306/mims","root","admin");
  		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

  		      Statement stmt = connect.createStatement();
//  		      ResultSet rs = stmt.executeQuery("select * from user"); //user 为表的名称
  		      int rs = stmt.executeUpdate("insert into user(username,pcnumber,pay,mbalance,state) values('"+str+"',1210000,'"+pay+"','"+0.09*pay+"','正常')"); //user 为表的名称
  		                                                             
  		    }
  		    catch (Exception e) {
  		      e.printStackTrace();
  		    }
  		    
//            sc.close();

        }  
		
	}
	
	//查询打印职工信息
		public void Print(){
			
			System.out.println("请输入您想查询的职工的姓名：");
			Scanner sc=new Scanner(System.in);
		    String str=sc.nextLine();
		    try {
			      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			      //Class.forName("org.gjt.mm.mysql.Driver");
			    }
			    catch (Exception e) {
			      e.printStackTrace();
			    }
			    try {
			      Connection connect = DriverManager.getConnection(
			          "jdbc:mysql://localhost:3306/mims","root","admin");
			           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

			      Statement stmt = connect.createStatement();
			      ResultSet rs = stmt.executeQuery("select * from user where username='"+str+"'"); //user 为表的名称
			                                                              
			while (rs.next()) {
				    System.out.println("职工详细信息如下：");
//				    System.out.println("您的职工号为："+rs1.getString("useid"));
			        System.out.println("您的工资卡号为："+rs.getString("pcnumber"));
			        System.out.println("您的工资为："+rs.getString("pay"));
			        System.out.println("您的余额为："+rs.getString("mbalance"));
			        System.out.println("您的医保卡使用状态："+rs.getString("state"));
			      }
			    }
			    catch (Exception e) {
			      e.printStackTrace();
			    }
	}
		    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bill bi=new Bill();
		bi.Print();
		    

	}

}

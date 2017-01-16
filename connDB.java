/**
 * 功能：连接MySQL数据库
 */

package com.mims;
import java.sql.*;

public class connDB {

	PreparedStatement stmt=null;
	Connection connect=null;
	ResultSet rs=null;
	String user="root";
	String password="admin";
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/mims";
	
	//关闭数据库资源
	public void close(){
		
		try{
			 if(rs!=null) rs.close();
			 if(stmt!=null) stmt.close();
			 if(connect!=null) connect.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
	
	//查询数据库操作（不需要条件，即查询全部数据）
	public ResultSet queryExecute(String sql){
		
		try{
			
			Class.forName(driver);//加载驱动 
		    Connection connect = DriverManager.getConnection(url,user,password);//获得连接
		    stmt=connect.prepareStatement(sql);
		    rs=stmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return rs;
	}
	//查询数据库操作(条件查询）
	public ResultSet queryExecute(String sql,String []paras){
		
		try{
			
			Class.forName(driver);//加载驱动 
		    Connection connect = DriverManager.getConnection(url,user,password);//获得连接
		    stmt=connect.prepareStatement(sql);
		    //给ps赋值
		    for(int i=0;i<paras.length;i++){
			 
			     stmt.setString(i+1,paras[i]);
		    }
		    rs=stmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return rs;
	}
	
	//传入一个参数
	public boolean updExecute(String sql){
		
		boolean b=true;
		try{
		    Class.forName(driver);//加载驱动 
		    Connection connect = DriverManager.getConnection(url,user,password);//获得连接
		    stmt=connect.prepareStatement(sql);
		    //执行操作
		    if(stmt.executeUpdate()!=1){
			 
			    b=false;
		    }
		 }catch(Exception e){
			 
			 b=false;
			 e.printStackTrace();
		 }finally{
			 this.close();
		 }
	  return b;
	}
	
	//将增删改合在一起
	public boolean updExecute(String sql,String []paras){
		
		boolean b=true;
		try{
		    Class.forName(driver);//加载驱动 
		    Connection connect = DriverManager.getConnection(url,user,password);//获得连接
		    stmt=connect.prepareStatement(sql);
		    //给ps赋值
		    for(int i=0;i<paras.length;i++){
			 
			     stmt.setString(i+1,paras[i]);
		    }
		    //执行操作
		    if(stmt.executeUpdate()!=1){
			 
			    b=false;
		    }
		 }catch(Exception e){
			 
			 b=false;
			 e.printStackTrace();
		 }finally{
			 this.close();
		 }
	  return b;
     }
	
}

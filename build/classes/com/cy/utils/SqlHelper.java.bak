package com.cy.utils;

import java.io.*;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class SqlHelper{
	
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private static String userName="";
	private static String psw="";
	private static String driver="";
	private static String url="";
	private static InputStream fis=null;
	static{
		Properties pp=new Properties();
		try{
			fis=SqlHelper.class.getClassLoader().getResourceAsStream("mysql.properties");
			pp.load(fis);
			userName=pp.getProperty("dbUserName");
			psw=pp.getProperty("dbPassWord");
			driver=pp.getProperty("dbDriver");
			url=pp.getProperty("dbUrl");
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fis.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	/** 传入表名返回该表的记录数*/
	public int getRowCount(String sql){
		int rowCount=0;
		ct=getConnection();
		try{
			ps=ct.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				rowCount=rs.getInt(1);			
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rs,ps,ct);
		}
		return rowCount;
	}

	public Connection getConnection(){
		try{
			ct=DriverManager.getConnection(url,userName,psw);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ct;
	}

	/** 传入sql语句  返回查询结果封装成的对象（每一行表示一个对象）集合*/
	public ArrayList executeQuery(String sql,String[] paras){
		ct=getConnection();
		ArrayList al=new ArrayList();
		try{
			ps=ct.prepareStatement(sql);
			if(paras!=null){
				for(int i=0;i<paras.length;i++){
					ps.setString(i+1,paras[i]);
				}
			}
			rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int column=rsmd.getColumnCount();
			while(rs.next()){
				Object[] ob=new Object[column];
				for(int i=1;i<=column;i++){
					ob[i-1]=rs.getObject(i);
				}
				al.add(ob);
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				close(rs,ps,ct);
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("executeSqlResultSet方法出错:"+e.getMessage());
			}
		}
		return al;
	}

	public void executeUpdate(String sql,String[] paras){
		ct=getConnection();
		try{
			ps=ct.prepareStatement(sql);
			if(paras!=null){
				for(int i=0;i<paras.length;i++){
					ps.setString(i+1,paras[i]);
				}
			}
			ps.execute();
		}catch(SQLException e){
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs,ps,ct);
		}
	}

	public void close(ResultSet rs,Statement ps,Connection ct){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			rs=null;
		}
		if(ps!=null){
			try{
				ps.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			ps=null;
		}
		if(ct!=null){
			try{
				ct.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			ct=null;
		}
	}

	public Connection getCt(){
		return ct;
	}
	public PreparedStatement getPs(){
		return ps;
	}
	public ResultSet getRs(){
		return rs;
	}
	public int getRowCount(String sql,String[] paras){
		int rowCount=0;
		ct=getConnection();
		try{
			ps=ct.prepareStatement(sql);
			if(paras!=null){
				for(int i=0;i<paras.length;i++){
					ps.setString(i+1,paras[i]);
				}
			}
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				rowCount=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rs,ps,ct);
		}
		return rowCount;
	}

}

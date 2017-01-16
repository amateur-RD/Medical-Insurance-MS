/**
 * 功能：user表的一个模型
 */
package com.mims;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.*;
public class userModel extends AbstractTableModel{

	Vector rowData,columnNames;//rowData存放行数据，columnNames存放列名
	
	//抽象出初始化模型
	public void init(String sql){
		
		if(sql.equals("")){
			
			sql="select * from user";
		}
		//中间布局
		columnNames=new Vector();
		columnNames.add("职工编号");
		columnNames.add("姓名");
		columnNames.add("医保卡号");
		columnNames.add("医保卡余额");
		columnNames.add("医保卡状态");
				
		rowData=new Vector();
				
		try{
//			String sql="select * from user";
//			String sql="select * from user where 1=?";
//		    String paras[]={"1"};
		    	   
			//初始化connDB类，并调用它的成员函数queryExecute
		    connDB cd=new connDB();
//			ResultSet rs=cd.queryExecute(sql, paras);
			ResultSet rs=cd.queryExecute(sql);
			while (rs.next()) {
					  Vector hang=new Vector();
					  hang.add(rs.getString(1));
					  hang.add(rs.getString(2));
					  hang.add(rs.getString(3));
					  hang.add(rs.getString(6));
					  hang.add(rs.getString(7));
					    
					  rowData.add(hang);//加入到行rowData
					    
//					  System.out.println(rs.getString("userid"));
//				      System.out.println(rs.getString("username"));
				  }
			}
			catch (Exception e) {
				  e.printStackTrace();
			}		
	}
	
	//带sql语句的构造函数
	public userModel(String sql){
		
		this.init(sql);
	}
	
	//构造函数，初始化数据模型
	public userModel(){
		
		this.init("");
	}
	
	//得到共有多少列
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	//得到共有多少行
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	//得到某行某列的数据
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(column);
	}
	
	//重写模型的列名（姓名、医保卡号。。等等）
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}

}

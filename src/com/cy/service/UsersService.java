package com.cy.service;

import java.util.ArrayList;
import com.cy.domain.User;
import com.cy.utils.SqlHelper;

public class UsersService {
	
	public User checkUser(User user){
		
		String sql="select * from user where username=? and password=?";
		String []paras={user.getUsername(),user.getPassword()};
		SqlHelper sqlHelper=new SqlHelper();
		ArrayList al=sqlHelper.executeQuery(sql, paras);//将查询得到的数据存放到ArrayList数组中
		
		if(al.size()==1){
			
			//用户存在,且把user对象的信息补全
			Object objs[]=(Object[]) al.get(0);//get(0)表示Object数组中只有一个
			
			user.setUserid(objs[0].toString());//objs[1]表示数据库表中的第2个字段，下面的也同理
			user.setPcnumber(objs[2].toString());
			user.setPay(objs[4].toString());
			user.setMbalance(objs[5].toString());
			user.setState(objs[6].toString());
			return user;
		}else{
			
			return null;
		}
				
	}

}

package com.cy.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.cy.domain.User;
import com.cy.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private String username;
	private String password;
	private int sign=1;
	private HttpServletRequest request; 
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UsersService usersService=new UsersService();
		User user=new User();
		
		//ActionContext ac=ActionContext.getContext();//获得ActionContext对象
		//Map session=ac.getSession();
		
		request=ServletActionContext.getRequest();
		
		//将从表单中获取到的用户名和密码传给user对象
		user.setUsername(username);//直接使用变量名“username”就可以获取到login.jsp页面提交的用户名
		user.setPassword(password);//密码获取方法同上
		
		//判断用户是否合法，checkUser返回值不等于空，则用户合法
		if(usersService.checkUser(user) != null){
			
			//用户合法,并将user对象保存到session中，用于登录成功后获取user对象的信息
			request.getSession().setAttribute("userInfo", user);
			
			return SUCCESS;
		}else{
			
			return ERROR;
		}
	}
	
}

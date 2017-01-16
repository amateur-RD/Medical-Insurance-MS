/**
 * 这是一个主函数
 */
package com.mims;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame implements ActionListener{
	
	//定义所需控件
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf1,jtf2;
	
	userModel um;
	connDB cd;
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	Vector rowData,columnNames;//rowData存放行数据，columnNames存放列名
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		main m=new main();

	}
	
	//构造函数
	public main(){
		
		//上面布局
		jp1=new JPanel();
		jtf1=new JTextField(10);
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jl1=new JLabel("请输出名字");
		jb5=new JButton("费率一览表");
		jb5.addActionListener(this);
		jtf2=new JTextField("登录时间："+df.format(new Date()));
		jtf2.setBorder(new EmptyBorder(0,0,0,0));
		jtf2.setBackground(null);
		
		//把各个控件加到jp1
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		jp1.add(jb5);
		jp1.add(jtf2);
		
		//下面布局
		jp2=new JPanel();
		jb2=new JButton("入保");
		jb2.addActionListener(this);
		jb3=new JButton("退保");
		jb3.addActionListener(this);
		jb4=new JButton("挂失");
		jb4.addActionListener(this);
		
		//把各个控件加到jp2
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		//中间布局
		//创建数据模型userModel对象
		um=new userModel();
		
		
		jt=new JTable(um);//初始化JTable
		
		jsp=new JScrollPane(jt);//初始化jsp JScrollPane
		
		this.add(jsp);//jsp加入到JFrame中
		this.add(jp1,"North");//jp1加入到JFrame中
		this.add(jp2,"South");//jp2加入到JFrame中
		
		this.setSize(600, 400);//设置窗口大小
		this.setTitle("职工医保卡管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭JFrame时关闭资源窗口
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断是哪个按钮被点击
		if(e.getSource()==jb1){
			
			String sql;
			String name=this.jtf1.getText().trim();//获取输入框中输入的姓名
			if(name.equals("")){
				
				sql="select * from user";
			}else{
				sql="select * from user where username='"+name+"'";
			}
//			String sql="select * from user where username='"+name+"'";
			
			//创建新的数据模型类
			um=new userModel(sql);
			//更新JTable
			jt.setModel(um);
			
	   }else if(e.getSource()==jb2){
			
			userAdd us=new userAdd(this,"入保",true);
			
			//创建新的数据模型类
			um=new userModel();
			//更新JTable
			jt.setModel(um);
			
		}else if(e.getSource()==jb3){
			
			//getSelectedRow将返回用户所点中的行，若没有选择则返回-1
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				//弹出提示框
				JOptionPane.showMessageDialog(this, "请选择要退保职工！");
				return;
			}
			String id=(String) um.getValueAt(rowNum, 0);
			String sql="delete from user where userid='"+id+"'";
			cd=new connDB();
			cd.updExecute(sql);
			
			um=new userModel();
			//更新JTable
			jt.setModel(um);
			
			JOptionPane.showMessageDialog(this, "退保成功！");
			return;
			
//			System.out.println(id);
			
		}else if(e.getSource()==jb4){
			
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择要挂失职工！");
				return;
			}
			String id=(String) um.getValueAt(rowNum, 0);
			String sql="update user set state='挂失' where userid='"+id+"'";
			cd=new connDB();
			cd.updExecute(sql);
			
			um=new userModel();
			jt.setModel(um);
			
			JOptionPane.showMessageDialog(this, "恭喜您！挂失成功!");
			return;
		}else if(e.getSource()==jb5){
			
			PayRate pr=new PayRate();
			pr.print();
			
		}
		
	}
	

}

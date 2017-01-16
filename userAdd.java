package com.mims;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class userAdd extends JDialog implements ActionListener{
	
	//定义swing组件
	JLabel jl1,jl2,jl3,jl4,jl5;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JPanel jp1,jp2,jp3;
	
	
	//构造函数
	//owner为父窗口即弹出窗口，title为窗口名，model指定是模式窗口（弹出后必须先处理后才能进行其他操作）还是非模式窗口
	public userAdd(Frame owner,String title,boolean model ){
		
		super(owner,title,model);//调用父类构造方法
		jl1=new JLabel("姓名");
		jl2=new JLabel("医保卡号");
		jl3=new JLabel("工资");
		jl4=new JLabel("状态");
		jl5=new JLabel("医保卡密码");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		
		jb1=new JButton("入保");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		//设置布局
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(5,1));
		
		//添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1, BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		
		
		this.setSize(350, 250);
		this.setVisible(true);
			
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1){
			
			String name=this.jtf1.getText().trim();
			String number=this.jtf2.getText().trim();
			float pay=Float.parseFloat(this.jtf3.getText().trim());//将String类型转成float类型
			String state=this.jtf4.getText().trim();
			String password=this.jtf5.getText().trim();
			
			MedicalCard mc=new MedicalCard();
			float balance=mc.MDeposit(pay);
//			System.out.println(name);
			
			String sql="insert into user(username,pcnumber,password,pay,mbalance,state) values('"+name+"','"+number+"','"+password+"','"+pay+"','"+balance+"','"+state+"')";
			
			connDB cd=new connDB();
			cd.updExecute(sql);
			
			this.dispose();
			
			JOptionPane.showMessageDialog(this,"恭喜您！入保成功！");
			return;
//			this.setVisible(false);
			
		}else if(e.getSource()==jb2){
			
			this.dispose();
//			this.setVisible(false);
		}
	}

}

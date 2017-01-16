package com.mims;

public class PayRate {

	/**
	 * @param args
	 */
	public float Paycost;//支付费用
	
	//自费门诊费用
	public float SelfFinance (float cost){
		
		Paycost=cost;
		return Paycost;
	}
	
	//普通门诊费用
	public float General(float cost){
		
		Paycost=0.7f*cost;
		return Paycost;
	}
	
	//大病门诊费用
	public float Serious(float cost){
		
		Paycost=0.8f*cost;
		return Paycost;
	}
	//打印费用一览表
	public void print(){
		
		System.out.println("****三类支付费率一览表****");
		System.out.println("自费门诊：需要支付全部的医疗费用");
		System.out.println("普通门诊：需要支付医疗费用的70%");
		System.out.println("大病门诊：需要支付医疗费用的80%");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayRate pr=new PayRate();
		pr.print();

	}

}

# MIMS - A Medical Insurance Management System

This is a simple system, Medical Insurance Management System. It's made by java programming language.
And the program entrance is the main.java.In this system, I use the Mysql as the database that can store the data.<br>
You can to improve this system function, and send e-mail to me.Thank you！

## 系统需求分析
职工医疗保险管理系统，用来对职工的个人医保帐户进行管理。
* 每个职工有一个位数为12位的帐号唯一的医保卡，有支付密码，记录该职工的帐上余额。
* 每个职工有一个16位的工资卡，有支付密码，与职工的个人工资帐户相关联。
* 支付费率分为三类，分别是自费门诊、普通门诊与大病门诊，普通门诊就医后支付医疗费用的70%，大病门诊就医后支付医疗费的80%，而自费门诊为全部自费。
* 系统要记录每次交纳医疗保险金的往来帐，并能以个人、单位进行查询打印这些信息。
* 系统要记录每次支付医疗保险金的往来帐，并能以个人、单位进行查询打印这些信息。
* 系统具有对医保卡的管理功能，包括考虑入保和退保的处理、单位变更。
* 医院提供三类费率一览表，即那种治疗属于那个支付费率。

## 系统中的类（属性和方法）
* User类
```
Attributes
  public long ID;//职工编号
  public String Name;//姓名
  private long PCNumber;//工资卡号
                 private float Pay;//工资
                  public float MBalance;//医保卡余额
                 public Boolean state;//医保卡
Operations
  public User();
  public User(String name,float pay);
  public String GetName();
  public float GetPay();
  public void SetPCNumber (long number);//设置工资卡号
  public long GetPCNumber ();//获取工资卡号
  public void MDeposit(float pay);//医保卡收入
  public void MWithdraw(float expense);//医保卡支出
  public void Join();//入保
  public void Exit();//退保

```

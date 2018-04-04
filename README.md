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
* User Class
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
* MedicalCard Class
```
Attributes
  private long MCNumber=0;//医保卡号
  private char MPassword;//医保卡支付密码
  private float MBalance;//医保卡余额
  private boolean state;//医保卡状态，指出入保或挂失
  
Operations
  public MedicalCard();
  public void SetMPassword ();//设置医保卡密码
  public long GetMCNumber ();//获取医保卡号
  public void MDeposit (float pay);//医保卡收入
  public void MWithdraw(float expend);//医保卡支出
  public void retreat();//退出医保
  public void drop();//挂失
  public void resend();//重发

```
* PayRate Class
```
Attributes
  public float Paycost;//支付费用
  
Operations 
  public float SelfFinance (float cost);//自费门诊费用
  public float General(float cost);//普通门诊费用
  public float Serious(float cost);//大病门诊费用
  public void print();//打印费用一览表

```
* userModel Class
```
Attributes
  Vector rowData,columnNames;//存放行数据和列名
  
Operations
  public userModel();//构造函数
  public userModel(String sql);//带参构造函数
  public void init(String sql);//抽象出初始化模型
  public int getColumnCount();//获得列数
  public int getRowCount();//获得行数
  public Object getValueAt(int row,int column);//得到某行某列的数据
  public String getColumnName(int column);//重写模型的列名

```
## 系统用例图

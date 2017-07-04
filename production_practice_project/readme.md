# 生产实习项目

## 步骤
### 1. 理解MVC（Model View Controller）
#### a. Model：处理逻辑的部分，通常负责在数据库中存取数据
#### b. View：处理数据显示的部分，通常根据模型数据创建
#### c. Controller：处理用户交互的部分，从View中读取数据，控制用户输入，向模型发送数据
### 2. 代码具体内容
#### a. 建立基本信息模型：model
##### i. Book	Category	Press
		
#### b. 建立业务逻辑，持久层：dao
##### i. ConnectionMySQL：java与mysql建立连接
###### 1) 配置mysql驱动器
###### 2) 连接mysql
####### a) 使用驱动管理器的getConnection，输入正确的（端口号、用户名、密码）连接mysql
##### ii. PressInterface：定义出版社信息接口
###### 1) 通过ID查找press表里面的内容
##### iii. GetPress：访问数据库提取需要的数据
###### 1) 连接mysql
###### 2) 通过sql语句访问数据库，获取数据
###### 3) 解析，将得到的数据存储到result
###### 4) 将result的二维表数据转存到press对象
				
#### c. 建立业务逻辑，服务层：server
##### i. PressInterfaceServer：定义出版社信息接口
###### 1) 通过ID查找press表里面的内容
##### ii. PressServer：通过持久层获得press信息并返回
		
#### d. 建立数据显示模块：view
##### i. 调用GUI容器：Jframe
##### ii. 设置窗口基本信息
##### iii. 填写需展现的信息
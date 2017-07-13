# 生产实习项目

## 简介
一个可视化图书馆管理系统，用户可以查找相对应的书籍，管理员可对具体书籍进行增删查改。

## 概念
###  MVC（Model View Controller）
1. Model：处理逻辑的部分，通常负责在数据库中存取数据
2. View：处理数据显示的部分，通常根据模型数据创建
3. Controller：处理用户交互的部分，从View中读取数据，控制用户输入，向模型发送数据

## 具体实现
### 1. Model层
#### 1.1 model（模型层）
- Book：图书类，记录图书基本信息
- Category：图书分类类，记录图书的不同类型
- Press：出版社类，记录不同的出版社信息

#### 1.2 dao（持久层）
- ConnectMySQL：用于Java连接mysql
- CategoryInterface：定义图书类的接口
- PressInterface：定义出版社类的接口
- GetCategory：实现图书类表的增删查改
- GetPress：实现出版社类表的增删查改

#### 1.3 server（服务层）
- CategoryServerInterface：定义图书类的服务层接口
- PressServerInterface：服务层，定义press（出版社信息）接口
- CategoryServer：访问持久层，获得某个图书分类的信息
- PressServer：访问持久层，获得具体某个出版社的信息

### 2.View层
### 2.1 view（表现层）
- FrmPressDetail：展现具体某个出版社的具体数据
- ShowPressDetail：对上面的类进一步优化，可通过id查找具体某个出版社的具体数据
create database bookstore

  use bookstore

create table users(
  id int auto_increment primary key,
  name varchar(20),
  passwd varchar(20),
  sex varchar(2),
  age int,
  address varchar(50),
  phone  varchar(15),
  adm  int
);

insert into users(name,passwd,adm) values('tom','123',0);
insert into users(name,passwd,adm) values('admin','admin',1);

------------------------------------------
CREATE table  books(id int auto_increment primary key,name varchar(40),author varchar(20),publisher varchar(30) ,price numeric(6,2));
create table storages(id int auto_increment primary key,bookId int,amount int,inDate date);


-- 订单表
create table `Order`
(
  id			int			primary key		auto_increment,		-- 主键
  onDate		date								,			-- 下单日期
  amount		int			not null		default	1,			-- 购书总数
  total		double		not null		default 0,			-- 总金额
  postAddress	varchar(50)	not null		default '',			-- 邮寄地址
  postcard	varchar(10)	not null		default '',			-- 邮编
  telephone	varchar(20)	not null		default '',			-- 联系电话
  contact		varchar(10)	not null		default '',			-- 联系人
  userid		int,											-- 采购人
  state		int			not null		default 1			-- 订单状态（1:初步订单 2:订单已提交）
);

-- 订单明细表
create table OrderBook
(
  id			int			primary key		auto_increment,		-- 主键
  orderid		int,											-- 订单编号
  bookid		int,											-- 图书编号
  price		double		not null		default 0,			-- 单价
  amount		int			not null		default	1			--  订购数量
);
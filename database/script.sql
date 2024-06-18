DROP DATABASE IF EXISTS newswebsite;
CREATE DATABASE newswebsite CHARACTER SET utf8 COLLATE utf8_general_ci;
USE NewsWebsite;

create table role(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table user(
	id bigint not null primary key auto_increment,
    username varchar(255) not null,
    password varchar(150) not null,
    fullname varchar(150) not null,
    status int not null,
    roleid bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table user add constraint fk_user_role foreign key (roleid) references role(id);

create table news(
	id bigint not null primary key auto_increment,
    title varchar(255) null,
    thumbnail varchar(150) null,
    shortdescription text not null,
    content text not null,	
    categoryid bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table category(
	id bigint not null primary key auto_increment,
    name varchar(255) null,
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table news add constraint fk_news_category foreign key (categoryid) references category(id);

create table comment(
	id bigint not null primary key auto_increment,
    content text not null,
    userid bigint not null,
    newsid bigint not null,
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table comment add constraint fk_comment_user foreign key (userid) references user(id);
alter table comment add constraint fk_comment_news foreign key (newsid) references news(id);

insert into category(code, name, createddate, createdby) values ('the-thao', "Thể thao", curdate(), "");
insert into category(code, name, createddate, createdby) values ('the-gioi', "Thế giới", curdate(), "");
insert into category(code, name, createddate, createdby) values ('chinh-tri', "Chính trị", curdate(), "");
insert into category(code, name, createddate, createdby) values ('thoi-su', "Thời sự", curdate(), "");
insert into category(code, name, createddate, createdby) values ('goc-nhin', "Góc nhìn", curdate(), "");

insert into news(title, thumbnail, shortdescription, content, categoryid, createddate, createdby) values ('Bai viet 1', "", "Day la mot bai viet" , "Noi dung ne", 1, curdate(), "");
insert into news(title, thumbnail, shortdescription, content, categoryid, createddate, createdby) values ('Bai viet 2', "", "Day la mot bai viet" , "Noi dung ne", 2, curdate(), "");
insert into news(title, thumbnail, shortdescription, content, categoryid, createddate, createdby) values ('Bai viet 3', "", "Day la mot bai viet" , "Noi dung ne", 1, curdate(), "");

insert into role(code, name) values('Admin', "Quan tri he thong");
insert into role(code, name) values('User', "Nguoi dung");

insert into user(username, password, fullname, status, roleid) values('admin', "1234", "admin", 1,1);
insert into user(username, password, fullname, status, roleid) values('user1', "1234", "Nguyen Van A", 1,2);
insert into user(username, password, fullname, status, roleid) values('user2', "1234", "Nguyen Van B", 1,2);
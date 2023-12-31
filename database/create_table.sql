use newservlet;

create table role(
	id bigint not null PRIMARY KEY auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    createddate TIMESTAMP null,
    modifieddate TIMESTAMP null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table user(
	id bigint not null PRIMARY KEY auto_increment,
    username varchar(255) not null,
    fullname varchar(255) not null,
    password varchar(255) not null,
    status int not null,
    roleid bigint not null,
    createddate TIMESTAMP null,
    modifieddate TIMESTAMP null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table user add constraint fk_user_role foreign key (roleid) references role(id);

create table news(
	id bigint not null PRIMARY KEY auto_increment,
    title varchar(255) not null,
    thumbnail varchar(255) not null,
    shortdecription text not null,
	content text null,
    categoryid bigint not null,
    createddate TIMESTAMP null,
    modifieddate TIMESTAMP null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table category(
	id bigint not null PRIMARY KEY auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    createddate TIMESTAMP null,
    modifieddate TIMESTAMP null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table news add constraint fk_news_category foreign key (categoryid) references category(id);

create table comment(
	id bigint not null PRIMARY KEY auto_increment,
	content text null,
    userid bigint not null,
    newsid bigint not null,
    createddate TIMESTAMP null,
    modifieddate TIMESTAMP null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table comment add constraint fk_comment_user foreign key (userid) references user(id);
alter table comment add constraint fk_comment_news foreign key (newsid) references news(id);

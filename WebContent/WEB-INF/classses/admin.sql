
create table if not exists `Admin`(
	id bigint not null auto_increment , 
	username varchar(45) not null,
	password varchar(45) not null
);

insert into Admin(username, password) values('admin', 'admin');
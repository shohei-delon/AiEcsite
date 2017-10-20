drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;
create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists user_buy_item_transaction;
create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_type tinyint(1),
item_talk tinyint(1),
item_gender boolean,
item_name varchar(10),
item_tell boolean,
item_schedule boolean,
item_alarm boolean,
item_remind boolean,
item_map boolean,
total_price int,
total_count int,
user_id int,
pay varchar(30),
insert_date datetime,
update_date datetime
);

drop table if exists board_skills;
create table board_skills(
id int not null primary key auto_increment,
board_name varchar(30)
);

drop table if exists item_skills;
create table item_skills(
id int not null primary key auto_increment,
item_id int,
boardgame_id int,
foreign key(item_id)
references user_buy_item_transaction(id)
on update cascade on delete cascade
);

alter table item_skills
add foreign key (boardgame_id)
references board_skills(id)
on update cascade on delete cascade;

insert into login_user_transaction(login_id, login_pass, user_name) values("internous","internous01","test");
insert into board_skills(board_name) values("将棋"),("チェス"),("囲碁"),("オセロ");
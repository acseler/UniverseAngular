DROP TABLE "public"."messages_info";

DROP TABLE "public"."messages";

DROP TABLE "public"."logins";

DROP TABLE "public"."friends";

DROP TABLE "public"."dialog_info";

DROP TABLE "public"."accounts";

DROP TABLE "public"."universe";

DROP TABLE "public"."ids";

CREATE TABLE ids (
	table_name varchar(50) PRIMARY KEY,
	id_value int
);

CREATE TABLE universe (
	un_id BIGINT primary key,
	name varchar(100),
	description VARCHAR(1024),
	un_table varchar(100) NOT NULL
);

CREATE TABLE accounts (
	acc_id BIGINT PRIMARY KEY,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	birthday date NOT NULL,
	email varchar(100) NOT NULL,
	proffession varchar(50),
	hobbies VARCHAR(1024),
	avatar bytea,
	un_id int REFERENCES universe(un_id)
-- 	for HSQLDB
-- 	CONSTRAINT UNIVERSE_CONSTRAINT FOREIGN KEY (un_id) REFERENCES universe(un_id)
);

CREATE TABLE friends (
	fr_id BIGINT PRIMARY KEY,
	acc_id BIGINT REFERENCES accounts(acc_id),
	friend BIGINT REFERENCES accounts(acc_id),
	invite char(2) CHECK (invite IN ('af', 'fa')),
	status VARCHAR(15) CHECK (status IN ('wait', 'friends', 'apply'))
);

CREATE TABLE logins (
	login VARCHAR(100) PRIMARY KEY,
	password VARCHAR(100),
	acc_id BIGINT REFERENCES accounts(acc_id)
-- 	for HSQLDB
-- 	CONSTRAINT UNIVERSE_CONSTRAINT FOREIGN KEY (acc_id) REFERENCES accounts(acc_id)
);

CREATE TABLE dialog_info (
	dial_id BIGINT PRIMARY KEY,
	acc_id_one BIGINT REFERENCES accounts(acc_id) NOT NULL ,
	acc_id_two BIGINT REFERENCES accounts(acc_id) NOT NULL ,
	message VARCHAR(2048),
	message_time TIMESTAMP NOT NULL
);


CREATE TABLE messages (
	mess_id BIGINT PRIMARY KEY,
	dial_id BIGINT REFERENCES dialog_info(dial_id),
	text_message VARCHAR(2048) NOT NULL,
	message_time date NOT NULL,
	was_read char(1) CHECK(was_read IN ('y', 'n'))
);

CREATE TABLE messages_info (
	mess_info_id BIGINT PRIMARY KEY,
	mess_count INTEGER NOT NULL DEFAULT 0,
	acc_id BIGINT REFERENCES accounts(acc_id)
);

INSERT INTO "public"."universe" (un_id,name,description,un_table) VALUES (35,'Gena','123','gena');
INSERT INTO "public"."universe" (un_id,name,description,un_table) VALUES (34,'123','qwe','123');
INSERT INTO "public"."universe" (un_id,name,description,un_table) VALUES (33,'OnePunch Man','OLOLO','onepunch_man');

INSERT INTO "public"."accounts" (acc_id,first_name,last_name,birthday,email,proffession,hobbies,avatar,un_id) VALUES (35,'Genos','gena',{d '2017-12-21'},'as@ma.rt','sd','sd','[Ljava.lang.Byte;@4a0d7146',35);
INSERT INTO "public"."accounts" (acc_id,first_name,last_name,birthday,email,proffession,hobbies,avatar,un_id) VALUES (34,'Sonic','Sonic',{d '1987-12-31'},'asd@ma.rt','sd','sd','[Ljava.lang.Byte;@3887d0a5',34);
INSERT INTO "public"."accounts" (acc_id,first_name,last_name,birthday,email,proffession,hobbies,avatar,un_id) VALUES (33,'Saitama','Onepunch Man',{d '2017-12-21'},'acse@mala.ru','sd','2','[Ljava.lang.Byte;@3e7e6482',33);

INSERT INTO friends VALUES(	1, 33, 35, 'af', 'friends');
INSERT INTO friends VALUES(	2, 34, 33, 'fa', 'friends');

INSERT INTO "public"."logins" (login,password,acc_id) VALUES ('Saitama','123',33);
INSERT INTO "public"."logins" (login,password,acc_id) VALUES ('Genos','123',35);
INSERT INTO "public"."logins" (login,password,acc_id) VALUES ('Sonic','123',34);

INSERT  INTO dialog_info VALUES (32, 33, 34, 'OLOLOLO H1','2012-12-21');
INSERT  INTO dialog_info VALUES (732, 33, 34, '1111111111','2013-12-21');
INSERT  INTO dialog_info VALUES (232, 33, 34, '2222222222','2014-12-21');
INSERT  INTO dialog_info VALUES (432, 33, 34, '3333333333','2011-12-21');
INSERT INTO messages VALUES (1, 32, 'OLOLOLO H1', '2015-12-26', 'n');
INSERT INTO messages_info VALUES (1, 1, 33);




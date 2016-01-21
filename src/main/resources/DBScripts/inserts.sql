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
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


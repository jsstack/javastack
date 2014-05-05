create database if not exists javastack;

use javastack;

create table if not exists Story(
	id int NOT NULL AUTO_INCREMENT,
	dateCreated bigint,
	content varchar(225),
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists Puzzle(
	id int NOT NULL AUTO_INCREMENT,
	dateCreated bigint,
	imageId int,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists Image(
	id int NOT NULL AUTO_INCREMENT,
	imagePath varchar(4096),
	thumbnailPath varchar(4096),
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists Piece(
	id int NOT NULL AUTO_INCREMENT,
	puzzleId int,
	imageId int,
	x int,
	y int,
	PRIMARY KEY (id)
)ENGINE=INNODB;
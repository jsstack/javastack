use javastack;

create table if not exists FingerPrintGray1x1(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	v1 FLOAT(5,4) NOT NULL
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrintGray2x2(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	v1 FLOAT(5,4) NOT NULL,
	v2 FLOAT(5,4) NOT NULL,
	v3 FLOAT(5,4) NOT NULL,
	v4 FLOAT(5,4) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrintGray3x3(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	v1 FLOAT(5,4) NOT NULL,
	v2 FLOAT(5,4) NOT NULL,
	v3 FLOAT(5,4) NOT NULL,
	v4 FLOAT(5,4) NOT NULL,
	v5 FLOAT(5,4) NOT NULL,
	v6 FLOAT(5,4) NOT NULL,
	v7 FLOAT(5,4) NOT NULL,
	v8 FLOAT(5,4) NOT NULL,
	v9 FLOAT(5,4) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrintGray4x4(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	v1 FLOAT(5,4) NOT NULL,
	v2 FLOAT(5,4) NOT NULL,
	v3 FLOAT(5,4) NOT NULL,
	v4 FLOAT(5,4) NOT NULL,
	v5 FLOAT(5,4) NOT NULL,
	v6 FLOAT(5,4) NOT NULL,
	v7 FLOAT(5,4) NOT NULL,
	v8 FLOAT(5,4) NOT NULL,
	v9 FLOAT(5,4) NOT NULL,
	v10 FLOAT(5,4) NOT NULL,
	v11 FLOAT(5,4) NOT NULL,
	v12 FLOAT(5,4) NOT NULL,
	v13 FLOAT(5,4) NOT NULL,
	v14 FLOAT(5,4) NOT NULL,
	v15 FLOAT(5,4) NOT NULL,
	v16 FLOAT(5,4) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrint1x1(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	h1 FLOAT(5,4) NOT NULL,
	s1 FLOAT(5,4) NOT NULL,
	v1 FLOAT(5,4) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrint2x2(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	h1 FLOAT(5,4) NOT NULL,
	s1 FLOAT(5,4) NOT NULL,
	v1 FLOAT(5,4) NOT NULL,
	h2 FLOAT(5,4) NOT NULL,
	s2 FLOAT(5,4) NOT NULL,
	v2 FLOAT(5,4) NOT NULL,
	h3 FLOAT(5,4) NOT NULL,
	s3 FLOAT(5,4) NOT NULL,
	v3 FLOAT(5,4) NOT NULL,
	h4 FLOAT(5,4) NOT NULL,
	s4 FLOAT(5,4) NOT NULL,
	v4 FLOAT(5,4) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrint3x3(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	h1 FLOAT(5,4) NOT NULL,
	s1 FLOAT(5,4) NOT NULL,
	v1 FLOAT(5,4) NOT NULL,
	h2 FLOAT(5,4) NOT NULL,
	s2 FLOAT(5,4) NOT NULL,
	v2 FLOAT(5,4) NOT NULL,
	h3 FLOAT(5,4) NOT NULL,
	s3 FLOAT(5,4) NOT NULL,
	v3 FLOAT(5,4) NOT NULL,
	h4 FLOAT(5,4) NOT NULL,
	s4 FLOAT(5,4) NOT NULL,
	v4 FLOAT(5,4) NOT NULL,
	h5 FLOAT(5,4) NOT NULL,
	s5 FLOAT(5,4) NOT NULL,
	v5 FLOAT(5,4) NOT NULL,
	h6 FLOAT(5,4) NOT NULL,
	s6 FLOAT(5,4) NOT NULL,
	v6 FLOAT(5,4) NOT NULL,
	h7 FLOAT(5,4) NOT NULL,
	s7 FLOAT(5,4) NOT NULL,
	v7 FLOAT(5,4) NOT NULL,
	h8 FLOAT(5,4) NOT NULL,
	s8 FLOAT(5,4) NOT NULL,
	v8 FLOAT(5,4) NOT NULL,
	h9 FLOAT(5,4) NOT NULL,
	s9 FLOAT(5,4) NOT NULL,
	v9 FLOAT(5,4) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrint4x4(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	h1 FLOAT(5,4) NOT NULL,
	s1 FLOAT(5,4) NOT NULL,
	v1 FLOAT(5,4) NOT NULL,
	h2 FLOAT(5,4) NOT NULL,
	s2 FLOAT(5,4) NOT NULL,
	v2 FLOAT(5,4) NOT NULL,
	h3 FLOAT(5,4) NOT NULL,
	s3 FLOAT(5,4) NOT NULL,
	v3 FLOAT(5,4) NOT NULL,
	h4 FLOAT(5,4) NOT NULL,
	s4 FLOAT(5,4) NOT NULL,
	v4 FLOAT(5,4) NOT NULL,
	h5 FLOAT(5,4) NOT NULL,
	s5 FLOAT(5,4) NOT NULL,
	v5 FLOAT(5,4) NOT NULL,
	h6 FLOAT(5,4) NOT NULL,
	s6 FLOAT(5,4) NOT NULL,
	v6 FLOAT(5,4) NOT NULL,
	h7 FLOAT(5,4) NOT NULL,
	s7 FLOAT(5,4) NOT NULL,
	v7 FLOAT(5,4) NOT NULL,
	h8 FLOAT(5,4) NOT NULL,
	s8 FLOAT(5,4) NOT NULL,
	v8 FLOAT(5,4) NOT NULL,
	h9 FLOAT(5,4) NOT NULL,
	s9 FLOAT(5,4) NOT NULL,
	v9 FLOAT(5,4) NOT NULL,
	h10 FLOAT(5,4) NOT NULL,
	s10 FLOAT(5,4) NOT NULL,
	v10 FLOAT(5,4) NOT NULL,
	h11 FLOAT(5,4) NOT NULL,
	s11 FLOAT(5,4) NOT NULL,
	v11 FLOAT(5,4) NOT NULL,
	h12 FLOAT(5,4) NOT NULL,
	s12 FLOAT(5,4) NOT NULL,
	v12 FLOAT(5,4) NOT NULL,
	h13 FLOAT(5,4) NOT NULL,
	s13 FLOAT(5,4) NOT NULL,
	v13 FLOAT(5,4) NOT NULL,
	h14 FLOAT(5,4) NOT NULL,
	s14 FLOAT(5,4) NOT NULL,
	v14 FLOAT(5,4) NOT NULL,
	h15 FLOAT(5,4) NOT NULL,
	s15 FLOAT(5,4) NOT NULL,
	v15 FLOAT(5,4) NOT NULL,
	h16 FLOAT(5,4) NOT NULL,
	s16 FLOAT(5,4) NOT NULL,
	v16 FLOAT(5,4) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;
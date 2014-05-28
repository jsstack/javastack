use javastack;

create table if not exists FingerPrintGray1x1(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	gray1 tinyint unsigned NOT NULL
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrintGray2x2(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	gray1 tinyint unsigned NOT NULL,
	gray2 tinyint unsigned NOT NULL,
	gray3 tinyint unsigned NOT NULL,
	gray4 tinyint unsigned NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrintGray3x3(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	gray1 tinyint unsigned NOT NULL,
	gray2 tinyint unsigned NOT NULL,
	gray3 tinyint unsigned NOT NULL,
	gray4 tinyint unsigned NOT NULL,
	gray5 tinyint unsigned NOT NULL,
	gray6 tinyint unsigned NOT NULL,
	gray7 tinyint unsigned NOT NULL,
	gray8 tinyint unsigned NOT NULL,
	gray9 tinyint unsigned NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrintGray4x4(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	gray1 tinyint unsigned NOT NULL,
	gray2 tinyint unsigned NOT NULL,
	gray3 tinyint unsigned NOT NULL,
	gray4 tinyint unsigned NOT NULL,
	gray5 tinyint unsigned NOT NULL,
	gray6 tinyint unsigned NOT NULL,
	gray7 tinyint unsigned NOT NULL,
	gray8 tinyint unsigned NOT NULL,
	gray9 tinyint unsigned NOT NULL,
	gray10 tinyint unsigned NOT NULL,
	gray11 tinyint unsigned NOT NULL,
	gray12 tinyint unsigned NOT NULL,
	gray13 tinyint unsigned NOT NULL,
	gray14 tinyint unsigned NOT NULL,
	gray15 tinyint unsigned NOT NULL,
	gray16 tinyint unsigned NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrint1x1(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	h1 tinyint unsigned NOT NULL,
	s1 tinyint unsigned NOT NULL,
	v1 tinyint unsigned NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrint2x2(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	h1 tinyint unsigned NOT NULL,
	s1 tinyint unsigned NOT NULL,
	v1 tinyint unsigned NOT NULL,
	h2 tinyint unsigned NOT NULL,
	s2 tinyint unsigned NOT NULL,
	v2 tinyint unsigned NOT NULL,
	h3 tinyint unsigned NOT NULL,
	s3 tinyint unsigned NOT NULL,
	v3 tinyint unsigned NOT NULL,
	h4 tinyint unsigned NOT NULL,
	s4 tinyint unsigned NOT NULL,
	v4 tinyint unsigned NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrint3x3(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	h1 tinyint unsigned NOT NULL,
	s1 tinyint unsigned NOT NULL,
	v1 tinyint unsigned NOT NULL,
	h2 tinyint unsigned NOT NULL,
	s2 tinyint unsigned NOT NULL,
	v2 tinyint unsigned NOT NULL,
	h3 tinyint unsigned NOT NULL,
	s3 tinyint unsigned NOT NULL,
	v3 tinyint unsigned NOT NULL,
	h4 tinyint unsigned NOT NULL,
	s4 tinyint unsigned NOT NULL,
	v4 tinyint unsigned NOT NULL,
	h5 tinyint unsigned NOT NULL,
	s5 tinyint unsigned NOT NULL,
	v5 tinyint unsigned NOT NULL,
	h6 tinyint unsigned NOT NULL,
	s6 tinyint unsigned NOT NULL,
	v6 tinyint unsigned NOT NULL,
	h7 tinyint unsigned NOT NULL,
	s7 tinyint unsigned NOT NULL,
	v7 tinyint unsigned NOT NULL,
	h8 tinyint unsigned NOT NULL,
	s8 tinyint unsigned NOT NULL,
	v8 tinyint unsigned NOT NULL,
	h9 tinyint unsigned NOT NULL,
	s9 tinyint unsigned NOT NULL,
	v9 tinyint unsigned NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

create table if not exists FingerPrint4x4(
	id int NOT NULL AUTO_INCREMENT,
	imageId int not NULL,
	h1 tinyint unsigned NOT NULL,
	s1 tinyint unsigned NOT NULL,
	v1 tinyint unsigned NOT NULL,
	h2 tinyint unsigned NOT NULL,
	s2 tinyint unsigned NOT NULL,
	v2 tinyint unsigned NOT NULL,
	h3 tinyint unsigned NOT NULL,
	s3 tinyint unsigned NOT NULL,
	v3 tinyint unsigned NOT NULL,
	h4 tinyint unsigned NOT NULL,
	s4 tinyint unsigned NOT NULL,
	v4 tinyint unsigned NOT NULL,
	h5 tinyint unsigned NOT NULL,
	s5 tinyint unsigned NOT NULL,
	v5 tinyint unsigned NOT NULL,
	h6 tinyint unsigned NOT NULL,
	s6 tinyint unsigned NOT NULL,
	v6 tinyint unsigned NOT NULL,
	h7 tinyint unsigned NOT NULL,
	s7 tinyint unsigned NOT NULL,
	v7 tinyint unsigned NOT NULL,
	h8 tinyint unsigned NOT NULL,
	s8 tinyint unsigned NOT NULL,
	v8 tinyint unsigned NOT NULL,
	h9 tinyint unsigned NOT NULL,
	s9 tinyint unsigned NOT NULL,
	v9 tinyint unsigned NOT NULL,
	h10 tinyint unsigned NOT NULL,
	s10 tinyint unsigned NOT NULL,
	v10 tinyint unsigned NOT NULL,
	h11 tinyint unsigned NOT NULL,
	s11 tinyint unsigned NOT NULL,
	v11 tinyint unsigned NOT NULL,
	h12 tinyint unsigned NOT NULL,
	s12 tinyint unsigned NOT NULL,
	v12 tinyint unsigned NOT NULL,
	h13 tinyint unsigned NOT NULL,
	s13 tinyint unsigned NOT NULL,
	v13 tinyint unsigned NOT NULL,
	h14 tinyint unsigned NOT NULL,
	s14 tinyint unsigned NOT NULL,
	v14 tinyint unsigned NOT NULL,
	h15 tinyint unsigned NOT NULL,
	s15 tinyint unsigned NOT NULL,
	v15 tinyint unsigned NOT NULL,
	h16 tinyint unsigned NOT NULL,
	s16 tinyint unsigned NOT NULL,
	v16 tinyint unsigned NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;
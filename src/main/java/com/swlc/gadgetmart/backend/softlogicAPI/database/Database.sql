drop DATABASE softlogic;

CREATE DATABASE softlogic;

USE softlogic;

CREATE TABLE category(
                         cateID int(10) NOT NULL AUTO_INCREMENT,
                         cateName varchar(100) NOT NULL,
                         CONSTRAINT PRIMARY KEY(cateID)
) ENGINE=INNODB;

CREATE TABLE brand(
                      brandID int(10) NOT NULL AUTO_INCREMENT,
                      brandName varchar(100) NOT NULL,
                      CONSTRAINT PRIMARY KEY(brandID)
) ENGINE=INNODB;

CREATE TABLE item(
                     itemID int(10) NOT NULL AUTO_INCREMENT,
                     name VARCHAR (100) NOT NULL,
                     description VARCHAR (225) NOT NULL,
                     image VARCHAR (225) NOT NULL,
                     price DOUBLE NOT NULL,
                     deliveryCost DOUBLE NOT NULL,
                     brand int(10) NOT NULL,
                     category int(10) NOT NULL,
                     discount int(10) NOT NULL,
                     shop VARCHAR (225) NOT NULL,
                     warranty VARCHAR (225) NOT NULL,
                     soldOut BOOL NOT NULL,
                     CONSTRAINT PRIMARY KEY(item_id),
                     CONSTRAINT FOREIGN KEY(brand) REFERENCES brand(brandID) on update cascade on delete cascade,
                     CONSTRAINT FOREIGN KEY(category) REFERENCES category(cateID) on update cascade on delete cascade
) ENGINE=INNODB;


insert into category (cateID, cateName) values (1,'Computers & Mobile');
insert into category (cateID, cateName) values (2,'TV & Audio');
insert into category (cateID, cateName) values (3,'Kitchen Appliances');
insert into category (cateID, cateName) values (4,'Home Appliances');
insert into category (cateID, cateName) values (5,'Fitness');
insert into category (cateID, cateName) values (6,'Refrigerator, Air Conditioner, Washing Machines');

insert into brand (brandName) VALUES ('Huawei');
insert into brand (brandName) VALUES ('Apple');
insert into brand (brandName) VALUES ('Samsung');
insert into brand (brandName) VALUES ('Dell');
insert into brand (brandName) VALUES ('Asus');
insert into brand (brandName) VALUES ('Canon');
insert into brand (brandName) VALUES ('Energizer');
insert into brand (brandName) VALUES ('Yamaha');
insert into brand (brandName) VALUES ('Sharp');
insert into brand (brandName) VALUES ('Hitachi');
insert into brand (brandName) VALUES ('Yison');
insert into brand (brandName) VALUES ('Sunpin');
insert into brand (brandName) VALUES ('Marshall');
insert into brand (brandName) VALUES ('Tefal');


insert into item (name, description, image, price, deliveryCost, brand, category, discount, shop, warranty, soldOut) VALUES
    ('Samsung Galaxy M52 5G','MBPSSM-M526BZKISLK-S','https://objectstorage.ap-mumbai-1.oraclecloud.com/n/softlogicbicloud/b/cdn/o/products/140-140/b3--1637345854.jpg',99,990.00 ,0,2,1,0,'Softlogic','1 Year',0);

insert into item (name, description, image, price, deliveryCost, brand, category, discount, shop, warranty, soldOut) VALUES
    ('HyperX Cloud Stinger Gaming Headset','HU-Y7A-G','https://objectstorage.ap-mumbai-1.oraclecloud.com/…n/o/products/140-140/Artboard%201--1618942359.jpg',18,190.00,0,1,1,0,'Softlogic','1 Year',0);




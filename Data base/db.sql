CREATE DATABASE `tech`;

USE `tech`;

CREATE TABLE `tech`.`supplier`(
    `supplierId` VARCHAR(10) NOT NULL ,
    `supplierName` VARCHAR(30) NOT NULL ,
    `contactDetails` VARCHAR(40) NOT NULL ,
    `partsSupplied` VARCHAR(60) NOT NULL ,
    PRIMARY KEY (`supplierId`(10))
)ENGINE = InnoDB;

CREATE TABLE `tech`.`customer` (
    `oid` VARCHAR(10) NOT NULL , 
    `cid` VARCHAR(10) NOT NULL , 
    `name` VARCHAR(30) NOT NULL , 
    `email` VARCHAR(40) NOT NULL , 
    `type` VARCHAR(30) NOT NULL , 
    `status` VARCHAR(30) NOT NULL , 
    `parts` VARCHAR(50) NOT NULL , 
    `total` DECIMAL(10,2) NOT NULL , 
    `addDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP , 
    PRIMARY KEY (`oid`(10))
) ENGINE = InnoDB;

CREATE TABLE `tech`.`inventory` (
    `id` VARCHAR(10) NOT NULL , 
    `name` VARCHAR(30) NOT NULL , 
    `quantity` VARCHAR(10) NOT NULL , 
    `sid` VARCHAR(10) NOT NULL , 
    PRIMARY KEY (`id`(10))
) ENGINE = InnoDB;

CREATE TABLE `tech`.`employee` (
    `id` VARCHAR(10) NOT NULL , 
    `name` VARCHAR(50) NOT NULL , 
    `role` VARCHAR(30) NOT NULL , 
    `email` VARCHAR(50) NOT NULL , 
    `phone` VARCHAR(20) NOT NULL , 
    `address` VARCHAR(100) NOT NULL , 
    `status` VARCHAR(30) NOT NULL , 
    `workLocation` VARCHAR(30) NOT NULL , 
    `schedule` VARCHAR(30) NOT NULL , 
    PRIMARY KEY (`id`(10))
) ENGINE = InnoDB;

CREATE TABLE `tech`.`job` (
    `jid` VARCHAR(10) NOT NULL , 
    `oid` VARCHAR(10) NOT NULL , 
    `eid` VARCHAR(10) NOT NULL , 
    PRIMARY KEY (`jid`(10))
) ENGINE = InnoDB;
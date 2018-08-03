/*
SQLyog - Free MySQL GUI v5.19
Host - 5.5.17 : Database - dm_privacy_preserving_mobile_cloud
*********************************************************************
Server version : 5.5.17
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `dm_privacy_preserving_mobile_cloud`;

USE `dm_privacy_preserving_mobile_cloud`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `s_no` int(10) NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(20) DEFAULT NULL,
  `admin_pwd` varchar(20) DEFAULT NULL,
  `admin_name` varchar(20) DEFAULT NULL,
  `email_id` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`s_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`s_no`,`admin_id`,`admin_pwd`,`admin_name`,`email_id`,`phone`) values (1,'admin','admin','menaka','menaka@dhsinformatic','9999999999');

/*Table structure for table `m_blocks` */

DROP TABLE IF EXISTS `m_blocks`;

CREATE TABLE `m_blocks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `f_no` int(11) DEFAULT NULL,
  `blocks` varchar(50) DEFAULT NULL,
  `hash_code` varchar(50) DEFAULT NULL,
  `instance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `m_blocks` */

insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (1,1001,'1001blk_0','c2783dd79e8037212d1061d6e4eebf0a',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (2,1001,'1001blk_1','42d20b63c0ad8de4ce309b554f378d75',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (3,1001,'1001blk_2','c2cf2bb9978dcdb817f9c8e5c5797cfd',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (4,1001,'1001blk_3','21f1ecd591645c3f30abb28d212417cf',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (5,1002,'1002blk_0','2e181fa54e2c40a84c32f115e5592db6',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (6,1002,'1002blk_1','2f7b5a56f0fc6cc6627bc57de6b84a0a',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (7,1002,'1002blk_2','b0d9014c077ed5d7b0b9e408cab7a7b4',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (8,1002,'1002blk_3','53786921d6508ecd2d182e8377ddeceb',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (9,1002,'1002blk_4','7b7225eefab6ace13a915e50aeceefd8',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (10,1003,'1003blk_0','a8e3c4fa91a8dce85449b61cbbc7d7f6',1);
insert into `m_blocks` (`id`,`f_no`,`blocks`,`hash_code`,`instance`) values (11,1003,'1003blk_1','319bf27d5a505084e1b0357b13068d4d',1);

/*Table structure for table `m_cloud` */

DROP TABLE IF EXISTS `m_cloud`;

CREATE TABLE `m_cloud` (
  `c_id` int(10) NOT NULL AUTO_INCREMENT,
  `c_url` varchar(200) NOT NULL,
  `c_username` varchar(200) NOT NULL,
  `c_password` varchar(200) NOT NULL,
  `c_status` varchar(50) DEFAULT NULL,
  `c_remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `m_cloud` */

insert into `m_cloud` (`c_id`,`c_url`,`c_username`,`c_password`,`c_status`,`c_remarks`) values (1,'ftp://drivehq.com/Medical','technofistcloud','technofistbng','Active','First cloud space');

/*Table structure for table `m_cluster` */

DROP TABLE IF EXISTS `m_cluster`;

CREATE TABLE `m_cluster` (
  `cluster_id` int(10) NOT NULL AUTO_INCREMENT,
  `cluster_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cluster_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `m_cluster` */

insert into `m_cluster` (`cluster_id`,`cluster_name`) values (1,'Sensitive');
insert into `m_cluster` (`cluster_id`,`cluster_name`) values (2,'Nonsensitive');

/*Table structure for table `m_cluster_1` */

DROP TABLE IF EXISTS `m_cluster_1`;

CREATE TABLE `m_cluster_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `f_no` int(11) DEFAULT NULL,
  `key_word` varchar(200) DEFAULT NULL,
  `key_rank` int(11) DEFAULT NULL,
  `cluster_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

/*Data for the table `m_cluster_1` */

insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (1,1001,'Bank',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (2,1001,'Welsh',7,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (3,1001,'Justice',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (4,1002,'Accredit',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (5,1002,'Accreditation',2,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (6,1002,'Accredited',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (7,1002,'Accrediting',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (8,1002,'Adjudicator',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (9,1002,'association',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (10,1003,'imac',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (11,1003,'confidential',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (12,1003,'crime',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (13,1003,'security',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (14,1003,'hacking',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (15,1003,'hacker',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (16,1003,'attack',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (17,1003,'website',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (18,1003,'internet',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (19,1003,'Architect',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (20,1003,'Pharmacy',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (21,1003,'Druggist',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (22,1003,'Chemist',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (23,1003,'Britain',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (24,1003,'charitable',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (25,1003,'Bank',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (26,1003,'justice',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (27,1003,'law',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (28,1003,'assurance',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (29,1003,'assurer',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (30,1003,'banc',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (31,1003,'banking',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (32,1003,'insurance',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (33,1003,'mutual',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (34,1003,'reassurance',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (35,1003,'reassurer',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (36,1003,'reinsurance',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (37,1003,'reinsurer',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (38,1003,'underwrite',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (39,1003,'underwriting',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (40,1004,'insurance',2,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (41,1004,'assurance',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (42,1004,'mutual',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (43,1004,'reassurance',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (44,1004,'reassurer',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (45,1004,'reinsurance',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (46,1004,'reinsurer',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (47,1004,'underwrite',1,1);
insert into `m_cluster_1` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (48,1004,'underwriting',1,1);

/*Table structure for table `m_cluster_2` */

DROP TABLE IF EXISTS `m_cluster_2`;

CREATE TABLE `m_cluster_2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `f_no` int(11) DEFAULT NULL,
  `key_word` varchar(200) DEFAULT NULL,
  `key_rank` int(11) DEFAULT NULL,
  `cluster_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

/*Data for the table `m_cluster_2` */

insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (1,1001,'Payment',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (2,1001,'Exchange',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (3,1001,'Insecure',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (4,1001,'Authentication',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (5,1001,'Credentials',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (6,1001,'Spam',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (7,1001,'Interest',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (8,1001,'Delivery',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (9,1001,'Support',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (10,1001,'Beneficiary',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (11,1001,'Credit',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (12,1001,'Warranty',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (13,1001,'Fantastic',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (14,1001,'Unsolicited',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (15,1001,'Satisfaction',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (16,1001,'Mortgage',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (17,1002,'support',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (18,1003,'Training',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (19,1003,'Technique',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (20,1003,'Software',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (21,1003,'Recover',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (22,1003,'Relieve',2,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (23,1003,'Scam',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (24,1003,'Solution',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (25,1003,'Rebuild',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (26,1003,'Purchase',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (27,1003,'Protect',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (28,1003,'Inexpensive',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (29,1003,'Discount',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (30,1003,'Cheapest',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (31,1003,'Comparison',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (32,1003,'Compare',2,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (33,1003,'Budget',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (34,1003,'Prevent',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (35,1003,'Remedy',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (36,1003,'Treat',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (37,1003,'Institutes',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (38,1003,'Consultants',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (39,1003,'Payment',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (40,1003,'Exchange',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (41,1003,'Insecure',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (42,1003,'Authentication',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (43,1003,'Credentials',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (44,1003,'Spam',1,2);
insert into `m_cluster_2` (`id`,`f_no`,`key_word`,`key_rank`,`cluster_id`) values (45,1004,'credit',1,2);

/*Table structure for table `m_file` */

DROP TABLE IF EXISTS `m_file`;

CREATE TABLE `m_file` (
  `f_no` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(50) DEFAULT NULL,
  `date_and_time` varchar(100) DEFAULT NULL,
  `cluster_id` int(11) DEFAULT NULL,
  `lba` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`f_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=latin1;

/*Data for the table `m_file` */

insert into `m_file` (`f_no`,`f_name`,`date_and_time`,`cluster_id`,`lba`) values (1001,'news.txt','2018-02-15 11:37:50',2,'1-2-3-4-');
insert into `m_file` (`f_no`,`f_name`,`date_and_time`,`cluster_id`,`lba`) values (1002,'ddd.txt','2018-02-15 11:47:05',1,'5-6-7-8-9-');
insert into `m_file` (`f_no`,`f_name`,`date_and_time`,`cluster_id`,`lba`) values (1003,'text.txt','2018-02-15 12:11:34',1,'10-11-');
insert into `m_file` (`f_no`,`f_name`,`date_and_time`,`cluster_id`,`lba`) values (1004,'sensivtivedata.txt','2018-02-15 12:19:34',1,NULL);

/*Table structure for table `m_terms` */

DROP TABLE IF EXISTS `m_terms`;

CREATE TABLE `m_terms` (
  `s_no` int(10) NOT NULL AUTO_INCREMENT,
  `word` varchar(50) DEFAULT NULL,
  `cluster_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`s_no`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;

/*Data for the table `m_terms` */

insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (1,'imac',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (2,'confidential',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (3,'crime',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (4,'security',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (5,'hacking',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (6,'hacker',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (7,'attack',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (8,'website',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (9,'internet',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (10,'Architect',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (11,'Pharmacy',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (12,'Druggist',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (13,'Chemist',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (14,'Britain',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (15,'charitable',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (16,'Bank',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (17,'justice',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (18,'law',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (19,'assurance',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (20,'assurer',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (21,'banc',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (22,'banking',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (23,'insurance',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (24,'mutual',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (25,'reassurance',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (26,'reassurer',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (27,'reinsurance',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (28,'reinsurer',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (29,'underwrite',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (30,'underwriting',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (31,'University',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (32,'Wales',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (33,'Watchdog',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (34,'Welsh',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (35,'Windsor',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (36,'Parliament',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (37,'Parliamentarian',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (38,'Parliamentary',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (39,'Patent',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (40,'Patentee',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (41,'Charitable',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (42,'Charity',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (43,'Charter',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (44,'Chartered',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (45,'Abortion',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (46,'Accredit',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (47,'Accreditation',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (48,'Accredited',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (49,'Accrediting',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (50,'Adjudicator',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (51,'Association',1);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (52,'Training',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (53,'Technique',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (54,'Software',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (55,'Recover',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (56,'Relieve',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (57,'Scam',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (58,'Solution',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (59,'Rebuild',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (60,'Purchase',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (61,'Protect',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (62,'Inexpensive',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (63,'Discount',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (64,'Cheapest',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (65,'Comparison',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (66,'Compare',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (67,'Budget',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (68,'Compare',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (69,'Low cost',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (70,'Prevent',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (71,'Remedy',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (72,'Relieve',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (73,'Treat',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (74,'Institutes',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (75,'Consultants',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (76,'Payment',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (77,'Exchange',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (78,'Insecure',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (79,'Authentication',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (80,'Credentials',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (81,'Spam',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (82,'Interest',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (83,'Delivery',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (84,'Support',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (85,'Beneficiary',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (86,'Credit',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (87,'Warranty',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (88,'Fantastic',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (89,'Unsolicited',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (90,'Satisfaction',2);
insert into `m_terms` (`s_no`,`word`,`cluster_id`) values (91,'Mortgage',2);

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_no` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` varchar(50) DEFAULT NULL,
  `u_pass` varchar(20) DEFAULT NULL,
  `u_name` varchar(50) DEFAULT NULL,
  `u_email` varchar(30) DEFAULT NULL,
  `u_phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`u_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_no`,`u_id`,`u_pass`,`u_name`,`u_email`,`u_phone`) values (1,'abc','abc','ABC','abc@gmail.com','8877665544');
insert into `m_user` (`u_no`,`u_id`,`u_pass`,`u_name`,`u_email`,`u_phone`) values (2,'xyz','xyz','XYZ','xyz@gmail.com','9988776655');
insert into `m_user` (`u_no`,`u_id`,`u_pass`,`u_name`,`u_email`,`u_phone`) values (4,'mmm','mmm','mmm','mmm@gmail.com','9999999999');
insert into `m_user` (`u_no`,`u_id`,`u_pass`,`u_name`,`u_email`,`u_phone`) values (5,'anu','anu123','anushree','menaka@dhsinformatics.com','9486016158');
insert into `m_user` (`u_no`,`u_id`,`u_pass`,`u_name`,`u_email`,`u_phone`) values (6,'menaka','menaka123','menaka','menaka@dhsinformatics.com','9486016158');

/*Table structure for table `t_count` */

DROP TABLE IF EXISTS `t_count`;

CREATE TABLE `t_count` (
  `t_no` int(20) NOT NULL AUTO_INCREMENT,
  `f_no` int(10) DEFAULT NULL,
  `key_word` varchar(50) DEFAULT NULL,
  `key_rank` int(10) DEFAULT NULL,
  `category_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`t_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_count` */

/*Table structure for table `t_word` */

DROP TABLE IF EXISTS `t_word`;

CREATE TABLE `t_word` (
  `f_code` int(10) NOT NULL AUTO_INCREMENT,
  `f_word` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`f_code`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

/*Data for the table `t_word` */

insert into `t_word` (`f_code`,`f_word`) values (1,'is');
insert into `t_word` (`f_code`,`f_word`) values (2,'was');
insert into `t_word` (`f_code`,`f_word`) values (3,'that');
insert into `t_word` (`f_code`,`f_word`) values (4,'the');
insert into `t_word` (`f_code`,`f_word`) values (5,'of');
insert into `t_word` (`f_code`,`f_word`) values (6,'has');
insert into `t_word` (`f_code`,`f_word`) values (7,'had');
insert into `t_word` (`f_code`,`f_word`) values (8,'they');
insert into `t_word` (`f_code`,`f_word`) values (9,'their');
insert into `t_word` (`f_code`,`f_word`) values (10,'when');
insert into `t_word` (`f_code`,`f_word`) values (11,'as');
insert into `t_word` (`f_code`,`f_word`) values (12,'have');
insert into `t_word` (`f_code`,`f_word`) values (13,'been');
insert into `t_word` (`f_code`,`f_word`) values (14,'i');
insert into `t_word` (`f_code`,`f_word`) values (15,'in');
insert into `t_word` (`f_code`,`f_word`) values (16,'by');
insert into `t_word` (`f_code`,`f_word`) values (17,'which');
insert into `t_word` (`f_code`,`f_word`) values (18,'with');
insert into `t_word` (`f_code`,`f_word`) values (19,'that');
insert into `t_word` (`f_code`,`f_word`) values (20,'not');
insert into `t_word` (`f_code`,`f_word`) values (21,'our');
insert into `t_word` (`f_code`,`f_word`) values (22,'rely ');
insert into `t_word` (`f_code`,`f_word`) values (23,'only');
insert into `t_word` (`f_code`,`f_word`) values (24,'on');
insert into `t_word` (`f_code`,`f_word`) values (25,'jointly ');
insert into `t_word` (`f_code`,`f_word`) values (26,'instead ');
insert into `t_word` (`f_code`,`f_word`) values (27,'workload ');
insert into `t_word` (`f_code`,`f_word`) values (28,'likely ');
insert into `t_word` (`f_code`,`f_word`) values (29,'appear ');
insert into `t_word` (`f_code`,`f_word`) values (30,'within ');
insert into `t_word` (`f_code`,`f_word`) values (31,'and');
insert into `t_word` (`f_code`,`f_word`) values (32,'text ');
insert into `t_word` (`f_code`,`f_word`) values (33,'fill');
insert into `t_word` (`f_code`,`f_word`) values (34,'forms');
insert into `t_word` (`f_code`,`f_word`) values (35,'shows ');
insert into `t_word` (`f_code`,`f_word`) values (36,'approach ');
insert into `t_word` (`f_code`,`f_word`) values (37,'up');
insert into `t_word` (`f_code`,`f_word`) values (38,'he');
insert into `t_word` (`f_code`,`f_word`) values (39,'a');
insert into `t_word` (`f_code`,`f_word`) values (40,'at');
insert into `t_word` (`f_code`,`f_word`) values (41,'one');
insert into `t_word` (`f_code`,`f_word`) values (42,'took');
insert into `t_word` (`f_code`,`f_word`) values (43,'went');
insert into `t_word` (`f_code`,`f_word`) values (44,'his');
insert into `t_word` (`f_code`,`f_word`) values (45,'to');
insert into `t_word` (`f_code`,`f_word`) values (46,'went');
insert into `t_word` (`f_code`,`f_word`) values (47,'her');
insert into `t_word` (`f_code`,`f_word`) values (48,'');
insert into `t_word` (`f_code`,`f_word`) values (49,'via');
insert into `t_word` (`f_code`,`f_word`) values (50,'but');
insert into `t_word` (`f_code`,`f_word`) values (51,'use');
insert into `t_word` (`f_code`,`f_word`) values (52,'we');
insert into `t_word` (`f_code`,`f_word`) values (53,'like');
insert into `t_word` (`f_code`,`f_word`) values (54,'are');
insert into `t_word` (`f_code`,`f_word`) values (55,'for');
insert into `t_word` (`f_code`,`f_word`) values (56,'its');
insert into `t_word` (`f_code`,`f_word`) values (57,'open');
insert into `t_word` (`f_code`,`f_word`) values (58,'over');
insert into `t_word` (`f_code`,`f_word`) values (59,'via');
insert into `t_word` (`f_code`,`f_word`) values (60,'with');
insert into `t_word` (`f_code`,`f_word`) values (61,'role');
insert into `t_word` (`f_code`,`f_word`) values (62,'for');
insert into `t_word` (`f_code`,`f_word`) values (63,'are');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

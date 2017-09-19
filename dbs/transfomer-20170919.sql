/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.50 : Database - transformer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `t_auth_menufun` */

DROP TABLE IF EXISTS `t_auth_menufun`;

CREATE TABLE `t_auth_menufun` (
  `ID` char(40) NOT NULL COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` char(40) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `MF_ID` char(40) NOT NULL COMMENT '资源id',
  `PMF_ID` char(40) DEFAULT NULL COMMENT '父资源id',
  `MF_NAME` char(200) NOT NULL COMMENT '资源名',
  `MF_LINK` char(200) DEFAULT NULL COMMENT '资源地址',
  `MF_TYPE` char(1) NOT NULL COMMENT '资源类型:0-菜单、1-功能点',
  `MF_DESC` char(200) DEFAULT NULL COMMENT '资源描述',
  `MF_RANK` char(3) DEFAULT NULL COMMENT '顺序',
  `MF_LEVEL` char(3) DEFAULT NULL COMMENT '级别',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='菜单功能点表';

/*Data for the table `t_auth_menufun` */

insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr',NULL,'2017-09-13 15:58:56',NULL,'0000-00-00 00:00:00','img_mgr','root','图片管理','#img-mgr','0',NULL,'1','1');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_view',NULL,'2017-09-13 15:59:01',NULL,'0000-00-00 00:00:00','img_view','root','图片查阅','#img-view','0',NULL,'2','1');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('root',NULL,'2017-09-13 14:42:12',NULL,'0000-00-00 00:00:00','root',NULL,'应用',NULL,'0',NULL,'1','0');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr',NULL,'2017-09-13 14:44:02',NULL,'0000-00-00 00:00:00','system_mgr','root','系统管理',NULL,'0',NULL,'3','1');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth',NULL,'2017-09-14 14:11:39',NULL,'0000-00-00 00:00:00','system_mgr_auth','system_mgr','用户权限管理',NULL,'0',NULL,'1','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role',NULL,'2017-09-14 15:21:20',NULL,'0000-00-00 00:00:00','system_mgr_auth_role','system_mgr_auth','角色管理','#auth-role','0',NULL,'2','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user',NULL,'2017-09-14 15:21:14',NULL,'0000-00-00 00:00:00','system_mgr_auth_user','system_mgr_auth','用户管理','#auth-user','0',NULL,'1','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics',NULL,'2017-09-14 14:12:21',NULL,'0000-00-00 00:00:00','system_mgr_dics','system_mgr','数据字典维护',NULL,'0',NULL,'2','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype',NULL,'2017-09-14 15:21:38',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype','system_mgr_dics','设备类型','#dics-devicetype','0',NULL,'2','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer',NULL,'2017-09-14 15:21:30',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer','system_mgr_dics','变电站','#dics-transformer','0',NULL,'1','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_user',NULL,'2017-09-14 14:12:56',NULL,'0000-00-00 00:00:00','system_mgr_user','system_mgr','个人账户管理',NULL,'0',NULL,'3','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_user_editpwd',NULL,'2017-09-14 15:21:46',NULL,'0000-00-00 00:00:00','system_mgr_user_editpwd','system_mgr_user','修改密码','#user-pwdchange','0',NULL,'1','3');

/*Table structure for table `t_auth_rm` */

DROP TABLE IF EXISTS `t_auth_rm`;

CREATE TABLE `t_auth_rm` (
  `ID` char(40) NOT NULL COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `ROLE_ID` char(40) NOT NULL COMMENT '角色id',
  `MF_ID` char(40) NOT NULL COMMENT '菜单功能点id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色菜单功能点关联表';

/*Data for the table `t_auth_rm` */

insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values ('1',NULL,'2017-09-13 14:46:09','1','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values ('2',NULL,'2017-09-13 14:46:19','1','img_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values ('3',NULL,'2017-09-13 14:46:24','1','img_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values ('4',NULL,'2017-09-13 14:46:30','1','system_mgr');

/*Table structure for table `t_auth_role` */

DROP TABLE IF EXISTS `t_auth_role`;

CREATE TABLE `t_auth_role` (
  `ID` char(40) NOT NULL COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` char(40) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `ROLE_NAME` char(40) NOT NULL COMMENT '角色名',
  `ROLE_DESC` char(100) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色表';

/*Data for the table `t_auth_role` */

insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values ('1',NULL,'2017-09-13 14:45:25',NULL,'0000-00-00 00:00:00','管理员',NULL);

/*Table structure for table `t_auth_ur` */

DROP TABLE IF EXISTS `t_auth_ur`;

CREATE TABLE `t_auth_ur` (
  `ID` char(40) NOT NULL COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `USER_ID` char(40) DEFAULT NULL COMMENT '用户id',
  `ROLE_ID` char(40) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';

/*Data for the table `t_auth_ur` */

insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values ('1',NULL,'2017-09-13 14:45:37','1','1');

/*Table structure for table `t_auth_user` */

DROP TABLE IF EXISTS `t_auth_user`;

CREATE TABLE `t_auth_user` (
  `ID` char(40) NOT NULL COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` char(40) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `LOGIN_NAME` char(40) NOT NULL COMMENT '登录名',
  `NAME` char(40) NOT NULL COMMENT '姓名',
  `PASS_WORD` char(80) NOT NULL COMMENT '密码',
  `IS_USED` char(2) DEFAULT '01' COMMENT '01:有效，02：无效',
  `EMAIL` char(100) DEFAULT NULL COMMENT '邮箱',
  `SEX` char(2) DEFAULT NULL COMMENT '性别',
  `PHONE` char(100) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户表';

/*Data for the table `t_auth_user` */

insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values ('1',NULL,'2017-09-15 15:50:04','1','2017-09-15 15:50:04','admin','管理员','DD4B21E9EF71E1291183A46B913AE6F2','01',NULL,NULL,NULL);

/*Table structure for table `t_base_dics` */

DROP TABLE IF EXISTS `t_base_dics`;

CREATE TABLE `t_base_dics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_type` varchar(40) NOT NULL COMMENT '码表类型',
  `code_value` varchar(50) NOT NULL COMMENT '码值',
  `code_desc` varchar(200) NOT NULL COMMENT '码值描述',
  `is_use` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否启用：0-否，1-是',
  `rank` int(11) DEFAULT NULL COMMENT '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='公共码表';

/*Data for the table `t_base_dics` */

insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (135,'common.yesno','0','否','1',2);
insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (136,'common.yesno','1','是','1',1);

/*Table structure for table `t_base_dics_type` */

DROP TABLE IF EXISTS `t_base_dics_type`;

CREATE TABLE `t_base_dics_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(40) NOT NULL COMMENT '字典类型编码',
  `type_desc` varchar(100) NOT NULL COMMENT '字典类型描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `t_base_dics_type` */

/*Table structure for table `t_biz_device` */

DROP TABLE IF EXISTS `t_biz_device`;

CREATE TABLE `t_biz_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '设备名',
  `type_id` int(11) DEFAULT NULL COMMENT '设备类型',
  `desc` varchar(500) DEFAULT NULL COMMENT '描述',
  `wiringdiagram_id` int(11) NOT NULL COMMENT '接线图id',
  `img_id` varchar(100) DEFAULT NULL COMMENT '图片id',
  `x` int(11) DEFAULT NULL COMMENT '坐标-x',
  `y` int(11) DEFAULT NULL COMMENT '坐标-y',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备';

/*Data for the table `t_biz_device` */

insert  into `t_biz_device`(`id`,`name`,`type_id`,`desc`,`wiringdiagram_id`,`img_id`,`x`,`y`,`width`,`height`,`create_user`,`create_time`) values (1,'设备',1,'设备1描述',3,'242497ab-c3e9-48a5-a13f-dc311e3eca49',50,60,100,100,'1','2017-09-19 15:13:40');
insert  into `t_biz_device`(`id`,`name`,`type_id`,`desc`,`wiringdiagram_id`,`img_id`,`x`,`y`,`width`,`height`,`create_user`,`create_time`) values (2,'设备2',1,'设备2',3,'',20,20,50,50,'1','2017-09-19 16:26:29');

/*Table structure for table `t_biz_device_type` */

DROP TABLE IF EXISTS `t_biz_device_type`;

CREATE TABLE `t_biz_device_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '类型名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `state` varchar(2) NOT NULL DEFAULT '01' COMMENT '状态：01-可用，02-禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备类型';

/*Data for the table `t_biz_device_type` */

insert  into `t_biz_device_type`(`id`,`name`,`create_time`,`create_user`,`state`) values (1,'设备类型1','2017-09-15 16:23:28','1','01');
insert  into `t_biz_device_type`(`id`,`name`,`create_time`,`create_user`,`state`) values (2,'设备类型2','2017-09-15 16:23:34','1','02');

/*Table structure for table `t_biz_files` */

DROP TABLE IF EXISTS `t_biz_files`;

CREATE TABLE `t_biz_files` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `filename_src` varchar(200) NOT NULL COMMENT '文件名-原始',
  `filename_new` varchar(200) NOT NULL COMMENT '文件名-新',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `create_user` varchar(100) NOT NULL COMMENT '上传人',
  `path` varchar(200) NOT NULL COMMENT '文件存储路径-相对',
  `filetype` varchar(50) NOT NULL COMMENT '文件类型',
  `filesize` double NOT NULL COMMENT '文件大小：单位kb',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='附件表';

/*Data for the table `t_biz_files` */

insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('242497ab-c3e9-48a5-a13f-dc311e3eca49','timg (1).jpg','242497ab-c3e9-48a5-a13f-dc311e3eca49.jpg','2017-09-19 10:30:31','1','wg\\2017-09-19\\242497ab-c3e9-48a5-a13f-dc311e3eca49.jpg','jpg',14);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('e777b8e3-4a82-45b0-a56f-f4e8aa75be90','timg.jpg','e777b8e3-4a82-45b0-a56f-f4e8aa75be90.jpg','2017-09-19 10:28:18','1','wg\\2017-09-19\\e777b8e3-4a82-45b0-a56f-f4e8aa75be90.jpg','jpg',39);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('fc73d538-beb3-4231-8724-98df44d19e10','timg.jpg','fc73d538-beb3-4231-8724-98df44d19e10.jpg','2017-09-19 10:53:33','1','wg\\2017-09-19\\fc73d538-beb3-4231-8724-98df44d19e10.jpg','jpg',39);

/*Table structure for table `t_biz_part` */

DROP TABLE IF EXISTS `t_biz_part`;

CREATE TABLE `t_biz_part` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '部件名称',
  `desc` varchar(500) DEFAULT NULL COMMENT '部件描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) DEFAULT NULL COMMENT '图片id',
  `x` int(11) DEFAULT NULL COMMENT '坐标-x',
  `y` int(11) DEFAULT NULL COMMENT '坐标-y',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `type_id` int(11) NOT NULL COMMENT '部件类型',
  `device_id` int(11) NOT NULL COMMENT '设备id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备部件';

/*Data for the table `t_biz_part` */

/*Table structure for table `t_biz_part_his` */

DROP TABLE IF EXISTS `t_biz_part_his`;

CREATE TABLE `t_biz_part_his` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) DEFAULT NULL COMMENT '图片id',
  `content` text NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='部件历史';

/*Data for the table `t_biz_part_his` */

/*Table structure for table `t_biz_transformer` */

DROP TABLE IF EXISTS `t_biz_transformer`;

CREATE TABLE `t_biz_transformer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '名称',
  `type` varchar(200) NOT NULL COMMENT '分类',
  `desc` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `state` varchar(2) NOT NULL DEFAULT '01' COMMENT '状态：01-可用，02-禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='变电站';

/*Data for the table `t_biz_transformer` */

insert  into `t_biz_transformer`(`id`,`name`,`type`,`desc`,`create_user`,`create_time`,`address`,`state`) values (2,'变电站2','公司属变电站','','1','2017-09-15 16:12:26',NULL,'01');
insert  into `t_biz_transformer`(`id`,`name`,`type`,`desc`,`create_user`,`create_time`,`address`,`state`) values (3,'变电站3','用户属变电站','','1','2017-09-15 16:12:33',NULL,'01');

/*Table structure for table `t_biz_wiringdiagram` */

DROP TABLE IF EXISTS `t_biz_wiringdiagram`;

CREATE TABLE `t_biz_wiringdiagram` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) NOT NULL COMMENT '图片id',
  `transformer_id` int(11) NOT NULL COMMENT '变电站id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='接线图';

/*Data for the table `t_biz_wiringdiagram` */

insert  into `t_biz_wiringdiagram`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`transformer_id`) values (1,'接线图1','2017-09-18 18:08:44','1','fc73d538-beb3-4231-8724-98df44d19e10',3);
insert  into `t_biz_wiringdiagram`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`transformer_id`) values (2,'接线图2','2017-09-19 10:28:19','1','e777b8e3-4a82-45b0-a56f-f4e8aa75be90',3);
insert  into `t_biz_wiringdiagram`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`transformer_id`) values (3,'接线图3','2017-09-19 10:30:33','1','242497ab-c3e9-48a5-a13f-dc311e3eca49',3);

/* Function  structure for function  `getDeviceTypeNameById` */

/*!50003 DROP FUNCTION IF EXISTS `getDeviceTypeNameById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` FUNCTION `getDeviceTypeNameById`(device_id INT) RETURNS varchar(200) CHARSET utf8
BEGIN
	DECLARE ret VARCHAR(200);
	DECLARE done INT DEFAULT FALSE;
	DECLARE cur CURSOR FOR SELECT `name` FROM t_biz_device_type WHERE id=customer_id;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	OPEN cur;
		FETCH cur INTO ret;
	CLOSE cur;
	RETURN ret;
    END */$$
DELIMITER ;

/* Function  structure for function  `getDicValue` */

/*!50003 DROP FUNCTION IF EXISTS `getDicValue` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` FUNCTION `getDicValue`(cv VARCHAR(100), ct VARCHAR(40)) RETURNS varchar(200) CHARSET utf8
BEGIN
     DECLARE ret VARCHAR(200);
     DECLARE done INT DEFAULT FALSE;
     DECLARE cur CURSOR  FOR SELECT code_desc FROM t_base_dics WHERE code_type = ct AND code_value = cv;
     DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;        
     OPEN cur;
         FETCH cur INTO ret;
      CLOSE cur;
     RETURN ret;
    END */$$
DELIMITER ;

/* Function  structure for function  `getusername` */

/*!50003 DROP FUNCTION IF EXISTS `getusername` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` FUNCTION `getusername`(userid VARCHAR(100)) RETURNS varchar(200) CHARSET utf8
BEGIN
	DECLARE ret VARCHAR(200);
	DECLARE done INT DEFAULT FALSE;
	DECLARE cur CURSOR  FOR SELECT `name` FROM t_auth_user WHERE id = userid;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;		
	SET ret = '';
	OPEN cur;
		FETCH cur INTO ret;
	 CLOSE cur;
	RETURN ret;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

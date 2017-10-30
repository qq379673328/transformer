/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.50-log : Database - transfomer
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
  `ID` char(100) NOT NULL COMMENT '主键',
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

insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','img_mgr','root','图片管理','#img-mgr','0',NULL,'1','1');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_verify',NULL,'2017-10-24 17:32:37',NULL,'0000-00-00 00:00:00','img_mgr_verify','img_mgr','审核',NULL,'1',NULL,'2','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_view',NULL,'2017-10-24 17:41:40',NULL,'0000-00-00 00:00:00','img_mgr_view','img_mgr','管理',NULL,'1',NULL,'1','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_view',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','img_view','root','图片查阅','#img-view?IS_VIEW=true','0',NULL,'2','1');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('root',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','root',NULL,'应用',NULL,'0',NULL,'1','0');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr','root','系统管理',NULL,'0',NULL,'3','1');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_auth','system_mgr','用户权限管理',NULL,'0',NULL,'1','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_auth_role','system_mgr_auth','角色管理','#auth-role','0',NULL,'2','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_add',NULL,'2017-10-30 17:48:31',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_add','system_mgr_auth_role','新增',NULL,'1',NULL,'1','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_del',NULL,'2017-10-30 17:48:32',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_del','system_mgr_auth_role','删除',NULL,'1',NULL,'5','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_edit',NULL,'2017-10-30 17:48:33',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_edit','system_mgr_auth_role','编辑',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_perm',NULL,'2017-10-30 17:48:34',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_perm','system_mgr_auth_role','授权',NULL,'1',NULL,'4','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_search',NULL,'2017-10-30 17:48:36',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_search','system_mgr_auth_role','查询',NULL,'1',NULL,'0','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_view',NULL,'2017-10-30 17:48:40',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_view','system_mgr_auth_role','查看',NULL,'1',NULL,'3','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_auth_user','system_mgr_auth','用户管理','#auth-user','0',NULL,'1','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_add',NULL,'2017-10-30 17:48:41',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_add','system_mgr_auth_user','新增',NULL,'1',NULL,'1','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_disable',NULL,'2017-10-30 17:48:42',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_disable','system_mgr_auth_user','禁用',NULL,'1',NULL,'4','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_edit',NULL,'2017-10-30 17:48:43',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_edit','system_mgr_auth_user','编辑',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_enable',NULL,'2017-10-30 17:48:44',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_enable','system_mgr_auth_user','启用',NULL,'1',NULL,'3','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_resetpwd',NULL,'2017-10-30 17:48:45',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_resetpwd','system_mgr_auth_user','重置密码',NULL,'1',NULL,'5','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_search',NULL,'2017-10-30 17:48:45',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_search','system_mgr_auth_user','查询',NULL,'1',NULL,'0','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_setrole',NULL,'2017-10-30 17:48:46',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_setrole','system_mgr_auth_user','分配角色',NULL,'1',NULL,'6','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_config',NULL,'2017-10-30 16:35:58',NULL,'0000-00-00 00:00:00','system_mgr_config','system_mgr','系统配置',NULL,'0',NULL,'3','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_config_params',NULL,'2017-10-30 16:44:51',NULL,'0000-00-00 00:00:00','system_mgr_config_params','system_mgr_config','参数配置','#system-config-params','0',NULL,'1','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_config_params_edit',NULL,'2017-10-30 17:52:44',NULL,'0000-00-00 00:00:00','system_mgr_config_params_edit','system_mgr_config_params','编辑',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_config_params_search',NULL,'2017-10-30 17:52:44',NULL,'0000-00-00 00:00:00','system_mgr_config_params_search','system_mgr_config_params','查询',NULL,'1',NULL,'1','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_dics','system_mgr','数据字典维护',NULL,'0',NULL,'2','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype','system_mgr_dics','设备/部件类型','#dics-devicetype','0',NULL,'2','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_add',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_add','system_mgr_dics_devicetype','新增',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_disable',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_disable','system_mgr_dics_devicetype','禁用',NULL,'1',NULL,'5','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_edit',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_edit','system_mgr_dics_devicetype','编辑',NULL,'1',NULL,'3','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_enable',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_enable','system_mgr_dics_devicetype','启用',NULL,'1',NULL,'4','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_search',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_search','system_mgr_dics_devicetype','查询',NULL,'1',NULL,'1','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer','system_mgr_dics','变电站','#dics-transformer','0',NULL,'1','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_add',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_add','system_mgr_dics_transformer','新增',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_del',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_del','system_mgr_dics_transformer','删除',NULL,'1',NULL,'6','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_disable',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_disable','system_mgr_dics_transformer','禁用',NULL,'1',NULL,'5','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_edit',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_edit','system_mgr_dics_transformer','编辑',NULL,'1',NULL,'3','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_enable',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_enable','system_mgr_dics_transformer','启用',NULL,'1',NULL,'4','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_search',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_search','system_mgr_dics_transformer','查询',NULL,'1',NULL,'1','4');

/*Table structure for table `t_auth_rm` */

DROP TABLE IF EXISTS `t_auth_rm`;

CREATE TABLE `t_auth_rm` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `ROLE_ID` char(40) NOT NULL COMMENT '角色id',
  `MF_ID` char(40) NOT NULL COMMENT '菜单功能点id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=304 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色菜单功能点关联表';

/*Data for the table `t_auth_rm` */

insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (190,NULL,'2017-10-30 17:55:05','1','img_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (191,NULL,'2017-10-30 17:55:05','1','img_mgr_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (192,NULL,'2017-10-30 17:55:05','1','img_mgr_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (193,NULL,'2017-10-30 17:55:05','1','img_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (194,NULL,'2017-10-30 17:55:05','1','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (195,NULL,'2017-10-30 17:55:05','1','system_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (196,NULL,'2017-10-30 17:55:05','1','system_mgr_auth');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (197,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_role');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (198,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_role_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (199,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_role_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (200,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_role_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (201,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_role_perm');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (202,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_role_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (203,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_role_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (204,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_user');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (205,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_user_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (206,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_user_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (207,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_user_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (208,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_user_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (209,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_user_resetpwd');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (210,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_user_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (211,NULL,'2017-10-30 17:55:05','1','system_mgr_auth_user_setrole');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (212,NULL,'2017-10-30 17:55:05','1','system_mgr_config');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (213,NULL,'2017-10-30 17:55:05','1','system_mgr_config_params');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (214,NULL,'2017-10-30 17:55:05','1','system_mgr_config_params_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (215,NULL,'2017-10-30 17:55:05','1','system_mgr_config_params_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (216,NULL,'2017-10-30 17:55:05','1','system_mgr_dics');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (217,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_devicetype');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (218,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_devicetype_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (219,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_devicetype_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (220,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_devicetype_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (221,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_devicetype_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (222,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_devicetype_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (223,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_transformer');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (224,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_transformer_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (225,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_transformer_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (226,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_transformer_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (227,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_transformer_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (228,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_transformer_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (229,NULL,'2017-10-30 17:55:05','1','system_mgr_dics_transformer_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (253,NULL,'2017-10-30 17:56:08','4','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (254,NULL,'2017-10-30 17:56:08','4','img_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (255,NULL,'2017-10-30 17:56:08','4','img_mgr_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (256,NULL,'2017-10-30 17:56:08','4','img_mgr_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (257,NULL,'2017-10-30 17:56:08','4','img_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (258,NULL,'2017-10-30 17:56:08','4','system_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (259,NULL,'2017-10-30 17:56:08','4','system_mgr_auth');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (260,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_user');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (261,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_user_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (262,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_user_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (263,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_user_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (264,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_user_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (265,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_user_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (266,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_user_resetpwd');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (267,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_user_setrole');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (268,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_role');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (269,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_role_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (270,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_role_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (271,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_role_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (272,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_role_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (273,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_role_perm');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (274,NULL,'2017-10-30 17:56:08','4','system_mgr_auth_role_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (275,NULL,'2017-10-30 17:56:08','4','system_mgr_dics');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (276,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_transformer');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (277,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_transformer_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (278,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_transformer_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (279,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_transformer_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (280,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_transformer_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (281,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_transformer_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (282,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_transformer_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (283,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_devicetype');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (284,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_devicetype_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (285,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_devicetype_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (286,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_devicetype_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (287,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_devicetype_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (288,NULL,'2017-10-30 17:56:08','4','system_mgr_dics_devicetype_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (289,NULL,'2017-10-30 17:56:08','4','system_mgr_config');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (290,NULL,'2017-10-30 17:56:08','4','system_mgr_config_params');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (291,NULL,'2017-10-30 17:56:08','4','system_mgr_config_params_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (292,NULL,'2017-10-30 17:56:08','4','system_mgr_config_params_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (293,NULL,'2017-10-30 17:56:17','2','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (294,NULL,'2017-10-30 17:56:17','2','img_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (295,NULL,'2017-10-30 17:56:28','3','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (296,NULL,'2017-10-30 17:56:28','3','img_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (297,NULL,'2017-10-30 17:56:28','3','img_mgr_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (298,NULL,'2017-10-30 17:56:28','3','img_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (299,NULL,'2017-10-30 17:56:46','5','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (300,NULL,'2017-10-30 17:56:46','5','img_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (301,NULL,'2017-10-30 17:56:46','5','img_mgr_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (302,NULL,'2017-10-30 17:56:46','5','img_mgr_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (303,NULL,'2017-10-30 17:56:46','5','img_view');

/*Table structure for table `t_auth_role` */

DROP TABLE IF EXISTS `t_auth_role`;

CREATE TABLE `t_auth_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CREATE_USER` int(11) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` int(11) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `ROLE_NAME` char(40) NOT NULL COMMENT '角色名',
  `ROLE_DESC` char(100) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色表';

/*Data for the table `t_auth_role` */

insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (1,NULL,'2017-10-24 17:35:17',1,'2017-10-24 17:35:17','超级管理员（勿删除）','所有权限');
insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (2,1,'2017-10-24 17:34:58',1,'2017-10-24 17:34:58','图片查阅人员','图片查阅');
insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (3,1,'2017-10-24 17:34:40',1,'2017-10-24 17:34:40','图片管理编辑人员','图片管理、查阅');
insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (4,1,'2017-10-24 17:35:07',1,'2017-10-24 17:35:07','系统管理员','系统管理');
insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (5,1,'2017-10-24 17:33:31',NULL,'2017-10-24 17:33:31','图片管理审核人员','图片管理、审核、查阅');

/*Table structure for table `t_auth_ur` */

DROP TABLE IF EXISTS `t_auth_ur`;

CREATE TABLE `t_auth_ur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `USER_ID` int(11) DEFAULT NULL COMMENT '用户id',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';

/*Data for the table `t_auth_ur` */

insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (1,NULL,'2017-09-13 14:45:37',1,1);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (4,'1','2017-10-22 09:47:19',2,2);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (5,'1','2017-10-22 10:05:24',5,4);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (6,'1','2017-10-22 10:05:29',4,3);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (7,'1','2017-10-22 10:05:34',3,2);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (8,'1','2017-10-24 17:34:22',6,5);

/*Table structure for table `t_auth_user` */

DROP TABLE IF EXISTS `t_auth_user`;

CREATE TABLE `t_auth_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户表';

/*Data for the table `t_auth_user` */

insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (1,NULL,'2017-09-15 15:50:04','1','2017-09-15 15:50:04','admin','管理员','DD4B21E9EF71E1291183A46B913AE6F2','01',NULL,NULL,NULL);
insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (3,'1','2017-10-22 10:04:47',NULL,'2017-10-22 10:04:47','chakan','图片查看测试人员','DD4B21E9EF71E1291183A46B913AE6F2','1',NULL,NULL,NULL);
insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (4,'1','2017-10-22 10:05:07',NULL,'2017-10-22 10:05:07','tupianguanli','图片管理测试人员','DD4B21E9EF71E1291183A46B913AE6F2','1',NULL,NULL,NULL);
insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (5,'1','2017-10-24 17:30:35','1','2017-10-24 17:30:35','xitongguanli','系统管理测试人员','DD4B21E9EF71E1291183A46B913AE6F2','1',NULL,NULL,NULL);
insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (6,'1','2017-10-24 17:34:15',NULL,'2017-10-24 17:34:15','tupianshenhe','图片审核测试人员','DD4B21E9EF71E1291183A46B913AE6F2','1',NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='公共码表';

/*Data for the table `t_base_dics` */

insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (135,'common.yesno','0','否','1',2);
insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (136,'common.yesno','1','是','1',1);
insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (137,'common.verify','0','待审核','1',1);
insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (138,'common.verify','1','审核通过','1',2);
insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (139,'common.verify','9','审核未通过','1',3);

/*Table structure for table `t_base_dics_type` */

DROP TABLE IF EXISTS `t_base_dics_type`;

CREATE TABLE `t_base_dics_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(40) NOT NULL COMMENT '字典类型编码',
  `type_desc` varchar(100) NOT NULL COMMENT '字典类型描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备';

/*Data for the table `t_biz_device` */

insert  into `t_biz_device`(`id`,`name`,`type_id`,`desc`,`wiringdiagram_id`,`img_id`,`x`,`y`,`width`,`height`,`create_user`,`create_time`) values (2,'设备2',1,'设备2',3,'fb5ca802-d283-4bfa-bff8-885a7d7bada8',57,193,132,151,'1','2017-09-19 16:26:29');
insert  into `t_biz_device`(`id`,`name`,`type_id`,`desc`,`wiringdiagram_id`,`img_id`,`x`,`y`,`width`,`height`,`create_user`,`create_time`) values (3,'设备3',2,'设备3',3,'1f24bdcc-727f-4767-808b-9c42e5e9f08d',277,194,100,50,'1','2017-10-15 18:53:55');
insert  into `t_biz_device`(`id`,`name`,`type_id`,`desc`,`wiringdiagram_id`,`img_id`,`x`,`y`,`width`,`height`,`create_user`,`create_time`) values (4,'设备1000',2,'',3,'7b073d5d-3af5-48d1-ba88-a0c7943717b1',156,25,100,100,'1','2017-10-21 11:55:37');

/*Table structure for table `t_biz_device_img` */

DROP TABLE IF EXISTS `t_biz_device_img`;

CREATE TABLE `t_biz_device_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) NOT NULL COMMENT '图片id',
  `device_id` int(11) NOT NULL COMMENT '设备id',
  `verify_status` varchar(2) NOT NULL DEFAULT '0' COMMENT '审核状态：0-待审核，1-审核通过，9审核不通过',
  `verify_time` datetime DEFAULT NULL COMMENT '审核时间',
  `verify_user` varchar(100) DEFAULT NULL COMMENT '审核人',
  `verify_content` varchar(500) DEFAULT NULL COMMENT '审核结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='设备图';

/*Data for the table `t_biz_device_img` */

insert  into `t_biz_device_img`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`device_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (1,'设备图1','2017-10-15 16:32:14','1','9cb31e14-4cd5-4fa0-a879-03070ceb901a',1,'0',NULL,NULL,NULL);
insert  into `t_biz_device_img`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`device_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (2,'设备图2','2017-10-15 16:41:24','1','870dadcf-5719-4306-bec0-d563991da4ae',1,'0',NULL,NULL,NULL);
insert  into `t_biz_device_img`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`device_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (3,'设备图A','2017-10-15 16:51:36','1','6494610f-2498-4fdd-8e07-18f9835e1751',2,'1','2017-10-30 17:36:43','1','');
insert  into `t_biz_device_img`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`device_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (4,'图1','2017-10-22 11:30:19','4','7cefffc6-c1b7-455f-9568-40b38c45ea4c',5,'0',NULL,NULL,NULL);

/*Table structure for table `t_biz_device_type` */

DROP TABLE IF EXISTS `t_biz_device_type`;

CREATE TABLE `t_biz_device_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '类型名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `state` varchar(2) NOT NULL DEFAULT '01' COMMENT '状态：01-可用，02-禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备类型';

/*Data for the table `t_biz_device_type` */

insert  into `t_biz_device_type`(`id`,`name`,`create_time`,`create_user`,`state`) values (1,'变压器','2017-09-15 16:23:28','1','01');
insert  into `t_biz_device_type`(`id`,`name`,`create_time`,`create_user`,`state`) values (2,'电线','2017-09-15 16:23:34','1','01');
insert  into `t_biz_device_type`(`id`,`name`,`create_time`,`create_user`,`state`) values (3,'其它','2017-10-21 11:57:39','1','01');

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

insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('05ff46b7-e54a-4b44-a27e-982c11bac10c','u404.png','05ff46b7-e54a-4b44-a27e-982c11bac10c.png','2017-10-21 11:12:13','1','parthis\\2017-10-21\\05ff46b7-e54a-4b44-a27e-982c11bac10c.png','png',51);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('1056ea7f-23d5-491f-bb11-63795abc55d8','u0.png','1056ea7f-23d5-491f-bb11-63795abc55d8.png','2017-10-21 12:19:52','1','device\\2017-10-21\\1056ea7f-23d5-491f-bb11-63795abc55d8.png','png',6);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('10b6d96f-f704-4671-827a-93820acbf2bb','u684.jpg','10b6d96f-f704-4671-827a-93820acbf2bb.jpg','2017-10-15 16:43:09','1','device\\2017-10-15\\10b6d96f-f704-4671-827a-93820acbf2bb.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('12de3e9e-deb4-47bd-9dc4-0fe114e0c801','u175.jpg','12de3e9e-deb4-47bd-9dc4-0fe114e0c801.jpg','2017-10-22 11:29:51','4','device\\2017-10-22\\12de3e9e-deb4-47bd-9dc4-0fe114e0c801.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('130e55d8-28b7-4509-9a5f-130457d8ce90','u306.jpg','130e55d8-28b7-4509-9a5f-130457d8ce90.jpg','2017-10-21 12:21:19','1','device\\2017-10-21\\130e55d8-28b7-4509-9a5f-130457d8ce90.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('14407ead-3be3-4b16-b683-6686d6fc1dc0','u412.jpg','14407ead-3be3-4b16-b683-6686d6fc1dc0.jpg','2017-10-15 18:27:52','1','parthis\\2017-10-15\\14407ead-3be3-4b16-b683-6686d6fc1dc0.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('186f67db-24e0-437e-b72f-7c2c649b00f1','u306.jpg','186f67db-24e0-437e-b72f-7c2c649b00f1.jpg','2017-10-15 18:46:42','1','parthis\\2017-10-15\\186f67db-24e0-437e-b72f-7c2c649b00f1.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('1f24bdcc-727f-4767-808b-9c42e5e9f08d','u175.jpg','1f24bdcc-727f-4767-808b-9c42e5e9f08d.jpg','2017-10-21 11:30:01','1','device\\2017-10-21\\1f24bdcc-727f-4767-808b-9c42e5e9f08d.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('21c03a71-9038-450c-b794-d7cce5bcf035','u553.jpg','21c03a71-9038-450c-b794-d7cce5bcf035.jpg','2017-10-15 18:41:57','1','parthis\\2017-10-15\\21c03a71-9038-450c-b794-d7cce5bcf035.jpg','jpg',161);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('242497ab-c3e9-48a5-a13f-dc311e3eca49','timg (1).jpg','242497ab-c3e9-48a5-a13f-dc311e3eca49.jpg','2017-09-19 10:30:31','1','wg\\2017-09-19\\242497ab-c3e9-48a5-a13f-dc311e3eca49.jpg','jpg',14);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('288c7a18-d2ce-4d78-8051-7da83d2af480','u306.jpg','288c7a18-d2ce-4d78-8051-7da83d2af480.jpg','2017-10-21 11:12:57','1','parthis\\2017-10-21\\288c7a18-d2ce-4d78-8051-7da83d2af480.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('2b12ff7e-ec69-4354-9b00-ad5bb2463ba6','u120.png','2b12ff7e-ec69-4354-9b00-ad5bb2463ba6.png','2017-10-22 09:59:55','1','wg\\2017-10-22\\2b12ff7e-ec69-4354-9b00-ad5bb2463ba6.png','png',142);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('2dd780e8-df9b-4249-8e22-bb0521f09109','u306.jpg','2dd780e8-df9b-4249-8e22-bb0521f09109.jpg','2017-10-21 11:12:37','1','parthis\\2017-10-21\\2dd780e8-df9b-4249-8e22-bb0521f09109.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('2ee32ba9-4726-467a-b7e5-d40df700adb7','u553.jpg','2ee32ba9-4726-467a-b7e5-d40df700adb7.jpg','2017-10-15 18:54:45','1','device\\2017-10-15\\2ee32ba9-4726-467a-b7e5-d40df700adb7.jpg','jpg',161);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('39ea2bcf-9917-41d1-ba88-a2b05afd223b','u120.png','39ea2bcf-9917-41d1-ba88-a2b05afd223b.png','2017-10-14 15:43:27','1','wg\\2017-10-14\\39ea2bcf-9917-41d1-ba88-a2b05afd223b.png','png',142);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('55ec9e8d-b7f6-48d0-bdb1-6a9d53268640','u175.jpg','55ec9e8d-b7f6-48d0-bdb1-6a9d53268640.jpg','2017-10-22 10:00:13','1','wg\\2017-10-22\\55ec9e8d-b7f6-48d0-bdb1-6a9d53268640.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('6494610f-2498-4fdd-8e07-18f9835e1751','u306.jpg','6494610f-2498-4fdd-8e07-18f9835e1751.jpg','2017-10-15 16:51:34','1','deviceimg\\2017-10-15\\6494610f-2498-4fdd-8e07-18f9835e1751.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('66b4835c-735e-4d32-b80d-b86f1012fa2b','u684.jpg','66b4835c-735e-4d32-b80d-b86f1012fa2b.jpg','2017-10-15 18:53:54','1','device\\2017-10-15\\66b4835c-735e-4d32-b80d-b86f1012fa2b.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('7860290f-6ca4-4a5a-96f7-02d742a0f0ea','u175.jpg','7860290f-6ca4-4a5a-96f7-02d742a0f0ea.jpg','2017-10-21 11:55:35','1','device\\2017-10-21\\7860290f-6ca4-4a5a-96f7-02d742a0f0ea.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('7b073d5d-3af5-48d1-ba88-a0c7943717b1','u306.jpg','7b073d5d-3af5-48d1-ba88-a0c7943717b1.jpg','2017-10-21 12:20:05','1','device\\2017-10-21\\7b073d5d-3af5-48d1-ba88-a0c7943717b1.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('7cefffc6-c1b7-455f-9568-40b38c45ea4c','u412.jpg','7cefffc6-c1b7-455f-9568-40b38c45ea4c.jpg','2017-10-22 11:30:17','4','deviceimg\\2017-10-22\\7cefffc6-c1b7-455f-9568-40b38c45ea4c.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('83846f3b-6100-4637-8522-11091914a604','u306.jpg','83846f3b-6100-4637-8522-11091914a604.jpg','2017-10-15 18:46:51','1','parthis\\2017-10-15\\83846f3b-6100-4637-8522-11091914a604.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('870dadcf-5719-4306-bec0-d563991da4ae','u553.jpg','870dadcf-5719-4306-bec0-d563991da4ae.jpg','2017-10-15 16:41:22','1','deviceimg\\2017-10-15\\870dadcf-5719-4306-bec0-d563991da4ae.jpg','jpg',161);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('90bf8e67-a7d6-4ceb-a5d6-35e8a85220d8','u404.png','90bf8e67-a7d6-4ceb-a5d6-35e8a85220d8.png','2017-10-21 10:57:32','1','device\\2017-10-21\\90bf8e67-a7d6-4ceb-a5d6-35e8a85220d8.png','png',51);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('9cb31e14-4cd5-4fa0-a879-03070ceb901a','u412.jpg','9cb31e14-4cd5-4fa0-a879-03070ceb901a.jpg','2017-10-15 16:32:05','1','deviceimg\\2017-10-15\\9cb31e14-4cd5-4fa0-a879-03070ceb901a.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('a3cfdc2b-f883-40c2-8b3e-6a07af561896','u120.png','a3cfdc2b-f883-40c2-8b3e-6a07af561896.png','2017-10-22 10:00:28','1','wg\\2017-10-22\\a3cfdc2b-f883-40c2-8b3e-6a07af561896.png','png',142);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('a8a26041-28ec-4626-bab7-f3d251ee529f','u412.jpg','a8a26041-28ec-4626-bab7-f3d251ee529f.jpg','2017-10-15 18:46:34','1','parthis\\2017-10-15\\a8a26041-28ec-4626-bab7-f3d251ee529f.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('a99137e4-435b-473b-a185-6e453c8b3672','u306.jpg','a99137e4-435b-473b-a185-6e453c8b3672.jpg','2017-10-21 11:12:51','1','parthis\\2017-10-21\\a99137e4-435b-473b-a185-6e453c8b3672.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('bd5e057f-63f0-4fe6-a33e-2757a5eacf6e','u553.jpg','bd5e057f-63f0-4fe6-a33e-2757a5eacf6e.jpg','2017-10-15 18:46:18','1','device\\2017-10-15\\bd5e057f-63f0-4fe6-a33e-2757a5eacf6e.jpg','jpg',161);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('ca85d0ce-b9e1-4bba-80fa-d6a2fa7d5dce','u306.jpg','ca85d0ce-b9e1-4bba-80fa-d6a2fa7d5dce.jpg','2017-10-21 11:12:23','1','parthis\\2017-10-21\\ca85d0ce-b9e1-4bba-80fa-d6a2fa7d5dce.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('d32f225d-8092-4cfe-99a4-ac41461677c5','u0.png','d32f225d-8092-4cfe-99a4-ac41461677c5.png','2017-10-21 11:29:45','1','wg\\2017-10-21\\d32f225d-8092-4cfe-99a4-ac41461677c5.png','png',6);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('d6f15a4c-13cf-474c-b7bf-f3d787218bde','u306.jpg','d6f15a4c-13cf-474c-b7bf-f3d787218bde.jpg','2017-10-15 18:55:00','1','parthis\\2017-10-15\\d6f15a4c-13cf-474c-b7bf-f3d787218bde.jpg','jpg',193);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('d86748c9-2b7a-4c43-acc6-877077b7eed0','u553.jpg','d86748c9-2b7a-4c43-acc6-877077b7eed0.jpg','2017-10-15 18:23:36','1','parthis\\2017-10-15\\d86748c9-2b7a-4c43-acc6-877077b7eed0.jpg','jpg',161);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('e03c5c7f-d420-4d43-a05d-e54acc3dc1ee','u4.png','e03c5c7f-d420-4d43-a05d-e54acc3dc1ee.png','2017-10-30 22:29:14','1','wg\\2017-10-30\\e03c5c7f-d420-4d43-a05d-e54acc3dc1ee.png','png',215);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('e2ed5aed-8293-453f-8449-c996e8bd3ae1','u553.jpg','e2ed5aed-8293-453f-8449-c996e8bd3ae1.jpg','2017-10-15 16:52:56','1','device\\2017-10-15\\e2ed5aed-8293-453f-8449-c996e8bd3ae1.jpg','jpg',161);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('e6575849-4e9e-4924-a239-89ad74b36b51','u175.jpg','e6575849-4e9e-4924-a239-89ad74b36b51.jpg','2017-10-21 11:12:29','1','parthis\\2017-10-21\\e6575849-4e9e-4924-a239-89ad74b36b51.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('e777b8e3-4a82-45b0-a56f-f4e8aa75be90','timg.jpg','e777b8e3-4a82-45b0-a56f-f4e8aa75be90.jpg','2017-09-19 10:28:18','1','wg\\2017-09-19\\e777b8e3-4a82-45b0-a56f-f4e8aa75be90.jpg','jpg',39);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('eb066311-5d7f-4c1a-910c-be545d86e52b','u120.png','eb066311-5d7f-4c1a-910c-be545d86e52b.png','2017-10-14 15:44:30','1','wg\\2017-10-14\\eb066311-5d7f-4c1a-910c-be545d86e52b.png','png',142);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('f8672729-51df-43b7-a589-12beff2d60fc','u175.jpg','f8672729-51df-43b7-a589-12beff2d60fc.jpg','2017-10-21 11:13:04','1','parthis\\2017-10-21\\f8672729-51df-43b7-a589-12beff2d60fc.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('fadaf527-b24d-4046-a28f-a2e2604301b9','u120.png','fadaf527-b24d-4046-a28f-a2e2604301b9.png','2017-10-14 15:44:42','1','wg\\2017-10-14\\fadaf527-b24d-4046-a28f-a2e2604301b9.png','png',142);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('fb383fe9-47d1-47e2-8210-97da56ac8874','u175.jpg','fb383fe9-47d1-47e2-8210-97da56ac8874.jpg','2017-10-21 11:12:44','1','parthis\\2017-10-21\\fb383fe9-47d1-47e2-8210-97da56ac8874.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('fb5ca802-d283-4bfa-bff8-885a7d7bada8','u175.jpg','fb5ca802-d283-4bfa-bff8-885a7d7bada8.jpg','2017-10-21 10:56:03','1','device\\2017-10-21\\fb5ca802-d283-4bfa-bff8-885a7d7bada8.jpg','jpg',219);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('fc73d538-beb3-4231-8724-98df44d19e10','timg.jpg','fc73d538-beb3-4231-8724-98df44d19e10.jpg','2017-09-19 10:53:33','1','wg\\2017-09-19\\fc73d538-beb3-4231-8724-98df44d19e10.jpg','jpg',39);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('fc8f66f9-fc6a-4a3e-ad99-4d37c3964803','login-bg.jpg','fc8f66f9-fc6a-4a3e-ad99-4d37c3964803.jpg','2017-10-30 21:56:46','1','parthis\\2017-10-30\\fc8f66f9-fc6a-4a3e-ad99-4d37c3964803.jpg','jpg',445);

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
  `device_img_id` int(11) NOT NULL COMMENT '设备图id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备部件';

/*Data for the table `t_biz_part` */

insert  into `t_biz_part`(`id`,`name`,`desc`,`create_time`,`create_user`,`img_id`,`x`,`y`,`width`,`height`,`type_id`,`device_img_id`) values (1,'部件1','部件1描述','2017-10-15 16:43:11','1','10b6d96f-f704-4671-827a-93820acbf2bb',100,20,50,70,1,2);
insert  into `t_biz_part`(`id`,`name`,`desc`,`create_time`,`create_user`,`img_id`,`x`,`y`,`width`,`height`,`type_id`,`device_img_id`) values (2,'部件2','部件2','2017-10-15 16:52:58','1','e2ed5aed-8293-453f-8449-c996e8bd3ae1',100,100,30,30,2,2);
insert  into `t_biz_part`(`id`,`name`,`desc`,`create_time`,`create_user`,`img_id`,`x`,`y`,`width`,`height`,`type_id`,`device_img_id`) values (3,'部件21','部件21','2017-10-15 18:46:20','1','90bf8e67-a7d6-4ceb-a5d6-35e8a85220d8',42,21,157,199,2,3);

/*Table structure for table `t_biz_part_his` */

DROP TABLE IF EXISTS `t_biz_part_his`;

CREATE TABLE `t_biz_part_his` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) DEFAULT NULL COMMENT '图片id',
  `content` text NOT NULL COMMENT '内容',
  `part_id` int(11) NOT NULL COMMENT '部件id',
  `verify_time` datetime DEFAULT NULL COMMENT '审核时间',
  `verify_status` varchar(2) NOT NULL DEFAULT '0' COMMENT '审核状态',
  `verify_user` varchar(100) DEFAULT NULL COMMENT '审核人',
  `verify_content` varchar(500) DEFAULT NULL COMMENT '审核内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='部件历史';

/*Data for the table `t_biz_part_his` */

insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (1,'2017-10-15 18:23:38','1','d86748c9-2b7a-4c43-acc6-877077b7eed0','斯蒂芬斯蒂芬',1,NULL,'0',NULL,NULL);
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (3,'2017-10-15 18:41:58','1','21c03a71-9038-450c-b794-d7cce5bcf035','sdfsdf',1,NULL,'0',NULL,NULL);
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (4,'2017-10-15 18:46:36','1','a8a26041-28ec-4626-bab7-f3d251ee529f','信息1',3,NULL,'0',NULL,NULL);
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (5,'2017-10-15 18:46:43','1','186f67db-24e0-437e-b72f-7c2c649b00f1','信息二',3,NULL,'0',NULL,NULL);
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (6,'2017-10-15 18:46:52','1','83846f3b-6100-4637-8522-11091914a604','信息三',3,'2017-10-30 17:36:55','1','1','');
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (7,'2017-10-15 18:55:01','1','d6f15a4c-13cf-474c-b7bf-f3d787218bde','信息1',4,NULL,'0',NULL,NULL);
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (8,'2017-10-21 11:12:14','1','05ff46b7-e54a-4b44-a27e-982c11bac10c','内容',3,'2017-10-30 17:36:52','1','1','');
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (9,'2017-10-21 11:12:24','1','ca85d0ce-b9e1-4bba-80fa-d6a2fa7d5dce','内容',3,'2017-10-30 16:28:48','9','1','dsfd');
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (10,'2017-10-21 11:12:31','1','e6575849-4e9e-4924-a239-89ad74b36b51','内容',3,'2017-10-30 16:28:33','1','1','123123');
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (11,'2017-10-21 11:12:38','1','2dd780e8-df9b-4249-8e22-bb0521f09109','内容',3,'2017-10-30 16:28:29','1','1','');
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (12,'2017-10-21 11:12:46','1','fb383fe9-47d1-47e2-8210-97da56ac8874','内容',3,'2017-10-30 16:28:26','1','1','');
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (13,'2017-10-21 11:12:52','1','a99137e4-435b-473b-a185-6e453c8b3672','内容',3,'2017-10-30 16:28:23','1','1','');
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (15,'2017-10-21 11:13:06','1','f8672729-51df-43b7-a589-12beff2d60fc','内容',3,'2017-10-30 16:14:18','1','1','');
insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (17,'2017-10-27 17:24:06','1','fc8f66f9-fc6a-4a3e-ad99-4d37c3964803','123水电费水电费水电费水电费123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费 123水电费水电费水电费水电费',3,NULL,'0',NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='变电站';

/*Data for the table `t_biz_transformer` */

insert  into `t_biz_transformer`(`id`,`name`,`type`,`desc`,`create_user`,`create_time`,`address`,`state`) values (2,'变电站2','用户属变电站','变电站描述','1','2017-09-15 16:12:26',NULL,'01');
insert  into `t_biz_transformer`(`id`,`name`,`type`,`desc`,`create_user`,`create_time`,`address`,`state`) values (3,'变电站3','公司属变电站','变电站描述','1','2017-09-15 16:12:33',NULL,'01');
insert  into `t_biz_transformer`(`id`,`name`,`type`,`desc`,`create_user`,`create_time`,`address`,`state`) values (4,'变电站四','用户属变电站','变电站四的描述','1','2017-10-22 09:48:03',NULL,'01');

/*Table structure for table `t_biz_wiringdiagram` */

DROP TABLE IF EXISTS `t_biz_wiringdiagram`;

CREATE TABLE `t_biz_wiringdiagram` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) NOT NULL COMMENT '图片id',
  `transformer_id` int(11) NOT NULL COMMENT '变电站id',
  `verify_status` varchar(2) NOT NULL DEFAULT '0' COMMENT '审核状态：0-待审核，1-审核通过，9审核不通过',
  `verify_time` datetime DEFAULT NULL COMMENT '审核时间',
  `verify_user` varchar(100) DEFAULT NULL COMMENT '审核人',
  `verify_content` varchar(500) DEFAULT NULL COMMENT '审核结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='接线图';

/*Data for the table `t_biz_wiringdiagram` */

insert  into `t_biz_wiringdiagram`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`transformer_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (1,'接线图1','2017-09-18 18:08:44','1','fadaf527-b24d-4046-a28f-a2e2604301b9',3,'0',NULL,NULL,NULL);
insert  into `t_biz_wiringdiagram`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`transformer_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (2,'接线图2','2017-09-19 10:28:19','1','eb066311-5d7f-4c1a-910c-be545d86e52b',3,'0',NULL,NULL,NULL);
insert  into `t_biz_wiringdiagram`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`transformer_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (3,'接线图3','2017-09-19 10:30:33','1','39ea2bcf-9917-41d1-ba88-a2b05afd223b',3,'1','2017-10-27 16:53:07','1','');

/*Table structure for table `t_system_config` */

DROP TABLE IF EXISTS `t_system_config`;

CREATE TABLE `t_system_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user` varchar(100) NOT NULL COMMENT '更新时间',
  `module_id` varchar(50) NOT NULL COMMENT '模块id',
  `module_desc` varchar(200) NOT NULL COMMENT '模块描述',
  `type` varchar(50) NOT NULL COMMENT '类型:1-文字，2-图片',
  `key` varchar(200) NOT NULL COMMENT '唯一类型',
  `content` text NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_system_config` */

insert  into `t_system_config`(`id`,`update_time`,`update_user`,`module_id`,`module_desc`,`type`,`key`,`content`) values (1,'2017-10-30 17:59:55','1','index','首页','1','左侧文字','濮阳市变电站简介。\n    （请到系统管理-参数配置页面修改内容）');
insert  into `t_system_config`(`id`,`update_time`,`update_user`,`module_id`,`module_desc`,`type`,`key`,`content`) values (2,'2017-10-30 22:29:16','1','index','首页','2','右侧图片','e03c5c7f-d420-4d43-a05d-e54acc3dc1ee');

/* Function  structure for function  `getDeviceTypeNameById` */

/*!50003 DROP FUNCTION IF EXISTS `getDeviceTypeNameById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getDeviceTypeNameById`(device_id INT) RETURNS varchar(200) CHARSET utf8
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

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getDicValue`(cv VARCHAR(100), ct VARCHAR(40)) RETURNS varchar(200) CHARSET utf8
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

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getusername`(userid VARCHAR(100)) RETURNS varchar(200) CHARSET utf8
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
